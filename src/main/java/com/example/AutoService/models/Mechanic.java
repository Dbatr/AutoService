package com.example.AutoService.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Сущность, описывающая механика в автосервисе
@Entity
@Table(name = "Mechanics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic {
    // Уникальный идентификатор механика
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MechanicID")
    private Integer id;

    // Имя механика
    @Column(name = "FirstName")
    private String firstName;

    // Фамилия механика
    @Column(name = "LastName")
    private String lastName;

    // Специализация механика (например, двигатель, подвеска и т. д.)
    @Column(name = "Specialization")
    private String specialization;

    // Количество лет опыта работы механика
    @Column(name = "ExperienceYears")
    private int experienceYears;

    // Флаг, указывающий на то, находится ли механик в настоящее время на службе
    @Column(name = "OnDuty")
    private boolean onDuty;

    // Предпочитаемые марки автомобилей, с которыми работает механик
    @Column(name = "PreferredCarBrands")
    private String preferredCarBrands;


}
