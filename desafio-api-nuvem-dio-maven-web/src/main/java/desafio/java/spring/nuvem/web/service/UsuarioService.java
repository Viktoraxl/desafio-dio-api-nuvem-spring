package desafio.java.spring.nuvem.web.service;

import java.util.List;
import java.util.Optional;

import desafio.java.spring.nuvem.web.domain.model.Usuario;

public interface UsuarioService {
    List<Usuario> listarTodosUsuarios();
    Optional<Usuario> buscarUsuarioPorId(Long id);
    Usuario salvarUsuario(Usuario usuario);
    void deletarUsuario(Long id);
    Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado);
}
