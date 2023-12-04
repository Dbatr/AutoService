package com.example.AutoService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssignmentID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MechanicID", nullable = false)
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "WorkspaceID", nullable = false)
    private Workspace workspace;

    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private Product product;

    // Constructors, getters, setters, and other necessary methods
}
