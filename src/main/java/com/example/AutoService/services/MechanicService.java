package com.example.AutoService.services;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.User;
import com.example.AutoService.models.enums.Role;
import com.example.AutoService.repositories.MechanicRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    public void initializeMechanicsData() {
        long count = mechanicRepository.count();

        if (count == 0) {
            List<Mechanic> mechanics = Arrays.asList(
                    new Mechanic(null, "Алексей", "Смирнов", "Двигатель",
                            5, "Да", "Местные модели, Японские автомобили"),
                    new Mechanic(null, "Дмитрий", "Козлов", "Подвеска",
                            8, "Нет", "Немецкие, Французские и Итальянские автомобили"),
                    new Mechanic(null, "Екатерина", "Новикова", "Электроника",
                            6, "Да", "Гибридные и Электрические автомобили"),
                    new Mechanic(null, "Артем", "Петров", "Кузов",
                            3, "Нет", "Местные и Американские модели"),
                    new Mechanic(null, "Светлана", "Иванова", "Воздушно-охлаждающая система",
                            7, "Да", "Любые марки автомобилей")
            );

            mechanicRepository.saveAll(mechanics);
        }
    }


    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }


    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    public void createMechanic(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }
}