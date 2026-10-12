package com.example.urban_water_management_system.Entity;

import com.example.urban_water_management_system.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Water Treatment Plant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaterTreatmentPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantId;

    @Column(unique = true, nullable = false)
    private String plantName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Long plantCapacity;

    private Long currProcessing;

    @Enumerated(EnumType.STRING)
    private Status status;
}
