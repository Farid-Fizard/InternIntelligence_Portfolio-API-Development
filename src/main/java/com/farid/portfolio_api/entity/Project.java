package com.farid.portfolio_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String technologiesUsed;
    private String url;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
