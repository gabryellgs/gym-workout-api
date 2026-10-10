package com.gabryell.gym_system.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record TreinoExercicioRequestDTO(
        @NotNull(message = "O ID do treino é obrigatório!")
        @Min(value = 1, message = "O ID do treino deve ser maior que zero")
        Long treinoId,

        @NotNull(message = "O ID do exercício é obrigatório!")
        @Min(value = 1, message = "O ID do exercício deve ser maior que zero")
        Long exercicioId,

        @NotNull(message = "O número de séries é obrigatório!")
        @Min(value = 1, message = "Deve haver pelo menos uma série")
        Integer series,

        @NotNull(message = "O número de repetições é obrigatório!")
        @Min(value = 1, message = "Deve haver pelo menos uma repetição")
        Integer repeticoes,

        @NotNull(message = "A carga é obrigatória!")
        @DecimalMin(value = "0.0", message = "A carga não pode ser negativa")
        @Digits(integer = 5, fraction = 2, message = "A carga deve ter no máximo 5 dígitos inteiros e 2 decimais")
        BigDecimal carga,

        @NotNull(message = "O descanso é obrigatório!")
        @Min(value = 0, message = "O descanso não pode ser negativo")
        Integer descanso
) {
}
