package com.cjrock.geo.repository;

import com.cjrock.geo.model.AlunoEscola;
import com.cjrock.geo.model.Escola;
import com.cjrock.geo.model.enums.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoEscolaRepository extends JpaRepository<AlunoEscola, Integer> {
    @Override
    List<AlunoEscola> findAll();
    Optional<AlunoEscola> findById(Integer id);
    Optional<AlunoEscola> findByAlunoNome(String nome);
    Optional<AlunoEscola> findByMatricula(Integer matricula);
    Optional<AlunoEscola> findByEscola(Escola escola);
    Optional<AlunoEscola> findByTurno(Turno turno);
    Optional<AlunoEscola> findByAnoLetivo(Integer anoLetivo);
}
