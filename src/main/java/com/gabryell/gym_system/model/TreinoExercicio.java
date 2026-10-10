package com.gabryell.gym_system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treino_exercicios")
public class TreinoExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Deve haver pelo menos uma série!")
    @Column(nullable = false)
    private Integer series;

    @Min(value = 1, message = "Deve haver pelo menos uma repetição")
    @Column(nullable = false)
    private Integer repeticoes;

    @Column(precision = 7, scale = 2)
    private BigDecimal carga;
    @Min(value = 0, message = "O descanso não pode ser negativo!")
    @Column(nullable = false)
    private Integer descanso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "treino_id")
    private Treino treino;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

}
