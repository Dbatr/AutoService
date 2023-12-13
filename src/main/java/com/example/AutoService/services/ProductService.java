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
                    new Product(null, "Алексей", "Поменять резину", false),
                    new Product(null, "Михаил", "Помыть машину", false),
                    new Product(null, "Иван", "Заменить масло", false),
                    new Product(null, "Ольга", "Проверить тормоза", false),
                    new Product(null, "Павел", "Почистить фильтр воздуха", false),
                    new Product(null, "Татьяна", "Покрасить капот", false),
                    new Product(null, "Денис", "Провести диагностику двигателя", false),
                    new Product(null, "Елена", "Заменить тормозные колодки", false),
                    new Product(null, "Никита", "Проверить систему охлаждения", false),
                    new Product(null, "Светлана", "Починить электропроводку", false),
                    new Product(null, "Андрей", "Установить новый аккумулятор", false),
                    new Product(null, "Мария", "Заменить фильтр топлива", false),
                    new Product(null, "Григорий", "Полировка кузова", false),
                    new Product(null, "Юлия", "Устранить звук в подвеске", false),
                    new Product(null, "Сергей", "Проверить работу кондиционера", false),
                    new Product(null, "Анастасия", "Заменить передние фары", false),
                    new Product(null, "Дмитрий", "Почистить инжекторы", false),
                    new Product(null, "Виктория", "Подкачать колесо", false),
                    new Product(null, "Артем", "Проверить выхлопную систему", false),
                    new Product(null, "Евгений", "Устранить треск в рулевой колонке", false),
                    new Product(null, "Ксения", "Заменить ремень ГРМ", false)
            );

            productRepository.saveAll(products);
        }

    }

}