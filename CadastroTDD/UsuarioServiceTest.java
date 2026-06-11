import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServiceTest {

    // Instância do serviço compartilhada entre os testes
    UsuarioService service = new UsuarioService();

    // Cadastro com todos os dados válidos
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

    // Nome vazio
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

    // CPF com menos de 11 caracteres
    @Test
    public void cadastroComCpfInvalido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "123",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com CPF inválido deve retornar false.");
    }

    // E-mail sem @
    @Test
    public void cadastroComEmailInvalido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "mariaemail.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com e-mail inválido deve retornar false.");
    }

    // Senha com menos de 6 caracteres
    @Test
    public void cadastroComSenhaCurta() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com senha curta deve retornar false.");
    }

    // Data de nascimento vazia
    @Test
    public void cadastroComDataNascimentoVazia() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Cadastro com data de nascimento vazia deve retornar false.");
    }

    // CPF com mais de 11 caracteres
    @Test
    public void cadastroComCpfMuitoLongo() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "123456789012",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "CPF com mais de 11 caracteres deve retornar false.");
    }

    // CPF com letras
    @Test
    public void cadastroComCpfComLetras() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "1234567890a",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "CPF com letras deve retornar false.");
    }

    // CPF nulo
    @Test
    public void cadastroComCpfNulo() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            null,
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "CPF nulo deve retornar false.");
    }

    // Nome só com espaços
    @Test
    public void cadastroComNomeSoEspacos() {
        Usuario usuario = new Usuario(
            "   ",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Nome só com espaços deve retornar false.");
    }

    // Nome nulo
    @Test
    public void cadastroComNomeNulo() {
        Usuario usuario = new Usuario(
            null,
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Nome nulo deve retornar false.");
    }

    // E-mail vazio
    @Test
    public void cadastroComEmailVazio() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "E-mail vazio deve retornar false.");
    }

    // E-mail nulo
    @Test
    public void cadastroComEmailNulo() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            null,
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "E-mail nulo deve retornar false.");
    }

    // E-mail só com @
    @Test
    public void cadastroComEmailSoArroba() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "@",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "E-mail só com @ deve retornar false.");
    }

    // E-mail com @ no final
    @Test
    public void cadastroComEmailArrobaNoFinal() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "E-mail com @ no final deve retornar false.");
    }

    // Senha com exatamente 5 caracteres (deve falhar)
    @Test
    public void cadastroComSenhaComCincoCaracteres() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "12345"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Senha com 5 caracteres deve retornar false.");
    }

    // Senha com exatamente 6 caracteres (deve passar)
    @Test
    public void cadastroComSenhaComSeisCaracteres() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            "123456"
        );

        boolean resultado = service.cadastrar(usuario);

        assertTrue(resultado, "Senha com exatamente 6 caracteres deve retornar true.");
    }

    // Senha nula
    @Test
    public void cadastroComSenhaNula() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "01/01/2000",
            "maria@email.com",
            null
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Senha nula deve retornar false.");
    }

    // Data de nascimento nula
    @Test
    public void cadastroComDataNascimentoNula() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            null,
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Data nula deve retornar false.");
    }

    // Data de nascimento só com espaços
    @Test
    public void cadastroComDataNascimentoSoEspacos() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "12345678901",
            "   ",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Data só com espaços deve retornar false.");
    }

    // Todos os campos vazios
    @Test
    public void cadastroComTodosCamposVazios() {
        Usuario usuario = new Usuario(
            "",
            "",
            "",
            "",
            ""
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Todos os campos vazios deve retornar false.");
    }

    // Todos os campos nulos
    @Test
    public void cadastroComTodosCamposNulos() {
        Usuario usuario = new Usuario(
            null,
            null,
            null,
            null,
            null
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Todos os campos nulos deve retornar false.");
    }

    // Só o nome válido, resto inválido
    @Test
    public void cadastroComSoNomeValido() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "123",
            "",
            "emailsemarroba",
            "123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "Só nome válido deve retornar false.");
    }

    // Tudo válido exceto o CPF
    @Test
    public void cadastroComTudoValidoExcetoCpf() {
        Usuario usuario = new Usuario(
            "Maria Silva",
            "123",
            "01/01/2000",
            "maria@email.com",
            "senha123"
        );

        boolean resultado = service.cadastrar(usuario);

        assertFalse(resultado, "CPF inválido com resto válido deve retornar false.");
    }
}