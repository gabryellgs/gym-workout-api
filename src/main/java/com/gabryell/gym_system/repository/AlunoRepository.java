package com.gabryell.gym_system.repository;

import com.gabryell.gym_system.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
