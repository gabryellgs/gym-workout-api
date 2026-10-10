package com.gabryell.gym_system.service;

import com.gabryell.gym_system.model.TreinoExercicio;
import com.gabryell.gym_system.repository.TreinoExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoExercicioService {

    private final TreinoExercicioRepository treinoExercicioRepository;

    public TreinoExercicioService(TreinoExercicioRepository treinoExercicioRepository) {
        this.treinoExercicioRepository = treinoExercicioRepository;
    }

    public List<TreinoExercicio> listarTodos() {
        return treinoExercicioRepository.findAll();
    }

    public TreinoExercicio buscarPorId(Long id) {
        return treinoExercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino exercicio não encontrado!"));
    }

    public TreinoExercicio salvar(TreinoExercicio treinoExercicio){
        return treinoExercicioRepository.save(treinoExercicio);
    }

    public void deletar(Long id){
        treinoExercicioRepository.deleteById(id);
    }

}
