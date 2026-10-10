package com.gabryell.gym_system.dto.response;

public record ProfessorResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
