package com.example.lab5_20212591.repository;

import com.example.lab5_20212591.entity.Lugares;
import com.example.lab5_20212591.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugaresRepository extends JpaRepository<Lugares, Integer> {
}
