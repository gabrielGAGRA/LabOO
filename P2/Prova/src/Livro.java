package LabOO.P2.Prova.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Livros possuem um número único identificador de cadastro do patrimônio, gerado automaticamente quando o livro é cadastrado,
além de informações de publicação como título, autor, editora, ano de publicação, ISBN ou ISSN, número de páginas e edição. 
Note que a biblioteca pode possuir múltiplas cópias de um mesmo livro; 
cada cópia deve possuir um identificador distinto, porém compartilhar as demais informações.
*/
class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String ISBN_ISSN;
    private int numeroPaginas;
    private int edicao;
    private int numeroIdentificador;
    private int copiasLivro = 1;
    // Regras diferentes se aplicam para empréstimos de livros recentes ou de
    // coleção.
    static final int podeEmprestar = 0;
    static final int diasRetornoLivro = 0;

    private final List<Integer> identificadoresCopias = new ArrayList<>();

    // CRÉDITOS (nao copiei, mas pesquisei):
    // https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
    private Random numero = new Random();

    // O sistema deve permitir cadastrar novos livros.
    Livro(String titulo, String autor, String editora, int anoPublicacao, String ISBN_ISSN, int numeroPaginas,
            int edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.ISBN_ISSN = ISBN_ISSN;
        this.numeroPaginas = numeroPaginas;
        this.edicao = edicao;
        this.numeroIdentificador = numero.nextInt();
    }

    /*
     * Note que a biblioteca pode possuir múltiplas cópias de um mesmo livro; cada
     * cópia deve possuir um identificador distinto, porém compartilhar as demais
     * informações.
     */
    public void criarCopia() {
        identificadoresCopias.add(numero.nextInt());
        copiasLivro += 1;
        System.out.println("Copia criada, temos agora " + copiasLivro + " livros");
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

}
