import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a classe UsuarioService.
 *
 * ========================================================
 * CICLO TDD APLICADO NESTE ARQUIVO:
 *
 * [RED]    → Os testes foram escritos ANTES da implementação.
 *            Neste momento, UsuarioService ainda não existia,
 *            então todos os testes falhavam ao compilar/executar.
 *
 * [GREEN]  → Após escrever os testes, implementamos o código mínimo
 *            em UsuarioService.java para que cada teste passasse.
 *
 * [REFACTOR] → Com todos os testes verdes, revisamos e organizamos
 *              o código de UsuarioService sem quebrar nenhum teste.
 * ========================================================
 */
public class UsuarioServiceTest {

    // Instância do serviço compartilhada entre os testes
    UsuarioService service = new UsuarioService();

    // ============================================================
    // [RED] Teste escrito primeiro — UsuarioService ainda não existia.
    // [GREEN] Passou após implementar cadastrar() com todas as validações.
    // [REFACTOR] Nenhuma mudança necessária neste teste.
    // ============================================================
    @Test
    public void cadastroValido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertTrue(resultado, "Cadastro com dados válidos deve retornar true.");
    }

    // ============================================================
    // [RED] Teste escrito para checar nome vazio — falhou inicialmente.
    // [GREEN] Passou após adicionar validação de nome em cadastrar().
    // [REFACTOR] Clareza mantida com trim() para cobrir espaços em branco.
    // ============================================================
    @Test
    public void cadastroComNomeVazio() {
        Usuario usuario = new Usuario(
            "",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com nome vazio deve retornar false.");
    }

    // ============================================================
    // [RED] Teste escrito para CPF com menos de 11 dígitos — falhou.
    // [GREEN] Passou após adicionar validação de comprimento do CPF.
    // [REFACTOR] Validação unificada com checagem de nulo e tamanho.
    // ============================================================
    @Test
    public void cadastroComCpfInvalido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "123",       // CPF inválido: menos de 11 caracteres
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com CPF inválido deve retornar false.");
    }

    // ============================================================
    // [RED] Teste escrito para e-mail sem "@" — falhou inicialmente.
    // [GREEN] Passou após adicionar verificação de contains("@").
    // [REFACTOR] Sem alterações necessárias.
    // ============================================================
    @Test
    public void cadastroComEmailInvalido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "mariaemail.com",   // E-mail inválido: sem "@"
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com e-mail inválido deve retornar false.");
    }

    // ============================================================
    // [RED] Teste escrito para senha curta — falhou inicialmente.
    // [GREEN] Passou após adicionar validação de tamanho mínimo da senha.
    // [REFACTOR] Sem alterações necessárias.
    // ============================================================
    @Test
    public void cadastroComSenhaCurta() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "123"   // Senha inválida: menos de 6 caracteres
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com senha curta deve retornar false.");
    }

    // ============================================================
    // [RED] Teste escrito para data de nascimento vazia — falhou.
    // [GREEN] Passou após adicionar validação de data em cadastrar().
    // [REFACTOR] Trim() adicionado para capturar strings só com espaços.
    // ============================================================
    @Test
    public void cadastroComDataNascimentoVazia() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "",             // Data de nascimento vazia
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com data de nascimento vazia deve retornar false.");
    }
}
