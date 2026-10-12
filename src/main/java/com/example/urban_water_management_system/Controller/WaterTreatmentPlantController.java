package com.example.urban_water_management_system.Controller;

import com.example.urban_water_management_system.Entity.WaterTreatmentPlant;
import com.example.urban_water_management_system.Service.WaterTreatmentPlantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waterTreatmentPlant")
public class WaterTreatmentPlantController {

    private final WaterTreatmentPlantService waterTreatmentPlantService;

    public WaterTreatmentPlantController(WaterTreatmentPlantService waterTreatmentPlantService){

        this.waterTreatmentPlantService = waterTreatmentPlantService;
    }

    //add plant
    @PostMapping("/add")
    public WaterTreatmentPlant addPlant(@RequestBody WaterTreatmentPlant waterTreatmentPlant){

        return waterTreatmentPlantService.addPlant(waterTreatmentPlant);
    }

    //get plant by id
    @GetMapping("/get/{id}")
    public WaterTreatmentPlant getByid(@PathVariable("id") Long plantId){

        return waterTreatmentPlantService.getById(plantId);
    }

    //get all plants
    @GetMapping("/all")
    public List<WaterTreatmentPlant> getAllPlants(){

        return waterTreatmentPlantService.getAllPlants();
    }

    //update plant
    @PutMapping("/update/{id}")
    public WaterTreatmentPlant updateCurrProcessing(@PathVariable("id") Long plantId, @RequestParam Long updatedProcessing){

        return waterTreatmentPlantService.updateCurrProcessing(plantId, updatedProcessing);
    }

    //remove plant
    @DeleteMapping("/remove/{id}")
    public String deletePlant(@PathVariable("id") Long plantId){

        waterTreatmentPlantService.deletePlant(plantId);

        return "Water Treatment Plant deleted successfully";
    }
}
