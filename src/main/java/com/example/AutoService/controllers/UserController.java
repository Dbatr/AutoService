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

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
