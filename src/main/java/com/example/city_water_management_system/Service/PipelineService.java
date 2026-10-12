package com.example.city_water_management_system.Service;

import com.example.city_water_management_system.Entity.Pipeline;
import com.example.city_water_management_system.Enum.PipelineEndpoint;
import com.example.city_water_management_system.Enum.Status;
import com.example.city_water_management_system.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipelineService {

    private final PipelineRepository pipelineRepository;
    private final WaterSourceRepository waterSourceRepository;
    private final WaterTreatmentPlantRepository waterTreatmentPlantRepository;
    private final WaterTankRepository waterTankRepository;
    private final ZoneRepository zoneRepository;

    public PipelineService(PipelineRepository pipelineRepository,
                           WaterSourceRepository waterSourceRepository,
                           WaterTreatmentPlantRepository waterTreatmentPlantRepository,
                           WaterTankRepository waterTankRepository,
                           ZoneRepository zoneRepository){

        this.pipelineRepository = pipelineRepository;
        this.waterSourceRepository = waterSourceRepository;
        this.waterTreatmentPlantRepository = waterTreatmentPlantRepository;
        this.waterTankRepository = waterTankRepository;
        this.zoneRepository = zoneRepository;
    }

    public Pipeline addPipeline(Pipeline pipeline) {

        if(!validateEndpoint(pipeline.getFromType(), pipeline.getFromId())) throw new RuntimeException("Invalid Source type or id");

        if(!validateEndpoint(pipeline.getToType(), pipeline.getToId())) throw new RuntimeException("Invalid destination type or id");

        if(!validateFlowDirection(pipeline.getFromType(), pipeline.getToType())) throw new RuntimeException("Incorrect pipeline flow direction");

        if(pipeline.getCurrFlow() > pipeline.getCapacity()) throw new RuntimeException("Current flow cannot be greater than pipeline capacity");

        return pipelineRepository.save(pipeline);
    }

    public Pipeline getPipelineById(Long pipeId) {

        return pipelineRepository.findById(pipeId).orElseThrow(() -> new RuntimeException("Invalid Pipeline Id"));
    }

    public List<Pipeline> getAllPipelines() {

        return pipelineRepository.findAll();
    }

    public Pipeline updateCurrFlow(Long pipeId, Long updatedFlow) {

        Pipeline pipeline = pipelineRepository.findById(pipeId).orElseThrow(() -> new RuntimeException("Invalid Pipeline Id"));

        if (updatedFlow < 0) throw new RuntimeException("Flow cannot be less than 0");

        if (updatedFlow > pipeline.getCapacity()) throw new RuntimeException("Flow cannot be greater than Pipeline Capacity");

        pipeline.setCurrFlow(updatedFlow);

        return pipelineRepository.save(pipeline);
    }

    public void deletePipeline(Long pipeId) {

        if (!pipelineRepository.existsById(pipeId)) throw new RuntimeException("Invalid Pipeline Id");

        pipelineRepository.deleteById(pipeId);
    }

    public boolean validateEndpoint(PipelineEndpoint type, Long id){

        if((type.equals(PipelineEndpoint.WATER_SOURCE) && waterSourceRepository.existsById(id)) ||
           (type.equals(PipelineEndpoint.WATER_TREATMENT_PLANT) && waterTreatmentPlantRepository.existsById(id)) ||
           (type.equals(PipelineEndpoint.WATER_TANK) && waterTankRepository.existsById(id)) ||
           (type.equals(PipelineEndpoint.ZONE) && zoneRepository.existsById(id))){

            return true;
        }

        return false;
    }

    public boolean validateFlowDirection(PipelineEndpoint fromType, PipelineEndpoint toType) {

        if((fromType.equals(PipelineEndpoint.WATER_SOURCE) && toType.equals(PipelineEndpoint.WATER_TREATMENT_PLANT)) ||
           (fromType.equals(PipelineEndpoint.WATER_TREATMENT_PLANT) && toType.equals(PipelineEndpoint.WATER_TANK)) ||
           (fromType.equals(PipelineEndpoint.WATER_TANK) && toType.equals(PipelineEndpoint.ZONE))) {

            return true;
        }

        return false;
    }

    public void updateStatus(Long pipeId, Status updatedStatus) {

        Pipeline pipeline = pipelineRepository.findById(pipeId).orElseThrow(() -> new RuntimeException("Invalid pipeline id"));
        pipeline.setStatus(updatedStatus);

        pipelineRepository.save(pipeline);
    }
}
