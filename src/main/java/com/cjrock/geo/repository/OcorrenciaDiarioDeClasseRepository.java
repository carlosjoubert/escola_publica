package com.cjrock.geo.repository;

import com.cjrock.geo.model.Aluno;
import com.cjrock.geo.model.OcorrenciaDiarioDeClasse;
import com.cjrock.geo.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OcorrenciaDiarioDeClasseRepository extends JpaRepository<OcorrenciaDiarioDeClasse, Integer> {
    @Override
    List<OcorrenciaDiarioDeClasse> findAll();
    Optional<OcorrenciaDiarioDeClasse> findById(Integer id);
    Optional<OcorrenciaDiarioDeClasse> findByTurmaDisciplina(TurmaDisciplina turmaDisciplina);
    Optional<OcorrenciaDiarioDeClasse> findByConteudoPrevisto(String conteudoPrevisto);
    Optional<OcorrenciaDiarioDeClasse> findByConteudoRealizado(String conteudoRealizado);
    Optional<OcorrenciaDiarioDeClasse> findByDataHora(LocalDateTime dataHora);

}
