package com.cjrock.geo.repository;

import com.cjrock.geo.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findAll();
    Optional<Turma> findById(Long id);
    Optional<Turma> findBySerie(String serie);
    Optional<Turma> findByTurma(String turma);
    Optional<Turma> findByFase(String fase);
    Optional<Turma> findByTurno(String turno);
    Optional<Turma> findByEscola(String escola);

}
