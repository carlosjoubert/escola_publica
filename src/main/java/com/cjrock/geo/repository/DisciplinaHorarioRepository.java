package com.cjrock.geo.repository;

import com.cjrock.geo.model.DisciplinaHorario;
import com.cjrock.geo.model.Horario;
import com.cjrock.geo.model.TurmaDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplinaHorarioRepository extends JpaRepository<DisciplinaHorario, Integer> {
    @Override
    List<DisciplinaHorario> findAll();
    Optional<DisciplinaHorario> findById(Integer id);
    Optional<DisciplinaHorario> findByHorario(Horario horario);
    Optional<DisciplinaHorario> findByTurmaDisciplina(TurmaDisciplina turmaDisciplina);
    Optional<DisciplinaHorario> findByHorarioAndTurmaDisciplina(Horario horario, TurmaDisciplina turmaDisciplina);
    Optional<DisciplinaHorario> findByTurmaDisciplinaAndHorario(TurmaDisciplina turmaDisciplina, Horario horario);
    
}
