package com.gabryell.gym_system.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ExercicioRequestDTO(

        @NotBlank(message = "O nome do exercício é obrigatório!")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotBlank(message = "O grupo muscular é obrigatório!")
        @Size(max = 50, message = "O grupo muscular deve ter no máximo 50 caracteres")
        String grupoMuscular
) {


}
