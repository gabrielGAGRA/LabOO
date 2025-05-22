package com.biblioteca.service;

import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import com.biblioteca.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {
    private List<Emprestimo> emprestimos;

    public EmprestimoService() {
        this.emprestimos = new ArrayList<>();
    }

    public void criarEmprestimo(Usuario usuario, Livro livro) {
        if (usuario.isImpedido()) {
            throw new IllegalStateException("Usuário está impedido de realizar novos empréstimos.");
        }
        if (quantidadeEmprestimosAtivos(usuario) >= 3) {
            throw new IllegalStateException("Usuário já possui o máximo de empréstimos ativos.");
        }

        Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(novoEmprestimo);
    }

    public void renovarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo.getLivro().isColecao()) {
            if (emprestimo.getNumeroRenovacoes() >= 2) {
                throw new IllegalStateException("Empréstimo de livro de coleção já foi renovado o máximo de vezes.");
            }
        } else {
            if (emprestimo.getNumeroRenovacoes() >= 1) {
                throw new IllegalStateException("Empréstimo de livro recente já foi renovado.");
            }
        }

        emprestimo.renovar(DateUtils.calcularNovaDataRetorno(emprestimo));
    }

    public void registrarDevolucao(Emprestimo emprestimo) {
        emprestimo.devolver();
        if (emprestimo.isAtrasado()) {
            int diasAtraso = emprestimo.calcularDiasAtraso();
            emprestimo.getUsuario().aplicarImpedimento(diasAtraso);
        }
    }

    public List<Emprestimo> listarEmprestimosAtrasados() {
        List<Emprestimo> atrasados = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.isAtrasado()) {
                atrasados.add(emprestimo);
            }
        }
        return atrasados;
    }

    public List<Emprestimo> listarEmprestimosAtivosPorUsuario(Usuario usuario) {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && !emprestimo.isDevolvido()) {
                ativos.add(emprestimo);
            }
        }
        return ativos;
    }

    private int quantidadeEmprestimosAtivos(Usuario usuario) {
        return (int) emprestimos.stream()
                .filter(emprestimo -> emprestimo.getUsuario().equals(usuario) && !emprestimo.isDevolvido())
                .count();
    }
}