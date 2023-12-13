package com.example.AutoService.controllers;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.services.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final MechanicService mechanicService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        // Получите информацию о текущем пользователе (механике)
        Mechanic mechanic = getCurrentMechanic();

        // Передайте информацию о механике в модель
        model.addAttribute("mechanic", mechanic);

        return "mechanic-profile"; // Имя вашего шаблона FreeMarker
    }

    public Mechanic getCurrentMechanic() {
        return mechanicService.getCurrentMechanic();
    }
}
