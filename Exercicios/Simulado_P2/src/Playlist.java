package LabOO.Exercicios.Simulado_P2.src;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Musica> playlistMusicas = new ArrayList<>();

    public void adicionar(Musica musica) {
        playlistMusicas.add(musica);
    }

    public List<Musica> buscarPorTitulo(String titulo) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica musica : playlistMusicas) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(musica);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorCompositor(String compositor) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica musica : playlistMusicas) {
            if (musica.getCompositor().equalsIgnoreCase(compositor)) {
                resultado.add(musica);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorInterprete(String interprete) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica musica : playlistMusicas) {
            if (musica.getIntérprete().equalsIgnoreCase(interprete)) {
                resultado.add(musica);
            }
        }
        return resultado;
    }

    public List<Musica> buscarPorPeriodo(int anoIni, int anoFim) {
        List<Musica> resultado = new ArrayList<>();
        for (Musica musica : playlistMusicas) {
            if (musica.getAno() >= anoIni && musica.getAno() <= anoFim) {
                resultado.add(musica);
            }
        }
        return resultado;
    }

    public List<Musica_MP3> buscarMP3PorTamanhoMinimo(int tamanhoMinimo) {
        List<Musica_MP3> resultado = new ArrayList<>();
        for (Musica musica : playlistMusicas) {
            if (musica instanceof Musica_MP3) {
                Musica_MP3 mp3 = (Musica_MP3) musica;
                if (mp3.getTamanho() > tamanhoMinimo) {
                    resultado.add(mp3);
                }
            }
        }
        return resultado;
    }
}