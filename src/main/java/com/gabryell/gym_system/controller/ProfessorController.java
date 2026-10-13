package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.dto.request.ProfessorRequestDTO;
import com.gabryell.gym_system.dto.response.ProfessorResponseDTO;
import com.gabryell.gym_system.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // GET para listar todos
    @GetMapping
    public List<ProfessorResponseDTO> listarTodos() {
        return professorService.listarTodos();
    }

    // GET para buscar o professor por ID
    @GetMapping("/{id}")
    public ProfessorResponseDTO buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    // POST para receber os dados de um novo professor e solicitar o salvamento
    @PostMapping
    public ProfessorResponseDTO salvar(@Valid @RequestBody ProfessorRequestDTO dto) {
        return professorService.salvar(dto);
    }

    // DELETE para deletar um professor com ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        professorService.deletar(id);
    }
}
