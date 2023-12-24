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

    @GetMapping("/workspaces")
    public List<Workspace> getAllWorkspacesForAdmin() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/orders")
    public List<Product> getAllOrdersForAdmin() {
        return productService.getAllProducts();
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignmentsForAdmin() {
        return assignmentService.getAllAssignments();
    }

    @PostMapping("/addAssignment")
    public String createAssignment(@RequestBody Assignment assignment) {

        assignmentService.createAssignment(assignment);

        return "Assignment added";
    }

    @PostMapping("/addOrder")
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "product added";
    }


}
