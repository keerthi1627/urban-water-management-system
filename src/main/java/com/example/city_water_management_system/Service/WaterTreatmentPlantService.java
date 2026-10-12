package com.example.city_water_management_system.Service;

import com.example.city_water_management_system.Entity.WaterTreatmentPlant;
import com.example.city_water_management_system.Repository.WaterTreatmentPlantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterTreatmentPlantService {

    private final WaterTreatmentPlantRepository waterTreatmentPlantRepository;

    public WaterTreatmentPlantService(WaterTreatmentPlantRepository waterTreatmentPlantRepository){

        this.waterTreatmentPlantRepository = waterTreatmentPlantRepository;
    }


    public WaterTreatmentPlant addPlant(WaterTreatmentPlant waterTreatmentPlant) {

        return waterTreatmentPlantRepository.save(waterTreatmentPlant);
    }

    public WaterTreatmentPlant getById(Long plantId) {

        WaterTreatmentPlant waterTreatmentPlant = waterTreatmentPlantRepository.findById(plantId).orElseThrow(() -> new RuntimeException("Invalid Plant Id"));

        return waterTreatmentPlant;
    }

    public List<WaterTreatmentPlant> getAllPlants() {

        return waterTreatmentPlantRepository.findAll();
    }

    public WaterTreatmentPlant updateCurrProcessing(Long plantId, Long updatedProcessing){

        WaterTreatmentPlant  waterTreatmentPlant = waterTreatmentPlantRepository.findById(plantId).orElseThrow(() -> new RuntimeException("Invalid plant id"));

        if(updatedProcessing < 0) throw new RuntimeException("Processing Capacity cannot be less than 0");

        if(updatedProcessing > waterTreatmentPlant.getPlantCapacity()) throw new RuntimeException("Processing Capacity cannot be greater than Plant Capacity");

        waterTreatmentPlant.setCurrProcessing(updatedProcessing);

        return waterTreatmentPlantRepository.save(waterTreatmentPlant);
    }

    public void deletePlant(Long plantId) {

        if(!waterTreatmentPlantRepository.existsById(plantId)) throw new RuntimeException("Invalid plant id");

        waterTreatmentPlantRepository.deleteById(plantId);
    }
}
