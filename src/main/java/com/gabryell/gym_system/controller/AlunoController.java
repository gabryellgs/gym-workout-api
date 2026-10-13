package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.dto.request.AlunoRequestDTO;
import com.gabryell.gym_system.dto.response.AlunoResponseDTO;
import com.gabryell.gym_system.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // GET para listar todos
    @GetMapping
    public List<AlunoResponseDTO> listarTodos() {
        return alunoService.listarTodos();
    }

    // GET para buscar o aluno por ID
    @GetMapping("/{id}")
    public AlunoResponseDTO buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    // POST para receber os dados de um novo aluno e solicitar o salvamento
    @PostMapping
    public AlunoResponseDTO salvar(@Valid @RequestBody AlunoRequestDTO dto) {
        return alunoService.salvar(dto);
    }

    // PUT ele atualiza as informações do aluno
    @PutMapping("/{id}")
    public AlunoResponseDTO atualizar(@PathVariable Long id,
                                          @Valid @RequestBody AlunoRequestDTO dto){
        return alunoService.atualizar(id, dto);
    }

    // DELETE para deletar um aluno com ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunoService.deletar(id);
    }


}
