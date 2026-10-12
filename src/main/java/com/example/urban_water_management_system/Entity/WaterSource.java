package com.example.urban_water_management_system.Entity;

import com.example.urban_water_management_system.Enum.SourceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WaterSource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaterSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sourceId;

    @Column(nullable = false)
    private String sourceName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SourceType sourceType;

    private String location;

    private Double maxCapacity;

    private Double currLevel;
}
