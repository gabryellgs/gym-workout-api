package com.gabryell.gym_system.service;

import com.gabryell.gym_system.dto.request.ExercicioRequestDTO;
import com.gabryell.gym_system.dto.response.ExercicioResponseDTO;
import com.gabryell.gym_system.model.Exercicio;
import com.gabryell.gym_system.repository.ExercicioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public List<ExercicioResponseDTO> listarTodos() {
        return exercicioRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .toList();
    }

    public ExercicioResponseDTO buscarPorId(Long id){
        Exercicio exercicio = buscaEntidadePorId(id);
        return paraResponseDTO(exercicio);
    }

    public ExercicioResponseDTO salvar(@Valid ExercicioRequestDTO dto) {
        Exercicio exercicio = new Exercicio();

        exercicio.setNome(dto.nome());
        exercicio.setDescricao(dto.descricao());
        exercicio.setGrupoMuscular(dto.grupoMuscular());

        Exercicio exercicioSalvo = exercicioRepository.save(exercicio);

        return paraResponseDTO(exercicioSalvo);
    }

    public ExercicioResponseDTO atualizar(
            Long id,
            ExercicioRequestDTO dto) {

        Exercicio exercicio = buscaEntidadePorId(id);

        exercicio.setNome(dto.nome());
        exercicio.setDescricao(dto.descricao());
        exercicio.setGrupoMuscular(dto.grupoMuscular());

        Exercicio atualizado = exercicioRepository.save(exercicio);

        return paraResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Exercicio exercicio = buscaEntidadePorId(id);
        exercicioRepository.delete(exercicio);
    }

    private Exercicio buscaEntidadePorId(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exercício não encontrado!"));
    }

    private ExercicioResponseDTO paraResponseDTO(Exercicio exercicio){
        return new ExercicioResponseDTO(
                exercicio.getId(),
                exercicio.getNome(),
                exercicio.getDescricao(),
                exercicio.getGrupoMuscular()
        );
    }


}
