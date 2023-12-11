package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.models.Workspace;
import com.example.AutoService.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
            // Получаем механика, рабочее место и продукт по их ID
            // здесь потом админ будет ставить
            Mechanic mechanic = mechanicService.getMechanicById(2L);
            Workspace workspace = workspaceService.getWorkspaceById(3L);
            Product product = productService.getProductById(4L);

            // Проверяем, что объекты не null
            if (mechanic != null && workspace != null && product != null) {
                // Создаем новый объект Assignment
                Assignment assignment = new Assignment();
                assignment.setMechanic(mechanic);
                assignment.setWorkspace(workspace);
                assignment.setProduct(product);

                // Сохраняем Assignment в базу данных
                assignmentRepository.save(assignment);
            }
        }

    }
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }


}