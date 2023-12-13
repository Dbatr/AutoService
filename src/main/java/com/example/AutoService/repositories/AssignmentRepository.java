package com.example.AutoService.repositories;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByMechanic(Mechanic currentMechanic);
}
