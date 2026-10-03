(package com.gabryell.gym_system.service;

import com.gabryell.gym_system.model.Aluno;
import com.gabryell.gym_system.model.Professor;
import com.gabryell.gym_system.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id){
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }

    public Professor professor( Professor professor){
        return professorRepository.save(professor);
    }

    public void deletar(Long id){
        professorRepository.deleteById(id);
    }
}
)