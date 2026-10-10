package com.gabryell.gym_system.dto.response;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
