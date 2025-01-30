package com.farid.portfolio_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
