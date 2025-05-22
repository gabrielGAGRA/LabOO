package com.biblioteca.model;

public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String isbn;
    private int numeroPaginas;
    private String edicao;
    private String tipo; // pode ser "recente", "colecao" ou "consulta"

    public Livro(String id, String titulo, String autor, String editora, int anoPublicacao, String isbn, int numeroPaginas, String edicao, String tipo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", isbn='" + isbn + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", edicao='" + edicao + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}