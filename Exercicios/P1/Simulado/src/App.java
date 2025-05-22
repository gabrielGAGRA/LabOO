import java.util.ArrayList;

public class App {
    /*
     * Escreva um programa main() que crie uma biblioteca com 10 músicas em
     * diferentes formatos e que depois
     * exercite uma busca por músicas dos anos 90, imprimindo a lista.
     * A impressão deve mostrar as informações armazenadas em todos os atributos dos
     * objetos.
     */
    public static void main(String[] args) {
        Musica_CD Rihanna = new Musica_CD("musicaRihanna", "albumRihanna", "Rihanna", "Rihanna", 2006, 100);
        Musica_CD KatyPerry = new Musica_CD("musicaKatyPerry", "albumKatyPerry", "KatyPerry", "KatyPerry", 2008, 120);
        Musica_CD JustinBieber = new Musica_CD("musicaJustinBieber", "albumJustinBieber", "JustinBieber",
                "JustinBieber", 2010, 90);
        Musica_LP ElvisPresley = new Musica_LP("musicaElvisPresley", "albumElvisPresley", "ElvisPresley",
                "ElvisPresley", 1956, 80);
        Musica_LP MichaelJackson = new Musica_LP("musicaMichaelJackson", "albumMichaelJackson", "MichaelJackson",
                "MichaelJackson", 1982, 110);
        Musica_LP Queen = new Musica_LP("musicaQueen", "albumQueen", "Queen", "Queen", 1975, 95);
        Musica_MP3 ArianaGrande = new Musica_MP3("musicaArianaGrande", "albumArianaGrande", "ArianaGrande",
                "ArianaGrande", 2013, 105);
        Musica_MP3 TaylorSwift = new Musica_MP3("musicaTaylorSwift", "albumTaylorSwift", "TaylorSwift", "TaylorSwift",
                2006, 85);
        Musica_MP3 ArcticMonkeys = new Musica_MP3("musicaArcticMonkeys", "albumArcticMonkeys", "ArcticMonkeys",
                "ArcticMonkeys", 2006, 115);
        Musica_MP3 TheWeekend = new Musica_MP3("musicaTheWeekend", "albumTheWeekend", "TheWeekend", "TheWeekend", 2015,
                100);

        ArrayList musicas = buscaMusicas();

    }
}
