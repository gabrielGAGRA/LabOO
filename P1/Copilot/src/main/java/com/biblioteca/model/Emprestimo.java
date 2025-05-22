package com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataRetornoDevido;
    private LocalDate dataDevolucao;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataRetornoDevido = calcularDataRetornoDevido();
        this.dataDevolucao = null;
    }

    private LocalDate calcularDataRetornoDevido() {
        if (livro.getTipo() == TipoLivro.RECENTE) {
            return dataEmprestimo.plusDays(30);
        } else if (livro.getTipo() == TipoLivro.COLECAO) {
            return dataEmprestimo.plusDays(60);
        } else {
            return null; // Livros de consulta não podem ser emprestados
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataRetornoDevido() {
        return dataRetornoDevido;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void registrarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isAtrasado() {
        return dataDevolucao == null && LocalDate.now().isAfter(dataRetornoDevido);
    }

    public long diasAtraso() {
        if (isAtrasado()) {
            return LocalDate.now().toEpochDay() - dataRetornoDevido.toEpochDay();
        }
        return 0;
    }
}