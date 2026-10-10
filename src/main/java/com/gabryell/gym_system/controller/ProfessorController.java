package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.model.Professor;
import com.gabryell.gym_system.service.ProfessorService;
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
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }

    // GET para buscar o professor por ID
    @GetMapping("/{id}")
    public Professor buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    // POST para receber os dados de um novo professor e solicitar o salvamento
    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    // DELETE para deletar um professor com ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        professorService.deletar(id);
    }
}
