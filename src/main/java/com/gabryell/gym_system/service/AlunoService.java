package com.gabryell.gym_system.service;

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

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));
    }

     public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
     }
     public void deletar(Long id){
        alunoRepository.deleteById(id);
     }

}
