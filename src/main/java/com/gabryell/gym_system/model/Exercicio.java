package com.gabryell.gym_system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do exercicio é obrigatório!")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O grupo muscular é obrigatório!")
    @Column(nullable = false, length = 50)
    private String grupoMuscular;

    @Column(length = 500)
    private String descricao;

}
