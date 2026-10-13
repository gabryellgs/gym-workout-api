package com.gabryell.gym_system.controller;

import com.gabryell.gym_system.dto.request.TreinoRequestDTO;
import com.gabryell.gym_system.dto.response.TreinoResponseDTO;
import com.gabryell.gym_system.service.TreinoService;
import jakarta.validation.Valid;
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
    public List<TreinoResponseDTO> listarTodos(){
        return treinoService.listarTodos();
    }

    @GetMapping("/{id}")
    public TreinoResponseDTO listarPorId(@PathVariable Long id){
        return treinoService.buscarPorId(id);
    }

    @PostMapping
    public TreinoResponseDTO salvar(@Valid @RequestBody TreinoRequestDTO dto){
        return treinoService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        treinoService.deletar(id);
    }



}
