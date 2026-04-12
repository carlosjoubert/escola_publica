package com.cjrock.geo.repository;

import com.cjrock.geo.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    @Override
    List<Horario> findAll();
    Optional<Horario> findById(Long id);
    Optional<Horario> findByDia(String dia);
    Optional<Horario> findByNum_aula(int num_aula);
}
