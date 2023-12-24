package com.example.AutoService;

import com.example.AutoService.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoServiceApplication.class, args);
	}

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
