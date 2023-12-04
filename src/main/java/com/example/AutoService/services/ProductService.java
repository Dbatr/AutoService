package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Product;
import com.example.AutoService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//методы для обработки бизнес-логики
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    //получение списка продуктов
    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    // сохранение нового продукта
    public void saveProduct(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    // удаление продукта
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Получение доп. информации о продукте
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


}