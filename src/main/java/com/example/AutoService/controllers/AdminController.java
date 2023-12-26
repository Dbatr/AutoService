package com.example.AutoService.controllers;

import com.example.AutoService.models.*;
import com.example.AutoService.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/autoservice")
public class AdminController {


    private final ProductService productService;
    private final MechanicService mechanicService;
    private final WorkspaceService workspaceService;
    private final AssignmentService assignmentService;
    private final UserService userService;

    // Получение всех механиков
    @GetMapping("/mechanics")
    public List<Mechanic> getAllMechanicsForAdmin() {
        return mechanicService.getAllMechanics();
    }

    // Получение механика по ID
    @GetMapping("/mechanics/{mechanicId}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable Long mechanicId) {
        Mechanic mechanic = mechanicService.getMechanicById(mechanicId);

        if (mechanic != null) {
            return new ResponseEntity<>(mechanic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Изменение статуса onDuty механика на "Да"
    @PatchMapping("/mechanics/{mechanicId}/onDuty/true")
    public ResponseEntity<String> setMechanicOnDuty(@PathVariable Long mechanicId) {
        boolean updated = mechanicService.updateMechanicOnDuty(mechanicId, true);

        if (updated) {
            return new ResponseEntity<>("Mechanic status set to On Duty", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mechanic not found", HttpStatus.NOT_FOUND);
        }
    }

    // Изменение статуса onDuty механика на "Нет"
    @PatchMapping("/mechanics/{mechanicId}/onDuty/false")
    public ResponseEntity<String> setMechanicOffDuty(@PathVariable Long mechanicId) {
        boolean updated = mechanicService.updateMechanicOnDuty(mechanicId, false);

        if (updated) {
            return new ResponseEntity<>("Mechanic status set to Off Duty", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Mechanic not found", HttpStatus.NOT_FOUND);
        }
    }

    // Получение всех рабочих мест
    @GetMapping("/workspaces")
    public List<Workspace> getAllWorkspacesForAdmin() {
        return workspaceService.getAllWorkspaces();
    }

    // Получение рабочего места по ID
    @GetMapping("/workspaces/{workspaceId}")
    public ResponseEntity<Workspace> getWorkspaceById(@PathVariable Long workspaceId) {
        Workspace workspace = workspaceService.getWorkspaceById(workspaceId);

        if (workspace != null) {
            return new ResponseEntity<>(workspace, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

    // Получение всех заданий (assignments)
    @GetMapping("/assignments")
    public List<Assignment> getAllAssignmentsForAdmin() {
        return assignmentService.getAllAssignments();
    }

    // Получение задания (assignment) по ID
    @GetMapping("/assignments/{assignmentId}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long assignmentId) {
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);

        if (assignment != null) {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Добавление нового задания (assignment)
    @PostMapping("/addAssignment")
    public String createAssignment(@RequestBody Assignment assignment) {

        assignmentService.createAssignment(assignment);

        return "Assignment added";
    }

    // Добавление нового заказа (продукта)
    @PostMapping("/addOrder")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product added";
    }

    // Добавление нового механика
    @PostMapping("/addMechanic")
    public String createMechanic(@RequestBody Mechanic mechanic){
        mechanicService.createMechanic(mechanic);
        return "Mechanic added";
    }

    // Получение всех пользователей
    @GetMapping("/users")
    public List<User> getAllUsersForAdmin() {
        return userService.getAllUsers();
    }

    // Получение пользователя по ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
