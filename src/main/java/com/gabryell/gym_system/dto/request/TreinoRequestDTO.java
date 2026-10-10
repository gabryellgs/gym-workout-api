package com.gabryell.gym_system.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TreinoRequestDTO(

        @NotBlank(message = "O nome do treino é obrigatório!")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres")
        String descricao,

        @NotNull(message = "O ID do aluno é obrigatório!")
        @Positive(message = "O ID do aluno deve ser maior que zero")
        Long alunoId,

        @NotNull(message = "O ID do professor é obrigatório!")
        @Positive(message = "O ID do professor deve ser maior que zero")
        Long professorId,

        List<@NotNull @Positive Long> exerciciosIds
) {
}
