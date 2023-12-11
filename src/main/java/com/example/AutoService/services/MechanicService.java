package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.User;
import com.example.AutoService.models.enums.Role;
import com.example.AutoService.repositories.AssignmentRepository;
import com.example.AutoService.repositories.MechanicRepository;

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
                            5, "Да", "Местные модели, Японские автомобили",
                            createMechanicUser("alexei", "smirnov", "89123456789", Role.ROLE_USER)),
                    new Mechanic(null, "Дмитрий", "Козлов", "Подвеска",
                            8, "Нет", "Немецкие, Французские и Итальянские автомобили",
                            createMechanicUser("dmitriy", "kozlov", "89129876543", Role.ROLE_USER)),
                    new Mechanic(null, "Екатерина", "Новикова", "Электроника",
                            6, "Да", "Гибридные и Электрические автомобили",
                            createMechanicUser("ekaterina", "novikova", "89191237854", Role.ROLE_USER)),
                    new Mechanic(null, "Артем", "Петров", "Кузов",
                            3, "Нет", "Местные и Американские модели",
                            createMechanicUser("artem", "petrov", "89196547898", Role.ROLE_USER)),
                    new Mechanic(null, "Светлана", "Иванова", "Воздушно-охлаждающая система",
                            7, "Да", "Любые марки автомобилей",
                            createMechanicUser("svetlana", "ivanova", "89234785690", Role.ROLE_USER))
            );

            mechanicRepository.saveAll(mechanics);
        }
    }
    private User createMechanicUser(String login, String password, String phoneNumber, Role... roles) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setActive(true);
        user.setRoles(new HashSet<>(Arrays.asList(roles)));
        return user;
    }


    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

}
