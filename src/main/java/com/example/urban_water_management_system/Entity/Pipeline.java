package com.example.urban_water_management_system.Entity;

import com.example.urban_water_management_system.Enum.PipelineEndpoint;
import com.example.urban_water_management_system.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pipeline")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pipeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pipeId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PipelineEndpoint fromType;

    @Column(nullable = false)
    private Long fromId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PipelineEndpoint toType;

    @Column(nullable = false)
    private Long toId;

    @Column(nullable = false)
    private Long capacity;

    private Long currFlow;

    private Double inPressure;

    private Double outPressure;

    @Enumerated(EnumType.STRING)
    private Status status;
}
