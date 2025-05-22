package com.biblioteca.service;

import com.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros;

    public LivroService() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public List<Livro> listarLivros() {
        return new ArrayList<>(livros);
    }
}