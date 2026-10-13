package com.gabryell.gym_system.service;

import com.gabryell.gym_system.dto.request.TreinoExercicioRequestDTO;
import com.gabryell.gym_system.dto.response.TreinoExercicioResponseDTO;
import com.gabryell.gym_system.model.Exercicio;
import com.gabryell.gym_system.model.Treino;
import com.gabryell.gym_system.model.TreinoExercicio;
import com.gabryell.gym_system.repository.ExercicioRepository;
import com.gabryell.gym_system.repository.TreinoExercicioRepository;
import com.gabryell.gym_system.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;
    private final TreinoRepository treinoRepository;
    private final ExercicioRepository exercicioRepository;

    public TreinoExercicioService(
            TreinoExercicioRepository treinoExercicioRepository,
            TreinoRepository treinoRepository,
            ExercicioRepository exercicioRepository
            ) {
        this.treinoExercicioRepository = treinoExercicioRepository;
        this.treinoRepository = treinoRepository;
        this.exercicioRepository = exercicioRepository;
    }

    public List<TreinoExercicioResponseDTO> listarTodos() {
        return treinoExercicioRepository.findAll()
                .stream()
                .map(this::paraResponseDTO)
                .toList();
    }

    public TreinoExercicioResponseDTO buscarPorId(Long id) {
        TreinoExercicio treinoExercicio = buscaEntidadePorId(id);
        return paraResponseDTO(treinoExercicio);
    }

    public TreinoExercicioResponseDTO salvar(TreinoExercicioRequestDTO dto){
        Treino treino = treinoRepository.findById(dto.treinoId())
                .orElseThrow(() ->
                        new RuntimeException("Treino não encontrado!"));

        Exercicio exercicio = exercicioRepository.findById(dto.exercicioId())
                .orElseThrow(() ->
                        new RuntimeException("Exercício não encontrado!"));

        TreinoExercicio treinoExercicio = new TreinoExercicio();

        treinoExercicio.setTreino(treino);
        treinoExercicio.setExercicio(exercicio);
        treinoExercicio.setSeries(dto.series());
        treinoExercicio.setRepeticoes(dto.repeticoes());
        treinoExercicio.setCarga(dto.carga());
        treinoExercicio.setDescanso(dto.descanso());

        TreinoExercicio salvo =
                treinoExercicioRepository.save(treinoExercicio);

        return paraResponseDTO(salvo);
    }

    public void deletar(Long id){
        TreinoExercicio treinoExercicio = buscaEntidadePorId(id);
        treinoExercicioRepository.delete(treinoExercicio);
    }

    private TreinoExercicio buscaEntidadePorId(Long id) {
        return treinoExercicioRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Treino-exercício não encontrado!"));
    }

    private TreinoExercicioResponseDTO paraResponseDTO(
            TreinoExercicio treinoExercicio) {
        return new TreinoExercicioResponseDTO(
                treinoExercicio.getId(),
                treinoExercicio.getTreino().getId(),
                treinoExercicio.getExercicio().getId(),
                treinoExercicio.getSeries(),
                treinoExercicio.getRepeticoes(),
                treinoExercicio.getCarga(),
                treinoExercicio.getDescanso()
        );
    }
}
