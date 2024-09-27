package com.example.lab5_20212591.repository;

import com.example.lab5_20212591.entity.Persona;
import com.example.lab5_20212591.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
