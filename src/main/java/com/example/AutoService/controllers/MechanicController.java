package com.example.AutoService.controllers;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.services.MechanicService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autoservice")
public class MechanicController {

    private final MechanicService mechanicService;

    // Получение всех механиков
    @GetMapping("/mechanics")
    public List<Mechanic> getAllMechanicsForAdmin() {
        return mechanicService.getAllMechanics();
    }

    // Получение механика по ID
    @GetMapping("/mechanics/{mechanicId}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable Long mechanicId) {
        Mechanic mechanic = mechanicService.getMechanicById(mechanicId);

        if (mechanic != null) {
            return new ResponseEntity<>(mechanic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Изменение статуса onDuty механика на "Да"
    @PatchMapping("/mechanics/{mechanicId}/onDuty/true")
    public ResponseEntity<String> setMechanicOnDuty(@PathVariable Long mechanicId) {
        boolean updated = mechanicService.updateMechanicOnDuty(mechanicId, true);

        if (updated) {
            return new ResponseEntity<>("Mechanic status set to On Duty", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mechanic not found", HttpStatus.NOT_FOUND);
        }
    }

    // Изменение статуса onDuty механика на "Нет"
    @PatchMapping("/mechanics/{mechanicId}/onDuty/false")
    public ResponseEntity<String> setMechanicOffDuty(@PathVariable Long mechanicId) {
        boolean updated = mechanicService.updateMechanicOnDuty(mechanicId, false);

        if (updated) {
            return new ResponseEntity<>("Mechanic status set to Off Duty", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mechanic not found", HttpStatus.NOT_FOUND);
        }
    }

    // Добавление нового механика
    @PostMapping("/addMechanic")
    public String createMechanic(@RequestBody Mechanic mechanic){
        mechanicService.createMechanic(mechanic);
        return "Mechanic added";
    }

    // Изменение количества лет опыта работы механика
    @PatchMapping("/mechanics/{mechanicId}/updateExperienceYears/{newExperienceYears}")
    public ResponseEntity<String> updateExperienceYears(@PathVariable Long mechanicId,
                                                        @PathVariable int newExperienceYears) {
        boolean updated = mechanicService.updateExperienceYears(mechanicId, newExperienceYears);

        if (updated) {
            return new ResponseEntity<>("Experience years updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mechanic not found", HttpStatus.NOT_FOUND);
        }
    }

}
