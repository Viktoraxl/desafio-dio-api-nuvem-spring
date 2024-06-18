package desafio.java.spring.nuvem.web.service;

import java.util.List;
import java.util.Optional;

import desafio.java.spring.nuvem.web.domain.model.Curso;

public interface CursoService {
    List<Curso> listarTodosCursos();
    Optional<Curso> buscarCursoPorId(Long id);
    Curso salvarCurso(Curso curso);
    void deletarCurso(Long id);
    Curso atualizarCurso(Long id, Curso cursoAtualizado);
}
