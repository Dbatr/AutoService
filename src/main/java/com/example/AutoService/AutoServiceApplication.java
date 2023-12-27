package com.example.AutoService;

import com.example.AutoService.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Главный класс Spring Boot приложения.
 */
@SpringBootApplication
public class AutoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

	/**
	 * Метод для инициализации тестовых данных при запуске приложения.
	 *
	 * @param mechanicService   Сервис для обработки бизнес-логики, связанной с механиками.
	 * @param workspaceService  Сервис для обработки бизнес-логики, связанной с рабочими местами (подъемниками).
	 * @param assignmentService Сервис для обработки бизнес-логики, связанной с заданиями (назначениями).
	 * @param productService    Сервис для обработки бизнес-логики, связанной с продуктами (заказами).
	 * @param userService       Сервис для обработки бизнес-логики, связанной с пользователями.
	 * @return Объект CommandLineRunner для инициализации данных.
	 */
	@Bean
	public CommandLineRunner initializeData(MechanicService mechanicService, WorkspaceService workspaceService, AssignmentService assignmentService,
											ProductService productService, UserService userService) {
		return args -> {
			mechanicService.initializeMechanicsData();
			workspaceService.initializeWorkspacesData();
			productService.initializeProductData();
			assignmentService.initializeAssignmentsData();
			userService.initializeUserData();
		};
	}
}
