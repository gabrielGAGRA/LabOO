package LabOO.P2.Prova.src;
//Os livros são classificados em recentes, de coleção ou de consulta. 

import java.util.Random;

public class Livro_Consulta extends Livro {
    // Livros de consulta não podem ser emprestados.
    Livro_Consulta(String titulo, String autor, String editora, int anoPublicacao, String ISBN_ISSN, int numeroPaginas,
            int edicao) {
        super(titulo, autor, editora, anoPublicacao, ISBN_ISSN, numeroPaginas, edicao);
        Random numero = new Random();
        this.setNumeroIdentificador(numero.nextInt());
    }

    public String toString() {
        return super.toString();
    }
}
