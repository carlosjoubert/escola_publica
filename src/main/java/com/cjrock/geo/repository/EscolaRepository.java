package com.cjrock.geo.repository;

import com.cjrock.geo.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EscolaRepository extends JpaRepository<Escola, Long> {
    @Override
    List<Escola> findAll();
    Optional<Escola> findById(Long id);
    Optional<Escola> findByNome(String nome);
}
