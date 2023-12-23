package com.example.AutoService.services;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.models.User;
import com.example.AutoService.models.enums.Role;
import com.example.AutoService.repositories.MechanicRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final PasswordEncoder passwordEncoder;

    public void initializeMechanicsData() {
        long count = mechanicRepository.count();

        if (count == 0) {
            List<Mechanic> mechanics = Arrays.asList(
                    new Mechanic(null, "Администратор", "админ", "админ",
                            1, "Да", "админ",
                            createMechanicUser("admin@gmail.com", "admin", "1", Role.ROLE_ADMIN)),
                    new Mechanic(null, "Алексей", "Смирнов", "Двигатель",
                            5, "Да", "Местные модели, Японские автомобили",
                            createMechanicUser("alexei@gmail.com", "smirnov", "89123456789", Role.ROLE_USER)),
                    new Mechanic(null, "Дмитрий", "Козлов", "Подвеска",
                            8, "Нет", "Немецкие, Французские и Итальянские автомобили",
                            createMechanicUser("dmitriy@mail.com", "kozlov", "89129876543", Role.ROLE_USER)),
                    new Mechanic(null, "Екатерина", "Новикова", "Электроника",
                            6, "Да", "Гибридные и Электрические автомобили",
                            createMechanicUser("ekaterina@mail.com", "novikova", "89191237854", Role.ROLE_USER)),
                    new Mechanic(null, "Артем", "Петров", "Кузов",
                            3, "Нет", "Местные и Американские модели",
                            createMechanicUser("artem@mail.com", "petrov", "89196547898", Role.ROLE_USER)),
                    new Mechanic(null, "Светлана", "Иванова", "Воздушно-охлаждающая система",
                            7, "Да", "Любые марки автомобилей",
                            createMechanicUser("svetlana@mail.com", "ivanova", "89234785690", Role.ROLE_USER))
            );

            mechanicRepository.saveAll(mechanics);
        }
    }

    private User createMechanicUser(String login, String password, String phoneNumber, Role... roles) {
        User user = new User();
        user.setLogin(login);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setPhoneNumber(phoneNumber);
        user.setActive(true);
        user.setRoles(new HashSet<>(Arrays.asList(roles)));
        return user;
    }


    public Mechanic getMechanicById(Long id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    public Mechanic getCurrentMechanic() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            return user.getMechanic();
        }
        return null;
    }

    public List<Object[]> getAllMechanics() {
        return mechanicRepository.findAllSelectedColumns();
    }

}