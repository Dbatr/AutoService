package com.example.AutoService.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Mechanics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MechanicID")
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "ExperienceYears")
    private int experienceYears;

    @Column(name = "OnDuty")
    private String onDuty;

    @Column(name = "PreferredCarBrands")
    private String preferredCarBrands;
}
