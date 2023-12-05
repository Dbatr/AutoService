package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

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


    public void initializeProductData(){
        long count = productRepository.count();
        if (count == 0) {
            List<Product> products = Arrays.asList(
                    new Product(null, "Алексей", "Поменять резину"),
                    new Product(null, "Михаил", "Помыть машину"),
                    new Product(null, "Иван", "Заменить масло"),
                    new Product(null, "Ольга", "Проверить тормоза"),
                    new Product(null, "Павел", "Почистить фильтр воздуха"),
                    new Product(null, "Татьяна", "Покрасить капот"),
                    new Product(null, "Денис", "Провести диагностику двигателя"),
                    new Product(null, "Елена", "Заменить тормозные колодки"),
                    new Product(null, "Никита", "Проверить систему охлаждения"),
                    new Product(null, "Светлана", "Починить электропроводку"),
                    new Product(null, "Андрей", "Установить новый аккумулятор"),
                    new Product(null, "Мария", "Заменить фильтр топлива"),
                    new Product(null, "Григорий", "Полировка кузова"),
                    new Product(null, "Юлия", "Устранить звук в подвеске"),
                    new Product(null, "Сергей", "Проверить работу кондиционера"),
                    new Product(null, "Анастасия", "Заменить передние фары"),
                    new Product(null, "Дмитрий", "Почистить инжекторы"),
                    new Product(null, "Виктория", "Подкачать колесо"),
                    new Product(null, "Артем", "Проверить выхлопную систему"),
                    new Product(null, "Евгений", "Устранить треск в рулевой колонке"),
                    new Product(null, "Ксения", "Заменить ремень ГРМ")
            );

            productRepository.saveAll(products);
        }

    }

}