package desafio.java.spring.nuvem.web.service.serviceIpl;

import desafio.java.spring.nuvem.web.domain.model.Usuario;
import desafio.java.spring.nuvem.web.domain.repository.UsuarioRepository;
import desafio.java.spring.nuvem.web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            return usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com id: " + id);
        }
    }
}

