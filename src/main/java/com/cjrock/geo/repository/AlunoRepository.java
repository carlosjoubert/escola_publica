package com.cjrock.geo.repository;

import com.cjrock.geo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Override
    List<Aluno> findAll();
    Optional<Aluno> findById(Long id);
    Optional<Aluno> findByNome(String nome);
}
