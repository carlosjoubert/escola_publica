package com.cjrock.geo.repository;

import com.cjrock.geo.model.Aluno;
import com.cjrock.geo.model.HistoricoFrequencia;
import com.cjrock.geo.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoricoFrequenciaRepository extends JpaRepository<HistoricoFrequencia, Integer> {
    @Override
    List<HistoricoFrequencia> findAll();
    Optional<HistoricoFrequencia> findById(Integer id);
    Optional<HistoricoFrequencia> findByAluno(Aluno aluno);
    Optional<HistoricoFrequencia> findByTurmaDisciplina(TurmaDisciplina turmaDisciplina);
    Optional<HistoricoFrequencia> findByQtdFaltas(Integer qtdFaltas);
    Optional<HistoricoFrequencia> findByAlunoAndTurmaDisciplina(Aluno aluno, TurmaDisciplina turmaDisciplina);
}
