/**
 * Classe responsável pelas regras de negócio do cadastro de usuário.
 *
 * ========================================================
 * CICLO TDD — FASE GREEN (Implementação mínima para os testes passarem)
 * ========================================================
 * Após escrever os testes em UsuarioServiceTest.java (fase RED),
 * implementamos aqui o código mínimo necessário para que todos
 * os testes passem com sucesso.
 *
 * Em seguida, o código foi revisado e organizado — fase REFACTOR.
 * ========================================================
 */
public class UsuarioService {

    /**
     * Valida e cadastra um usuário com base nas regras definidas.
     *
     * Regras de validação:
     *  - Nome não pode ser nulo ou vazio.
     *  - CPF deve ter exatamente 11 caracteres.
     *  - Data de nascimento não pode ser nula ou vazia.
     *  - E-mail deve conter o caractere "@".
     *  - Senha deve ter pelo menos 6 caracteres.
     *
     * @param usuario Objeto Usuario com os dados a serem validados.
     * @return true se o cadastro for válido, false caso contrário.
     */
    public boolean cadastrar(Usuario usuario) {

        // Valida o nome
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            return false;
        }

        // Valida o CPF (deve ter exatamente 11 caracteres)
        if (usuario.getCpf() == null || usuario.getCpf().length() != 11) {
            return false;
        }

        // Valida a data de nascimento
        if (usuario.getDataNascimento() == null || usuario.getDataNascimento().trim().isEmpty()) {
            return false;
        }

        // Valida o e-mail (deve conter "@")
        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            return false;
        }

        // Valida a senha (deve ter pelo menos 6 caracteres)
        if (usuario.getSenha() == null || usuario.getSenha().length() < 6) {
            return false;
        }

        // Todos os dados são válidos
        return true;
    }
}
