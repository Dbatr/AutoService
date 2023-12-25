package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.models.Workspace;
import com.example.AutoService.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MechanicService mechanicService;
    private final WorkspaceService workspaceService;
    private final ProductService productService;

    public AssignmentService(AssignmentRepository assignmentRepository, MechanicService mechanicService, WorkspaceService workspaceService, ProductService productService) {
        this.assignmentRepository = assignmentRepository;
        this.mechanicService = mechanicService;
        this.workspaceService = workspaceService;
        this.productService = productService;
    }

    public void initializeAssignmentsData() {
        if (assignmentRepository.count() == 0) {
            // Получаем коллекции механиков, рабочих мест и продуктов по их ID
            // Здесь вы должны предоставить методы получения коллекций по необходимости
            List<Mechanic> mechanics = Arrays.asList(
                    mechanicService.getMechanicById(2L),
                    mechanicService.getMechanicById(3L),
                    mechanicService.getMechanicById(4L),
                    mechanicService.getMechanicById(5L),
                    mechanicService.getMechanicById(5L)
                    // Добавьте других механиков, если необходимо
            );

            List<Workspace> workspaces = Arrays.asList(
                    workspaceService.getWorkspaceById(3L),
                    workspaceService.getWorkspaceById(1L),
                    workspaceService.getWorkspaceById(2L),
                    workspaceService.getWorkspaceById(4L),
                    workspaceService.getWorkspaceById(5L),
                    workspaceService.getWorkspaceById(1L)
                    // Добавьте другие рабочие места, если необходимо
            );

            List<Product> products = Arrays.asList(
                    productService.getProductById(4L),
                    productService.getProductById(16L),
                    productService.getProductById(1L),
                    productService.getProductById(6L),
                    productService.getProductById(13L),
                    productService.getProductById(12L)
                    // Добавьте другие продукты, если необходимо
            );

            // Проверяем, что коллекции не содержат null объектов
            if (!mechanics.contains(null) && !workspaces.contains(null) && !products.contains(null)) {
                // Создаем и сохраняем Assignment только для уникальных комбинаций
                for (int i = 0; i < mechanics.size(); i++) {
                    Mechanic mechanic = mechanics.get(i);
                    Workspace workspace = workspaces.get(i);
                    Product product = products.get(i);

                    Assignment assignment = new Assignment();
                    assignment.setMechanic(mechanic);
                    assignment.setWorkspace(workspace);
                    assignment.setProduct(product);
                    assignmentRepository.save(assignment);
                }
            }
        }
    }


    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public void createAssignment(Assignment assignment) {
        // Добавьте любую дополнительную логику или валидацию при необходимости
        assignmentRepository.save(assignment);
    }

    public Assignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null);
    }
}