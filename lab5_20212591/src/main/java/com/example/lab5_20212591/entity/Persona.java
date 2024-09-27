package com.example.lab5_20212591.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "dni", length = 45)
    private String dni;

    @Column(name = "celular", length = 45)
    private String celular;

    @Column(name = "tipo_persona", length = 45)
    private String tipo_persona;
}
