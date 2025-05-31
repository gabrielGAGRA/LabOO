package LabOO.P2.Prova.src;
//Os livros são classificados em recentes, de coleção ou de consulta. 

import java.util.Random;

public class Livro_Colecao extends Livro {
    static final int podeEmprestar = 1;
    static final int diasRetornoLivro = 60;

    Livro_Colecao(String titulo, String autor, String editora, int anoPublicacao, String ISBN_ISSN, int numeroPaginas,
            int edicao) {
        super(titulo, autor, editora, anoPublicacao, ISBN_ISSN, numeroPaginas, edicao);
        Random numero = new Random();
        this.setNumeroIdentificador(numero.nextInt());
    }

    public String toString() {
        return super.toString();
    }
}
