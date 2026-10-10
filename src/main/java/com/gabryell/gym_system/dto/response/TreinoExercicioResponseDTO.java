package com.gabryell.gym_system.dto.response;

import java.math.BigDecimal;

public record TreinoExercicioResponseDTO(
        Long id,
        Long treinoId,
        Long exercicioId,
        Integer series,
        Integer repeticoes,
        BigDecimal carga,
        Integer descanso
) {
}
