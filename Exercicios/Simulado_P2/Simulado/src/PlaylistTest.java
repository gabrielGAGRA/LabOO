import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlaylistTest {

    private Playlist playlist;

    playlist=new Playlist();
    // Adicionar algumas músicas para teste
    playlist.adicionar(new Musica_CD("Musica CD1","Album CD1","Compositor A","Interprete X",2000));playlist.adicionar(new Musica_LP("Musica LP1","Album LP1","Compositor B","Interprete Y",1985,33));playlist.adicionar(new Musica_MP3("Musica MP3_1","Album MP3_1","Compositor A","Interprete Z",2010,5000));playlist.adicionar(new Musica_MP3("Musica MP3_2","Album MP3_2","Compositor C","Interprete X",1995,10000));

    @Test
    void buscarPorTituloExistente() {
        
        List<Musica> encontradas = playlist.buscarPorTitulo("Musica CD1");
        assertEquals(1, encontradas.size());
        assertEquals("Musica CD1", encontradas.get(0).getTitulo());
    }

    @Test
    void buscarPorTituloInexistente() {
        List<Musica> encontradas = playlist.buscarPorTitulo("Titulo Nao Existe");
        assertTrue(encontradas.isEmpty());
    }

    @Test
    void buscarPorCompositor() {
        List<Musica> encontradas = playlist.buscarPorCompositor("Compositor A");
        assertEquals(2, encontradas.size()); // CD1 e MP3_1
    }

    @Test
    void buscarPorInterprete() {
        List<Musica> encontradas = playlist.buscarPorInterprete("Interprete X");
        assertEquals(2, encontradas.size()); // CD1 e MP3_2
    }

    @Test
    void buscarPorPeriodo() {
        List<Musica> encontradas = playlist.buscarPorPeriodo(1990, 1999);
        assertEquals(1, encontradas.size());
        assertEquals("Musica MP3_2", encontradas.get(0).getTitulo());
    }

    @Test
    void buscarMP3PorTamanhoMinimo() {
        List<Musica_MP3> encontradas = playlist.buscarMP3PorTamanhoMinimo(6000);
        assertEquals(1, encontradas.size());
        assertEquals("Musica MP3_2", encontradas.get(0).getTitulo());
    }
}