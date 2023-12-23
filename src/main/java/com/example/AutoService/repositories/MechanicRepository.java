package com.example.AutoService.repositories;

import com.example.AutoService.models.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

    @Query("SELECT m.id, m.firstName, m.lastName, m.specialization, m.experienceYears, m.onDuty, m.preferredCarBrands FROM Mechanic m")
    List<Object[]> findAllSelectedColumns();
}
