package com.example.AutoService.controllers;

import com.example.AutoService.models.Product;
import com.example.AutoService.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autoservice")
public class ProductController {

    private final ProductService productService;

    // Получение всех заказов (продуктов)
    @GetMapping("/orders")
    public List<Product> getAllOrdersForAdmin() {
        return productService.getAllProducts();
    }

    // Получение заказа (продукта) по ID
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long orderId) {
        Product product = productService.getProductById(orderId);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Обновление статуса заказа (помечается как выполненный)
    @PatchMapping("/orders/{orderId}/complete")
    public ResponseEntity<String> completeProduct(@PathVariable Long orderId) {
        boolean updated = productService.updateProductStatus(orderId, true);

        if (updated) {
            return new ResponseEntity<>("Product status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Обновление статуса заказа (помечается как невыполненный)
    @PatchMapping("/orders/{orderId}/uncomplete")
    public ResponseEntity<String> uncompleteProduct(@PathVariable Long orderId) {
        boolean updated = productService.updateProductStatus(orderId, false);

        if (updated) {
            return new ResponseEntity<>("Product status updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    // Добавление нового заказа (продукта)
    @PostMapping("/addOrder")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product added";
    }
}
