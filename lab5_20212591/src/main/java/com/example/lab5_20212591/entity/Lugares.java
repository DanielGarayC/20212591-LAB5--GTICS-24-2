package com.example.lab5_20212591.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlugares", nullable = false)
    private Integer id;

    @Column(name = "nombre_lugar", length = 45)
    private String nombre_lugar;

    @Column(name = "descrip_lugar", length = 45)
    private String descrip_lugar;

    @Column(name = "fecha_lugar")
    private Date fecha_lugar;
}
