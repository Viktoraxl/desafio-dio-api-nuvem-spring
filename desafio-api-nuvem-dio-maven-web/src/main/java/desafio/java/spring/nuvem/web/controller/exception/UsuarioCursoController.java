package desafio.java.spring.nuvem.web.controller.exception;

import desafio.java.spring.nuvem.web.domain.model.Curso;
import desafio.java.spring.nuvem.web.domain.model.Usuario;
import desafio.java.spring.nuvem.web.service.CursoService;
import desafio.java.spring.nuvem.web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UsuarioCursoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("API is working");
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<?> listarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuarioAtualizado));
    }

    @GetMapping("/cursos")
    public ResponseEntity<?> listarTodosCursos() {
        return ResponseEntity.ok(cursoService.listarTodosCursos());
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<?> buscarCursoPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.buscarCursoPorId(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cursos")
    public ResponseEntity<?> salvarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.salvarCurso(curso));
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<?> atualizarCurso(@PathVariable Long id, @RequestBody Curso cursoAtualizado) {
        return ResponseEntity.ok(cursoService.atualizarCurso(id, cursoAtualizado));
    }

    @PostMapping("/usuarios/{usuarioId}/cursos/{cursoId}")
    public ResponseEntity<?> inscreverUsuarioEmCurso(@PathVariable Long usuarioId, @PathVariable Long cursoId) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarUsuarioPorId(usuarioId);
        Optional<Curso> cursoOpt = cursoService.buscarCursoPorId(cursoId);

        if (usuarioOpt.isPresent() && cursoOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            Curso curso = cursoOpt.get();
            usuario.getCursos().add(curso);
            usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuarios/{usuarioId}/cursos")
    public ResponseEntity<?> listarCursosDoUsuario(@PathVariable Long usuarioId) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarUsuarioPorId(usuarioId);
        if (usuarioOpt.isPresent()) {
            Set<Curso> cursos = usuarioOpt.get().getCursos();
            return ResponseEntity.ok(cursos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
