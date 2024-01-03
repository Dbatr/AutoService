package com.example.AutoService.services;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.repositories.MechanicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для обработки бизнес-логики, связанной с механиками.
 */
@Service
@RequiredArgsConstructor
public class MechanicService {
    private final MechanicRepository mechanicRepository;

    /**
     * Метод для инициализации данных механиков.
     */
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

    /**
     * Получение механика по ID.
     *
     * @param id ID механика.
     * @return Механик с указанным ID или null, если не найден.
     */
    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    /**
     * Получение всех механиков.
     *
     * @return Список всех механиков.
     */
    public List<Mechanic> getAllMechanics() {
        return mechanicRepository.findAll();
    }

    /**
     * Создание нового механика.
     *
     * @param mechanic Новый механик.
     */
    public void createMechanic(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    /**
     * Обновление статуса onDuty у механика.
     *
     * @param mechanicId ID механика.
     * @param onDuty     Новый статус onDuty.
     * @return true, если обновление успешно, иначе false.
     */
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

    public boolean updateExperienceYears(Long mechanicId, int newExperienceYears) {
        Optional<Mechanic> optionalMechanic = mechanicRepository.findById(mechanicId);

        if (optionalMechanic.isPresent()) {
            Mechanic mechanic = optionalMechanic.get();
            mechanic.setExperienceYears(newExperienceYears);
            mechanicRepository.save(mechanic);
            return true;
        }

        return false;
    }
}