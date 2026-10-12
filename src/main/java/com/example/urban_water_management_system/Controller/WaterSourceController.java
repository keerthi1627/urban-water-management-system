package com.example.urban_water_management_system.Controller;

import com.example.urban_water_management_system.Entity.WaterSource;
import com.example.urban_water_management_system.Service.WaterSourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waterSource")
public class WaterSourceController {

    private final WaterSourceService waterSourceService;

    public WaterSourceController(WaterSourceService waterSourceService){

        this.waterSourceService = waterSourceService;
    }

    //create source
    @PostMapping("/add")
    public WaterSource addWaterSource(@RequestBody WaterSource waterSource){

        return waterSourceService.addWaterSource(waterSource);
    }

    //get source by id
    @GetMapping("/{id}")
    public WaterSource getSourceById(@PathVariable("id") Long sourceId){

        return waterSourceService.getSourceById(sourceId);
    }

    //get all sources
    @GetMapping("/all")
    public List<WaterSource> getAllSources(){

        return waterSourceService.getAllSources();
    }

    //update source
    @PutMapping("/update/{id}")
    public WaterSource updateCurrCapacity(@PathVariable("id") Long sourceId, @RequestParam Double updatedCapacity){

        return waterSourceService.updateCurrCapacity(sourceId, updatedCapacity);
    }

    //delete source
    @DeleteMapping("/{id}")
    public String deleteSourceById(@PathVariable("id") Long sourceId){

        waterSourceService.deleteWaterSource(sourceId);

        return "Water Source deleted successfully";
    }
}
