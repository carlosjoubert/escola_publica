package com.cjrock.geo.repository;

import com.cjrock.geo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmail(String email);
    Optional<Professor> findById(Long id);
    List<Professor> findAll();

}
