package com.example.AutoService.controllers;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Product;
import com.example.AutoService.services.AssignmentService;
import com.example.AutoService.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Методы для обработки запросов
@Controller
@Data
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final AssignmentService assignmentService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));

        // Add all assignments to the model
        List<Assignment> allAssignments = assignmentService.getAllAssignments();
        model.addAttribute("allAssignments", allAssignments);

        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}