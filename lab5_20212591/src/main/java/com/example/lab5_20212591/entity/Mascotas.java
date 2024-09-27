package com.example.lab5_20212591.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mascotas")
public class Mascotas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas", nullable = false)
    private Integer id;

    @Column(name = "nombre_mascota", length = 45)
    private String nombre_mascota;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "edad", length = 45)
    private String edad;

    @Column(name = "fecha_nacimiento", length = 45)
    private String fecha_nacimiento;

    @Column(name = "vacunado", length = 45)
    private String vacunado;

    @Column(name = "desparasitado", length = 45)
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

}
