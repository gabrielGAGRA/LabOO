package LabOO.P2.Prova.src;

import java.util.Random;

public class Livro_Recente extends Livro {
    static final int podeEmprestar = 1;
    static final int diasRetornoLivro = 30;

    Livro_Recente(String titulo, String autor, String editora, int anoPublicacao, String ISBN_ISSN, int numeroPaginas,
            int edicao) {
        super(titulo, autor, editora, anoPublicacao, ISBN_ISSN, numeroPaginas, edicao);
        Random numero = new Random();
        this.setNumeroIdentificador(numero.nextInt());
    }

    public String toString() {
        return super.toString();
    }
}
