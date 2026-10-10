package com.gabryell.gym_system.service;

import com.gabryell.gym_system.dto.request.ProfessorRequestDTO;
import com.gabryell.gym_system.dto.response.ProfessorResponseDTO;
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

    public List<ProfessorResponseDTO> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .toList();
    }

    public ProfessorResponseDTO buscarPorId(Long id){
        Professor professor = buscarEntidadePorId(id);
        return paraResponseDTO(professor);
    }

    public ProfessorResponseDTO salvar(ProfessorRequestDTO dto){
        Professor professor = new Professor();

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setTelefone(dto.telefone());

        Professor professorSalvo = professorRepository.save(professor);

        return paraResponseDTO(professorSalvo);

    }

    public void deletar(Long id){
        Professor professor = buscarEntidadePorId(id);
        professorRepository.delete(professor);
    }

    private Professor buscarEntidadePorId(Long id){
        return professorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Professor não encontrado!"));
    }

    private ProfessorResponseDTO paraResponseDTO(Professor professor) {
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getTelefone()
        );
    }

}