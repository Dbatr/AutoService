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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    // Инициализация данных механиков
    public void initializeMechanicsData() {
        long count = mechanicRepository.count();

        if (count == 0) {
            // Создание списка механиков
            List<Mechanic> mechanics = Arrays.asList(
                    new Mechanic(null, "Алексей", "Смирнов", "Двигатель",
                            5, true, "Местные модели, Японские автомобили"),
                    new Mechanic(null, "Дмитрий", "Козлов", "Подвеска",
                            8, false, "Немецкие, Французские и Итальянские автомобили"),
                    new Mechanic(null, "Екатерина", "Новикова", "Электроника",
                            6, true, "Гибридные и Электрические автомобили"),
                    new Mechanic(null, "Артем", "Петров", "Кузов",
                            3, false, "Местные и Американские модели"),
                    new Mechanic(null, "Светлана", "Иванова", "Воздушно-охлаждающая система",
                            7, true, "Любые марки автомобилей")
            );
            // Сохранение механиков в репозитории
            mechanicRepository.saveAll(mechanics);
        }
    }

    // Получение механика по ID
    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    // Получение всех механиков
    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    // Создание нового механика
    public void createMechanic(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    // Обновление статуса onDuty у механика
    public boolean updateMechanicOnDuty(Long mechanicId, boolean onDuty) {
        Optional<Mechanic> optionalMechanic = mechanicRepository.findById(mechanicId);

        if (optionalMechanic.isPresent()) {
            Mechanic mechanic = optionalMechanic.get();
            mechanic.setOnDuty(onDuty);
            mechanicRepository.save(mechanic);
            return true;
        }

        return false;
    }
}