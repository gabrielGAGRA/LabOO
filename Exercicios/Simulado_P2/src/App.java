package LabOO.Exercicios.Simulado_P2.src;

import java.util.List;

public class App {
        /*
         * Escreva um programa main() que crie uma biblioteca com 10 músicas em
         * diferentes formatos e que depois exercite uma busca por músicas dos anos 90,
         * imprimindo a lista. A impressão deve mostrar as informações armazenadas em
         * todos os atributos dos objetos.
         */
        public static void main(String[] args) {

                Playlist playlistMusicas = new Playlist();

                playlistMusicas.adicionar(new Musica_CD("musicaRihanna", "albumRihanna", "Rihanna", "Rihanna", 2006));
                playlistMusicas.adicionar(
                                new Musica_CD("musicaKatyPerry", "albumKatyPerry", "KatyPerry", "KatyPerry", 2008));
                playlistMusicas.adicionar(new Musica_CD("musicaJustinBieber", "albumJustinBieber", "JustinBieber",
                                "JustinBieber", 2010));
                playlistMusicas.adicionar(new Musica_LP("musicaElvisPresley", "albumElvisPresley", "ElvisPresley",
                                "ElvisPresley", 1956, 80));
                playlistMusicas.adicionar(new Musica_LP("musicaMichaelJackson", "albumMichaelJackson", "MichaelJackson",
                                "MichaelJackson", 1982, 110));
                playlistMusicas.adicionar(new Musica_LP("musicaQueen", "albumQueen", "Queen", "Queen", 1975, 95));
                playlistMusicas.adicionar(new Musica_MP3("musicaArianaGrande", "albumArianaGrande", "ArianaGrande",
                                "ArianaGrande", 2013, 105));
                playlistMusicas.adicionar(new Musica_MP3("musicaTaylorSwift", "albumTaylorSwift", "TaylorSwift",
                                "TaylorSwift", 2006, 85));
                playlistMusicas.adicionar(new Musica_MP3("musicaArcticMonkeys", "albumArcticMonkeys", "ArcticMonkeys",
                                "ArcticMonkeys", 2006, 115));
                playlistMusicas.adicionar(new Musica_MP3("musicaTheWeekend", "albumTheWeekend", "TheWeekend",
                                "TheWeekend", 2015, 100));

                List<Musica> anos90 = playlistMusicas.buscarPorPeriodo(1990, 1999);
                for (Musica m : anos90) {
                        System.out.println(m);
                }

        }
}
