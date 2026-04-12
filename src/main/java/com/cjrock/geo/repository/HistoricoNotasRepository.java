package com.cjrock.geo.repository;

import com.cjrock.geo.model.Aluno;
import com.cjrock.geo.model.HistoricoNotas;
import com.cjrock.geo.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoricoNotasRepository extends JpaRepository<HistoricoNotas, Integer> {
    @Override
    List<HistoricoNotas> findAll();
    Optional<HistoricoNotas> findById(Integer id);
    Optional<HistoricoNotas> findByAluno(Aluno aluno);
    Optional<HistoricoNotas> findByTurmaDisciplina(TurmaDisciplina turmaDisciplina);
    Optional<HistoricoNotas> findByNota(Double nota);
    Optional<HistoricoNotas> findByCredito(Integer credito);
    Optional<HistoricoNotas> findByTrimestre(Integer trimestre);
    Optional<HistoricoNotas> findByCreditoAndTrimestre(Integer credito, Integer trimestre);
    Optional<HistoricoNotas> findByAlunoAndTurmaDisciplina(Aluno aluno, TurmaDisciplina turmaDisciplina);
    Optional<HistoricoNotas> findByTurmaDisciplinaAndNota(TurmaDisciplina turmaDisciplina, Double nota);
    Optional<HistoricoNotas> findByNotaAndTurmaDisciplina(Double nota, TurmaDisciplina turmaDisciplina);

}
