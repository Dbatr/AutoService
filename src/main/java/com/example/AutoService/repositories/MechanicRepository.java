package com.example.AutoService.repositories;

import com.example.AutoService.models.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
