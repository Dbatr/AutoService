package com.example.AutoService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Workspaces")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace {
    // Уникальный идентификатор рабочего места
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkspaceID")
    private Long id;

    // Название рабочего места
    @Column(name = "WorkspaceName")
    private String workspaceName;

    // Количество рабочих мест на данном рабочем месте
    @Column(name = "NumberOfWorkplaces")
    private Integer numberOfWorkplaces;

    // Доступность рабочего места (свободен, занят и т.д.)
    @Column(name = "Availability")
    private String availability;

    // Тип выполняемой работы на рабочем месте
    @Column(name = "WorkType")
    private String workType;

    // Требования к рабочему месту (например, для каких видов работ подходит)
    @Column(name = "Requirements", length = 255)
    private String requirements;
}
