package com.example.AutoService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Сущность для хранения информации о заданиях в автосервисе
@Entity
@Table(name = "Assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    // Уникальный идентификатор задания
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AssignmentID")
    private Long id;

    // Связь многие к одному с сущностью Mechanic (Механик)
    @ManyToOne
    @JoinColumn(name = "MechanicID", nullable = false)
    private Mechanic mechanic;

    // Связь многие к одному с сущностью Workspace (Рабочее место)
    @ManyToOne
    @JoinColumn(name = "WorkspaceID", nullable = false)
    private Workspace workspace;

    // Связь многие к одному с сущностью Product (Продукт/Заказ)
    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private Product product;

}
