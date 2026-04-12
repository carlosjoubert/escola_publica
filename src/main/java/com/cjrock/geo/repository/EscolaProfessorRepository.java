package com.cjrock.geo.repository;

import com.cjrock.geo.model.Escola;
import com.cjrock.geo.model.EscolaProfessor;
import com.cjrock.geo.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EscolaProfessorRepository extends JpaRepository<EscolaProfessor, Integer> {
    @Override
    List<EscolaProfessor> findAll();
    Optional<EscolaProfessor> findById(Integer id);
    Optional<EscolaProfessor> findByEscola(Escola escola);
    Optional<EscolaProfessor> findByProfessor(Professor professor);
    Optional<EscolaProfessor> findByAnoLetivo(Integer anoLetivo);
    Optional<EscolaProfessor> findByEscolaAndProfessorAndAnoLetivo(Escola escola, Professor professor, Integer anoLetivo);
    List<EscolaProfessor> findAllByEscolaAndAnoLetivo(Escola escola, Integer anoLetivo);
    List<EscolaProfessor> findAllByProfessorAndAnoLetivo(Professor professor, Integer anoLetivo);
}
