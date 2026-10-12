package com.example.urban_water_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "zone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneId;

    @Column(unique = true, nullable = false)
    private String zoneName;

    @Column(nullable = false)
    private String location;

    private Long population;

    private Boolean active;
}
