package com.example.urban_water_management_system.Entity;

import com.example.urban_water_management_system.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Water Tank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaterTank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tankId;

    @Column(unique = true, nullable = false)
    private String tankName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Long tankCapacity;

    private Long currLevel;

    @Enumerated(EnumType.STRING)
    private Status status;
}
