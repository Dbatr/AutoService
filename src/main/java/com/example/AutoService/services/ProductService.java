package com.example.AutoService.services;

import com.example.AutoService.models.Product;
import com.example.AutoService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Сервис для обработки бизнес-логики, связанной с продуктами (заявками).
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Получение дополнительной информации о продукте (заявке) по его идентификатору.
     *
     * @param id Идентификатор продукта (заявки).
     * @return Продукт (заявка) или null, если не найден.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Инициализация данных для продуктов (заявок).
     * Если в репозитории нет продуктов, создает и сохраняет список тестовых продуктов.
     */
    public void initializeProductData() {
        long count = productRepository.count();
        if (count == 0) {
            List<Product> products = Arrays.asList(
                    new Product(null, "Алексей", "Смирнов", "Поменять резину", "123456789", false),
                    new Product(null, "Михаил", "Иванов", "Помыть машину", "987654321", false),
                    new Product(null, "Иван", "Козлов", "Заменить масло", "555111333", false),
                    new Product(null, "Ольга", "Новикова", "Проверить тормоза", "999888777", false),
                    new Product(null, "Павел", "Петров", "Почистить фильтр воздуха", "444333222", false),
                    new Product(null, "Татьяна", "Иванова", "Покрасить капот", "111222333", false),
                    new Product(null, "Денис", "Смирнов", "Провести диагностику двигателя", "777888999", false),
                    new Product(null, "Елена", "Козлова", "Заменить тормозные колодки", "333444555", false),
                    new Product(null, "Никита", "Петров", "Проверить систему охлаждения", "666555444", false),
                    new Product(null, "Светлана", "Иванова", "Починить электропроводку", "222333444", false),
                    new Product(null, "Андрей", "Смирнов", "Установить новый аккумулятор", "888999000", false),
                    new Product(null, "Мария", "Иванова", "Заменить фильтр топлива", "555444333", false),
                    new Product(null, "Григорий", "Смирнов", "Полировка кузова", "000999888", false),
                    new Product(null, "Юлия", "Петрова", "Устранить звук в подвеске", "777666555", false),
                    new Product(null, "Сергей", "Иванов", "Проверить работу кондиционера", "222111000", false),
                    new Product(null, "Анастасия", "Смирнова", "Заменить передние фары", "888777666", false),
                    new Product(null, "Дмитрий", "Иванов", "Почистить инжекторы", "555666777", false),
                    new Product(null, "Виктория", "Смирнова", "Подкачать колесо", "000111222", false),
                    new Product(null, "Артем", "Иванов", "Проверить выхлопную систему", "777666555", false),
                    new Product(null, "Евгений", "Смирнов", "Устранить треск в рулевой колонке", "222111000", false),
                    new Product(null, "Ксения", "Иванова", "Заменить ремень ГРМ", "888999000", false)
            );

            productRepository.saveAll(products);
        }
    }

    /**
     * Получение списка всех продуктов (заявок).
     *
     * @return Список всех продуктов (заявок).
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Создание нового продукта (заявки) и сохранение его в репозитории.
     *
     * @param product Новый продукт (заявка) для сохранения.
     */
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * Обновление статуса выполнения продукта (заявки).
     *
     * @param productId Идентификатор продукта (заявки).
     * @param completed Новый статус выполнения продукта (true, если выполнено, иначе false).
     * @return true, если обновление прошло успешно, иначе false.
     */
    public boolean updateProductStatus(Long productId, boolean completed) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setCompleted(completed);
            productRepository.save(product);
            return true;
        } else {
            return false;
        }
    }
}