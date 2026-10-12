package com.example.city_water_management_system.Controller;

import com.example.city_water_management_system.Entity.WaterTank;
import com.example.city_water_management_system.Service.WaterTankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waterTank")
public class WaterTankController {

    private final WaterTankService waterTankService;

    public WaterTankController(WaterTankService waterTankService){

        this.waterTankService = waterTankService;
    }

    //add tank
    @PostMapping("/add")
    public WaterTank addTank(@RequestBody WaterTank waterTank){

        return waterTankService.addTank(waterTank);
    }

    //get tank by id
    @GetMapping("/get/{id}")
    public WaterTank getTankById(@PathVariable("id") Long tankId){

        return waterTankService.getTankById(tankId);
    }

    //get all tanks
    @GetMapping("/all")
    public List<WaterTank> getAllTanks(){

        return waterTankService.getAllTanks();
    }

    //update curr level
    @PutMapping("/update/{id}")
    public WaterTank updateCurrLevel(@PathVariable("id") Long tankId, @RequestParam Long updatedLevel){

        return waterTankService.updateCurrLevel(tankId, updatedLevel);
    }

    //delete tank
    @DeleteMapping("/delete/{id}")
    public String deleteTank(@PathVariable("id") Long tankId){

        waterTankService.deleteTank(tankId);

        return "Water Tank Deleted Successfully";
    }
}
