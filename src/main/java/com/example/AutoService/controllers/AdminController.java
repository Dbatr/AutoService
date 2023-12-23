package com.example.AutoService.controllers;

import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.services.MechanicService;
import com.example.AutoService.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final ProductService productService;
    private final MechanicService mechanicService;

    @GetMapping("/mechanics")
    public List<Object[]> getAllMechanicsForAdmin() {
        return mechanicService.getAllMechanics();
    }

    @GetMapping("/orders")
    public List<Product> getAllOrdersForAdmin() {
        return productService.getAllProducts();
    }



}
