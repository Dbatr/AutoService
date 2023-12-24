package com.example.AutoService.controllers;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.services.AssignmentService;
import com.example.AutoService.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Методы для обработки запросов
@Controller
@Data
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final AssignmentService assignmentService;
    private final UserController userController;
    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));

        // Список всех назначений
        List<Assignment> allAssignments = assignmentService.getAllAssignments();
        model.addAttribute("allAssignments", allAssignments);


        // Add user information to the model
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            model.addAttribute("user", authentication.getPrincipal());
        }

        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

}