package desafio.java.spring.nuvem.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import desafio.java.spring.nuvem.web.domain.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
