package desafio.java.spring.nuvem.web.service.serviceIpl;

import desafio.java.spring.nuvem.web.domain.model.Curso;
import desafio.java.spring.nuvem.web.domain.repository.CursoRepository;
import desafio.java.spring.nuvem.web.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> buscarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setTitulo(cursoAtualizado.getTitulo());
            curso.setDescricao(cursoAtualizado.getDescricao());
            curso.setPreco(cursoAtualizado.getPreco());
            return cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Curso não encontrado com id: " + id);
        }
    }
}
