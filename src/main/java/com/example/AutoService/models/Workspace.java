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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WorkspaceID")
    private Long id;

    @Column(name = "WorkspaceName")
    private String workspaceName;

    @Column(name = "NumberOfWorkplaces")
    private Integer numberOfWorkplaces;

    @Column(name = "Availability")
    private String availability;

    @Column(name = "WorkType")
    private String workType;

    @Column(name = "Requirements", length = 255)
    private String requirements;

    // Constructors, getters, setters, and other necessary methods
}
