
public class UsuarioService {

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
