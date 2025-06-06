package LabOO.Provas.P2.Copilot.src.model;

public abstract class Livro {
    private final String titulo;
    private final String autor;
    private final String editora;
    private final int ano;
    private final String isbn;
    private final int paginas;
    private final String edicao;
    private int copias = 0; // NOVO

    protected Livro(String titulo, String autor, String editora, int ano, String isbn, int paginas, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.isbn = isbn;
        this.paginas = paginas;
        this.edicao = edicao;
    }

    public void adicionarCopia() { // NOVO
        copias++;
    }

    public int getCopias() { // NOVO
        return copias;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract int getDiasEmprestimo();

    public abstract int getMaxRenovacoes();

    public abstract boolean isEmprestavel();

    public String getIsbn() {
        return isbn;
    }
}