package com.example.AutoService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//продукт с полями
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "completed")
    private boolean completed;
}