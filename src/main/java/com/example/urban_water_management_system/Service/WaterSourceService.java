package com.example.urban_water_management_system.Service;

import com.example.urban_water_management_system.Entity.WaterSource;
import com.example.urban_water_management_system.Repository.WaterSourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterSourceService {

    private final WaterSourceRepository waterSourceRepository;

    public WaterSourceService(WaterSourceRepository waterSourceRepository){

        this.waterSourceRepository = waterSourceRepository;
    }

    public WaterSource addWaterSource(WaterSource waterSource){

        return waterSourceRepository.save(waterSource);
    }

    public WaterSource getSourceById(Long sourceId){

        return waterSourceRepository.findById(sourceId).orElseThrow(() -> new RuntimeException("Invalid source id"));
    }

    public List<WaterSource> getAllSources(){

        return waterSourceRepository.findAll();
    }

    public void deleteWaterSource(Long sourceId){

        if(!waterSourceRepository.existsById(sourceId)) throw new RuntimeException("Source Id not found");

        waterSourceRepository.deleteById(sourceId);
    }

    public WaterSource updateCurrCapacity(Long sourceId, Double updatedCapacity) {

        WaterSource waterSource = waterSourceRepository.findById(sourceId).orElseThrow(() -> new RuntimeException("Invalid Source id"));

        if(updatedCapacity < 0) throw new RuntimeException("Capacity cannot be less than 0");

        if(updatedCapacity > waterSource.getMaxCapacity()) {

            // flood warning sms

        }

        waterSource.setCurrLevel(updatedCapacity);

        return waterSourceRepository.save(waterSource);
    }
}
