package com.example.lab5_20212591.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idviajes", nullable = false)
    private Integer id;

    @Column(name = "punto_recojo", length = 45)
    private String punto_recojo;

    @Column(name = "cant_personas", length = 45)
    private String cant_personas;

    @Column(name = "cant_perros", length = 45)
    private String cant_perros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idlugares")
    private Lugares lugares;
}
