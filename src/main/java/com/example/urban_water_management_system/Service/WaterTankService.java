package com.example.urban_water_management_system.Service;

import com.example.urban_water_management_system.Entity.WaterTank;
import com.example.urban_water_management_system.Repository.WaterTankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterTankService {

    private final WaterTankRepository waterTankRepository;

    public WaterTankService(WaterTankRepository waterTankRepository){

        this.waterTankRepository = waterTankRepository;
    }

    public WaterTank addTank(WaterTank waterTank) {

        return waterTankRepository.save(waterTank);
    }

    public WaterTank getTankById(Long tankId) {

        WaterTank waterTank = waterTankRepository.findById(tankId).orElseThrow(() -> new RuntimeException("Invalid Tank Id"));

        return waterTank;
    }

    public List<WaterTank> getAllTanks() {

        return waterTankRepository.findAll();
    }


    public WaterTank updateCurrLevel(Long tankId, Long updatedLevel) {

        WaterTank waterTank = waterTankRepository.findById(tankId).orElseThrow(() -> new RuntimeException("Invalid Tank Id"));

        if(updatedLevel < 0) throw new RuntimeException("Water Level cannot be less than 0");

        if(updatedLevel > waterTank.getTankCapacity()) throw new RuntimeException("Water Level cannot be greater than Tank Capacity");

        waterTank.setCurrLevel(updatedLevel);

        return waterTankRepository.save(waterTank);
    }

    public void deleteTank(Long tankId) {

        waterTankRepository.deleteById(tankId);
    }
}
