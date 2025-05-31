package LabOO.P2.Copilot.src.model;

import java.time.LocalDate;

public class Emprestimo {
    private final Usuario usuario;
    private final Livro livro;
    private final LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucao;
    private int renovacoes = 0;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        calcularDataDevolucao();
    }

    private void calcularDataDevolucao() {
        int dias = livro.getDiasEmprestimo();
        LocalDate d = dataEmprestimo.plusDays(dias);
        LocalDate dez24 = LocalDate.of(d.getYear(), 12, 24);
        LocalDate jan2 = LocalDate.of(d.getYear() + 1, 1, 2);
        if (!d.isBefore(dez24) && !d.isAfter(jan2))
            d = jan2;
        this.dataDevolucaoPrevista = d;
    }

    public boolean isDevolvido() {
        return dataDevolucao != null;
    }

    public boolean isAtrasado(LocalDate hoje) {
        return dataDevolucao == null && dataDevolucaoPrevista.isBefore(hoje);
    }

    public void renovar() {
        if (renovacoes >= livro.getMaxRenovacoes())
            throw new IllegalStateException("Limite de renovações atingido");
        renovacoes++;
        calcularDataDevolucao();
    }

    public void devolver(LocalDate data) {
        this.dataDevolucao = data;
        long atraso = java.time.temporal.ChronoUnit.DAYS.between(dataDevolucaoPrevista, data);
        if (atraso > 0) {
            int diasEmbargo = (int) atraso * 3;
            usuario.setEmbargoAte(data.plusDays(diasEmbargo));
        }
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getRenovacoes() {
        return renovacoes;
    }

    public long calcularDiasAtraso(LocalDate hoje) {
        if (dataDevolucao == null && dataDevolucaoPrevista.isBefore(hoje)) {
            return java.time.temporal.ChronoUnit.DAYS.between(dataDevolucaoPrevista, hoje);
        }
        return 0;
    }
}