package com.gabryell.gym_system.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorRequestDTO(

        @NotBlank(message = "O nome é obrigatório!")
        @Size(max = 100)
        String nome,

        @NotBlank(message = "o e-mail é obrigatório!")
        @Email(message = "Informe um e-mail valido!")
        @Size(max = 150, message = "o e-mail deve ter no máximo 150 caracteres")
        String email,

        @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
        String telefone
) {
}
