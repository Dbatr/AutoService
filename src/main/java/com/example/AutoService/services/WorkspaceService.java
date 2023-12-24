package com.example.AutoService.services;

import com.example.AutoService.models.Workspace;
import com.example.AutoService.repositories.WorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class WorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceService(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    public void initializeWorkspacesData() {
        if (workspaceRepository.count() == 0) {
            List<Workspace> workspaces = Arrays.asList(
                    new Workspace(null, "Главный Бокс", 4, "Свободен", "Серьезная работа", "Подходить для любой работы"),
                    new Workspace(null, "Большой Бокс", 5, "Занят", "Трудная работа", "Множество услуг"),
                    new Workspace(null, "Подъемник 1", 4, "Занят", "Простая работа", "Основные инструменты"),
                    new Workspace(null, "Подъемник 2", 2, "Свободен", "Серьезная работа", "Специализирован для механической части"),
                    new Workspace(null, "Подъемник 3", 2, "Занят", "Трудная работа", "Специализирован для обслуживания и электроники")
            );

            workspaceRepository.saveAll(workspaces);
        }
    }

    public Workspace getWorkspaceById(Long id) {
        return workspaceRepository.findById(id).orElse(null);
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceRepository.findAll();
    }
}
