package com.gabryell.gym_system.repository;

import com.gabryell.gym_system.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {

}
