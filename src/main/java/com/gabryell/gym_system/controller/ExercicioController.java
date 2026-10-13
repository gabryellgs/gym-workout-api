package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.dto.request.ExercicioRequestDTO;
import com.gabryell.gym_system.dto.response.ExercicioResponseDTO;
import com.gabryell.gym_system.service.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public List<ExercicioResponseDTO> listarTodos() {
        return exercicioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ExercicioResponseDTO buscaPorId(@PathVariable Long id) {
        return exercicioService.buscarPorId(id);
    }

    @PostMapping
    public ExercicioResponseDTO salvar(
            @Valid @RequestBody ExercicioRequestDTO dto) {
        return exercicioService.salvar(dto);
    }

    @PutMapping("/{id}")
    public ExercicioResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ExercicioRequestDTO dto) {

        return exercicioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
    }
}