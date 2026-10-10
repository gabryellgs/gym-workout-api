package com.gabryell.gym_system.service;

import com.gabryell.gym_system.dto.request.AlunoRequestDTO;
import com.gabryell.gym_system.dto.response.AlunoResponseDTO;
import com.gabryell.gym_system.model.Aluno;
import com.gabryell.gym_system.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {

        this.alunoRepository = alunoRepository;
    }

    public List<AlunoResponseDTO> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .toList();
    }

    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        return paraResponseDTO(aluno);
    }

     public AlunoResponseDTO salvar(AlunoRequestDTO dto){
        Aluno aluno = new Aluno();

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setTelefone(dto.telefone());

        Aluno alunoSalvo = alunoRepository.save(aluno);

        return paraResponseDTO(alunoSalvo);

     }
     public void deletar(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);

     }

     private Aluno buscarEntidadePorId(Long id) {
        return alunoRepository.findById(id)
         .orElseThrow(() ->
                 new RuntimeException("Aluno não encontrado!"));
     }


    private AlunoResponseDTO paraResponseDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone()
        );
    }

}
