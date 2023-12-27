package com.example.AutoService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Продукт с полями
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    // Уникальный идентификатор продукта
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // Имя клиента, размещающего заказ
    @Column(name = "first_name")
    private String title;

    // Фамилия клиента, размещающего заказ
    @Column(name = "last_name")
    private String lastName;

    // Описание продукта или заказа (может быть текстовым полем для подробного описания)
    @Column(name = "description", columnDefinition = "text")
    private String description;

    // Номер телефона клиента
    @Column(name = "phone_number")
    private String phoneNumber;

    // Флаг, указывающий, завершен ли заказ (true - завершен, false - не завершен)
    @Column(name = "completed")
    private boolean completed;
}