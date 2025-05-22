import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.biblioteca.model.Usuario;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.service.EmprestimoService;

import java.time.LocalDate;

public class EmprestimoServiceTest {

    private EmprestimoService emprestimoService;
    private Usuario usuario;
    private Livro livro;

    @BeforeEach
    public void setUp() {
        emprestimoService = new EmprestimoService();
        usuario = new Usuario("123456789", "João Silva", LocalDate.of(1990, 1, 1), "Rua A, 123");
        livro = new Livro("Título do Livro", "Autor do Livro", "Editora do Livro", 2021, "1234567890123", 300, "1ª Edição", "recente");
    }

    @Test
    public void testCriarEmprestimo() {
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(usuario, livro);
        assertNotNull(emprestimo);
        assertEquals(usuario, emprestimo.getUsuario());
        assertEquals(livro, emprestimo.getLivro());
        assertEquals(LocalDate.now().plusDays(30), emprestimo.getDataRetornoDevido());
    }

    @Test
    public void testRenovarEmprestimo() {
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(usuario, livro);
        emprestimoService.renovarEmprestimo(emprestimo);
        assertEquals(LocalDate.now().plusDays(60), emprestimo.getDataRetornoDevido());
    }

    @Test
    public void testRegistrarDevolucao() {
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(usuario, livro);
        emprestimoService.registrarDevolucao(emprestimo);
        assertNotNull(emprestimo.getDataDevolucao());
    }

    @Test
    public void testListarEmprestimosAtrasados() {
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(usuario, livro);
        emprestimo.setDataRetornoDevido(LocalDate.now().minusDays(1)); // Simula atraso
        emprestimoService.registrarDevolucao(emprestimo);
        assertTrue(emprestimoService.listarEmprestimosAtrasados().contains(emprestimo));
    }

    @Test
    public void testLimiteEmprestimos() {
        for (int i = 0; i < 3; i++) {
            emprestimoService.criarEmprestimo(usuario, livro);
        }
        Exception exception = assertThrows(RuntimeException.class, () -> {
            emprestimoService.criarEmprestimo(usuario, livro);
        });
        assertEquals("Limite de empréstimos atingido", exception.getMessage());
    }
}