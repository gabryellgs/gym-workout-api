package com.gabryell.gym_system.service;

import com.gabryell.gym_system.model.Treino;
import com.gabryell.gym_system.repository.TreinoRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository){
        this.treinoRepository = treinoRepository;
    }

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Treino buscarPorId(Long id) {
        return treinoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Treino não encontrado!"));
    }

    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }

    public void deletar(Long id) {
        treinoRepository.deleteById(id);
    }

}
