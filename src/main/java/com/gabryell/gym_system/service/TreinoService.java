package com.gabryell.gym_system.service;

import com.gabryell.gym_system.dto.response.TreinoResponseDTO;
import com.gabryell.gym_system.dto.request.TreinoRequestDTO;
import com.gabryell.gym_system.model.Aluno;
import com.gabryell.gym_system.model.Professor;
import com.gabryell.gym_system.model.Treino;
import com.gabryell.gym_system.repository.AlunoRepository;
import com.gabryell.gym_system.repository.ProfessorRepository;
import com.gabryell.gym_system.repository.TreinoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    public TreinoService(
            TreinoRepository treinoRepository,
            AlunoRepository alunoRepository,
            ProfessorRepository professorRepository){

        this.treinoRepository = treinoRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    public List<TreinoResponseDTO> listarTodos() {
        return treinoRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .toList();
    }

    public TreinoResponseDTO buscarPorId(Long id) {
        Treino treino = buscaEntidadePorId(id);
        return paraResponseDTO(treino);

    }

    public TreinoResponseDTO salvar(TreinoRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.alunoId())
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado!"));

        Professor professor = professorRepository.findById(dto.professorId())
                .orElseThrow(() ->
                        new RuntimeException("Professor não encontrado!"));

        Treino treino = new Treino();

        treino.setNome(dto.nome());
        treino.setDescricao(dto.descricao());
        treino.setAluno(aluno);
        treino.setProfessor(professor);

        Treino treinoSalvo = treinoRepository.save(treino);

        return paraResponseDTO(treinoSalvo);
    }

    public void deletar(Long id) {
        Treino treino = buscaEntidadePorId(id);
        treinoRepository.delete(treino);
    }

    private Treino buscaEntidadePorId(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Treino não encontrado!"));
    }

    private TreinoResponseDTO paraResponseDTO(Treino treino) {
        return new TreinoResponseDTO(
                treino.getId(),
                treino.getNome(),
                treino.getDescricao(),
                treino.getAluno().getId(),
                treino.getProfessor().getId(),
                List.of()
        );
    }

}
