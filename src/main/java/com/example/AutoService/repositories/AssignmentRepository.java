package com.example.AutoService.repositories;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
