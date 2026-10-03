package com.gabryell.gym_system.repository;

import com.gabryell.gym_system.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository <Exercicio, Long> {

}
