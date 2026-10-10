package com.gabryell.gym_system.dto.response;

public record ExercicioResponseDTO (
        Long id,
        String nome,
        String descricao,
        String grupoMuscular
){
}
