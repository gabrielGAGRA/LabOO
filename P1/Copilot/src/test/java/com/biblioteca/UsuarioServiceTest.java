import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.biblioteca.model.Usuario;
import com.biblioteca.service.UsuarioService;

public class UsuarioServiceTest {
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        usuarioService = new UsuarioService();
    }

    @Test
    public void testAddUsuario() {
        Usuario usuario = new Usuario("João Silva", "12345678900", "Rua A, 123", "01/01/1990");
        usuarioService.addUsuario(usuario);
        assertNotNull(usuarioService.findUsuarioById(usuario.getId()));
    }

    @Test
    public void testFindUsuarioByName() {
        Usuario usuario = new Usuario("Maria Oliveira", "98765432100", "Rua B, 456", "02/02/1992");
        usuarioService.addUsuario(usuario);
        assertEquals(usuario, usuarioService.findUsuarioByName("Maria"));
    }

    @Test
    public void testFindUsuarioById() {
        Usuario usuario = new Usuario("Carlos Pereira", "12312312300", "Rua C, 789", "03/03/1985");
        usuarioService.addUsuario(usuario);
        assertEquals(usuario, usuarioService.findUsuarioById(usuario.getId()));
    }

    @Test
    public void testImpedimentoUsuario() {
        Usuario usuario = new Usuario("Ana Costa", "32132132100", "Rua D, 101", "04/04/1980");
        usuarioService.addUsuario(usuario);
        usuario.setImpedimento(5); // 5 days of impediment
        assertTrue(usuario.isImpedido());
    }

    @Test
    public void testUsuarioAllowedToBorrow() {
        Usuario usuario = new Usuario("Pedro Santos", "45645645600", "Rua E, 202", "05/05/1975");
        usuarioService.addUsuario(usuario);
        assertTrue(usuarioService.isUsuarioAllowedToBorrow(usuario));
    }
}