package com.cjrock.geo.repository;

import com.cjrock.geo.model.Disciplina;
import com.cjrock.geo.model.Turma;
import com.cjrock.geo.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TurmaDisciplinaRepository extends JpaRepository<TurmaDisciplina, Integer> {
    @Override
    List<TurmaDisciplina> findAll();
    Optional<TurmaDisciplina> findById(Integer id);
    Optional<TurmaDisciplina> findByTurma(Turma turma);
    Optional<TurmaDisciplina> findByDisciplina(Disciplina disciplina);
    Optional<TurmaDisciplina> findByAnoLetivo(Integer anoLetivo);
    Optional<TurmaDisciplina> findByTurmaAndDisciplina(Turma turma, Disciplina disciplina);
    List<TurmaDisciplina> findAllByTurma(Turma turma);
    List<TurmaDisciplina> findAllByDisciplina(Disciplina disciplina);

}
