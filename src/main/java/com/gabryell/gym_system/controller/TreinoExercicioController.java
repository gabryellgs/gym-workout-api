package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.dto.request.TreinoExercicioRequestDTO;
import com.gabryell.gym_system.dto.response.TreinoExercicioResponseDTO;
import com.gabryell.gym_system.model.TreinoExercicio;
import com.gabryell.gym_system.service.TreinoExercicioService;
import jakarta.validation.Valid;
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
    public List<TreinoExercicioResponseDTO> listarTodos() {
        return treinoExercicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public TreinoExercicioResponseDTO buscarPorId(@PathVariable Long id) {
        return treinoExercicioService.buscarPorId(id);
    }

    @PostMapping
    public TreinoExercicioResponseDTO salvar(@Valid @RequestBody TreinoExercicioRequestDTO dto) {
        return treinoExercicioService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        treinoExercicioService.deletar(id);
    }

}
