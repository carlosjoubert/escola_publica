package com.cjrock.geo.repository;

import com.cjrock.geo.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Override
    List<Disciplina> findAll();
    Optional<Disciplina> findById(Long id);
    Optional<Disciplina> findByNome(String nome);
}
