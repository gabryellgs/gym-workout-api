package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.model.TreinoExercicio;
import com.gabryell.gym_system.service.TreinoExercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinosexercicios")
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    public TreinoExercicioController(TreinoExercicioService treinoExercicioService) {
        this.treinoExercicioService = treinoExercicioService;
    }

    @GetMapping
    public List<TreinoExercicio> listarTodos() {
        return treinoExercicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public TreinoExercicio buscarPorId(@PathVariable Long id) {
        return treinoExercicioService.buscarPorId(id);
    }

    @PostMapping
    public TreinoExercicio salvar(@RequestBody TreinoExercicio  treinoExercicio) {
        return treinoExercicioService.salvar(treinoExercicio);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        treinoExercicioService.deletar(id);
    }

}
