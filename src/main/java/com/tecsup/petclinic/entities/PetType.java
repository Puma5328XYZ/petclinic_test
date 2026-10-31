package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 100)
    private String description;

    private Boolean active;

    @Column(name = "size_category")
    private String sizeCategory;

    @Column(name = "average_lifespan")
    private Integer averageLifespan;

    @Column(name = "care_level")
    private String careLevel;
}