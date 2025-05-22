import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;

import java.util.List;

public class LivroServiceTest {

    private LivroService livroService;

    @BeforeEach
    public void setUp() {
        livroService = new LivroService();
    }

    @Test
    public void testAddLivro() {
        Livro livro = new Livro("Título", "Autor", "Editora", 2023, "ISBN123", 300, "1ª Edição", "recente");
        livroService.addLivro(livro);
        List<Livro> livros = livroService.getAllLivros();
        assertEquals(1, livros.size());
        assertEquals("Título", livros.get(0).getTitulo());
    }

    @Test
    public void testGetLivroById() {
        Livro livro = new Livro("Título", "Autor", "Editora", 2023, "ISBN123", 300, "1ª Edição", "recente");
        livroService.addLivro(livro);
        Livro foundLivro = livroService.getLivroById(livro.getId());
        assertNotNull(foundLivro);
        assertEquals("Título", foundLivro.getTitulo());
    }

    @Test
    public void testGetAllLivros() {
        Livro livro1 = new Livro("Título 1", "Autor 1", "Editora 1", 2023, "ISBN123", 300, "1ª Edição", "recente");
        Livro livro2 = new Livro("Título 2", "Autor 2", "Editora 2", 2023, "ISBN456", 250, "2ª Edição", "coleção");
        livroService.addLivro(livro1);
        livroService.addLivro(livro2);
        List<Livro> livros = livroService.getAllLivros();
        assertEquals(2, livros.size());
    }

    @Test
    public void testRemoveLivro() {
        Livro livro = new Livro("Título", "Autor", "Editora", 2023, "ISBN123", 300, "1ª Edição", "recente");
        livroService.addLivro(livro);
        livroService.removeLivro(livro.getId());
        assertNull(livroService.getLivroById(livro.getId()));
    }
}