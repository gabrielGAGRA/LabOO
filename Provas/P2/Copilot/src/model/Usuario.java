
package LabOO.Provas.P2.Copilot.src.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private static int PROX_ID = 1;
    private final int id;
    private final String idPessoal;
    private final String nome;
    private final LocalDate dataNascimento;
    private final String endereco;
    private LocalDate embargoAte = LocalDate.MIN;
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String idPessoal, String nome, LocalDate dataNascimento, String endereco) {
        this.id = PROX_ID++;
        this.idPessoal = idPessoal;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getEmbargoAte() {
        return embargoAte;
    }

    public void setEmbargoAte(LocalDate data) {
        if (data.isAfter(embargoAte))
            embargoAte = data;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        List<Emprestimo> r = new ArrayList<>();
        for (Emprestimo e : emprestimos)
            if (!e.isDevolvido())
                r.add(e);
        return r;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }
}