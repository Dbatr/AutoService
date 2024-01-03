package com.example.AutoService.controllers;

import com.example.AutoService.models.Workspace;
import com.example.AutoService.services.WorkspaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/autoservice")
public class WorkspaceController {

    private final WorkspaceService workspaceService;

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

    // Метод для изменения количества рабочих мест
    @PatchMapping("/workspaces/{workspaceId}/updateNumberOfWorkplaces/{newNumberOfWorkplaces}")
    public ResponseEntity<String> updateNumberOfWorkplaces(@PathVariable Long workspaceId,
                                                              @PathVariable Integer newNumberOfWorkplaces) {
        Workspace updatedWorkspace = workspaceService.updateNumberOfWorkplaces(workspaceId, newNumberOfWorkplaces);

        if (updatedWorkspace != null) {
            return new ResponseEntity<>("Number of workplaces updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Workspace not found", HttpStatus.NOT_FOUND);
        }
    }

}
