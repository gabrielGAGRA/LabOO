package service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import model.*;

public class Biblioteca {
    private final Map<Integer, Usuario> usuarios = new HashMap<>();
    private final Map<String, Livro> livros = new HashMap<>(); // chave: ISBN
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario adicionarUsuario(String idPessoal, String nome, LocalDate dataNasc, String endereco) {
        Usuario u = new Usuario(idPessoal, nome, dataNasc, endereco);
        usuarios.put(u.getId(), u);
        return u;
    }

    public Livro adicionarLivro(Livro l) {
        Livro livroExistente = livros.get(l.getIsbn());
        if (livroExistente != null) {
            livroExistente.adicionarCopia();
            return livroExistente;
        } else {
            l.adicionarCopia();
            livros.put(l.getIsbn(), l);
            return l;
        }
    }

    public Emprestimo emprestar(int usuarioId, String isbn, LocalDate hoje) {
        Usuario u = usuarios.get(usuarioId);
        Livro livro = livros.get(isbn);
        if (u.getEmbargoAte().isAfter(hoje))
            throw new IllegalStateException("Usuário em embargo até " + u.getEmbargoAte());
        if (u.getEmprestimosAtivos().size() >= 3)
            throw new IllegalStateException("Limite de empréstimos simultâneos");
        if (!livro.isEmprestavel())
            throw new IllegalStateException("Livro não disponível para empréstimo");
        Emprestimo emp = new Emprestimo(u, livro, hoje);
        u.adicionarEmprestimo(emp);
        emprestimos.add(emp);
        return emp;
    }

    public void renovar(int usuarioId, String isbn) {
        Emprestimo emp = encontrarEmprestimoAberto(usuarioId, isbn);
        emp.renovar();
    }

    public void devolver(int usuarioId, String isbn, LocalDate data) {
        Emprestimo emp = encontrarEmprestimoAberto(usuarioId, isbn);
        emp.devolver(data);
    }

    private Emprestimo encontrarEmprestimoAberto(int usuarioId, String isbn) {
        try {
            return emprestimos.stream().filter(
                    e -> e.getUsuario().getId() == usuarioId && e.getLivro().getIsbn().equals(isbn) && !e.isDevolvido())
                    .findFirst().orElseThrow(NoSuchElementException::new);
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Empréstimo não encontrado para o usuário e ISBN fornecidos.", e);
        }
    }

    public List<Emprestimo> listarAtrasados(LocalDate hoje) {
        return emprestimos.stream().filter(e -> e.isAtrasado(hoje)).collect(Collectors.toList());
    }

    public List<Emprestimo> listarEmprestimosAbertosUsuario(int usuarioId) {
        return emprestimos.stream().filter(e -> e.getUsuario().getId() == usuarioId && !e.isDevolvido())
                .collect(Collectors.toList());
    }
}