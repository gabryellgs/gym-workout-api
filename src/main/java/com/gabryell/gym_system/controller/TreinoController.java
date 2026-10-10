package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.model.Treino;
import com.gabryell.gym_system.service.TreinoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @GetMapping
    public List<Treino> listarTodos(){
        return treinoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Treino listarPorId(@PathVariable Long id){
        return treinoService.buscarPorId(id);
    }

    @PostMapping
    public Treino salvar(@RequestBody Treino treino){
        return treinoService.salvar(treino);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        treinoService.deletar(id);
    }



}
