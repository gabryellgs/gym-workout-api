package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.model.Exercicio;
import com.gabryell.gym_system.service.ExercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    // GET para listar todos
    @GetMapping
    public List<Exercicio> listarTodos(){
        return exercicioService.listarTodos();
    }

    // GET para buscar o exercicio por ID
    @GetMapping("/{id}")
    public Exercicio buscaPorId(@PathVariable Long id){
        return exercicioService.buscarPorId(id);
    }

    // POST para cadastrar um novo exercício
    @PostMapping
    public Exercicio salvar(@RequestBody Exercicio exercicio) {
        return exercicioService.salvar(exercicio);
    }

    // DELETE para deletar um exercício por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
    }
}
