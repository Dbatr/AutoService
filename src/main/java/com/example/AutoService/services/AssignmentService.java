package com.example.AutoService.services;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.models.Workspace;
import com.example.AutoService.repositories.AssignmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MechanicService mechanicService;
    private final WorkspaceService workspaceService;
    private final ProductService productService;

    /**
     * Инициализация данных для заданий.
     * Проверяет, есть ли уже задания в репозитории.
     * Если заданий нет, создает списки механиков, рабочих мест и продуктов по их ID,
     * а затем создает и сохраняет объекты Assignment для уникальных комбинаций механиков, рабочих мест и продуктов.
     */
    public void initializeAssignmentsData() {
        if (assignmentRepository.count() == 0) {
            // Получаем коллекции механиков, рабочих мест и продуктов по их ID
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

    /**
     * Получение списка всех заданий.
     *
     * @return Список всех заданий.
     */
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    /**
     * Создание нового задания и сохранение его в репозитории.
     *
     * @param assignment Новое задание для сохранения.
     */
    public void createAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }

    /**
     * Получение задания по его уникальному идентификатору.
     *
     * @param assignmentId Уникальный идентификатор задания.
     * @return Задание или null, если не найдено.
     */
    public Assignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null);
    }
}