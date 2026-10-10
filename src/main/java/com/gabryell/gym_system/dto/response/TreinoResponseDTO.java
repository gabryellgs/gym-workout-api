package com.gabryell.gym_system.dto.response;

import java.util.List;

public record TreinoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Long alunoId,
        Long professorId,
        List<Long> exerciciosIds
) {
}
