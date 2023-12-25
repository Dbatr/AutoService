package com.example.AutoService.controllers;

import com.example.AutoService.models.Assignment;
import com.example.AutoService.models.Mechanic;
import com.example.AutoService.models.Product;
import com.example.AutoService.models.Workspace;
import com.example.AutoService.services.AssignmentService;
import com.example.AutoService.services.MechanicService;
import com.example.AutoService.services.ProductService;
import com.example.AutoService.services.WorkspaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    private final ProductService productService;
    private final MechanicService mechanicService;
    private final WorkspaceService workspaceService;
    private final AssignmentService assignmentService;

    @GetMapping("/mechanics")
    public List<Mechanic> getAllMechanicsForAdmin() {
        return mechanicService.getAllMechanics();
    }

    @GetMapping("/mechanics/{mechanicId}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable Long mechanicId) {
        Mechanic mechanic = mechanicService.getMechanicById(mechanicId);

        if (mechanic != null) {
            return new ResponseEntity<>(mechanic, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/workspaces")
    public List<Workspace> getAllWorkspacesForAdmin() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/orders")
    public List<Product> getAllOrdersForAdmin() {
        return productService.getAllProducts();
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long orderId) {
        Product product = productService.getProductById(orderId);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignmentsForAdmin() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/assignments/{assignmentId}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long assignmentId) {
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);

        if (assignment != null) {
            return new ResponseEntity<>(assignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAssignment")
    public String createAssignment(@RequestBody Assignment assignment) {

        assignmentService.createAssignment(assignment);

        return "Assignment added";
    }

    @PostMapping("/addOrder")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product added";
    }

    @PostMapping("/addMechanic")
    public String createMechanic(@RequestBody Mechanic mechanic){
        mechanicService.createMechanic(mechanic);
        return "Mechanic added";
    }





}
