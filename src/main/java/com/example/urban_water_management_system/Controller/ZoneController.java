package com.example.urban_water_management_system.Controller;

import com.example.urban_water_management_system.Entity.Zone;
import com.example.urban_water_management_system.Service.ZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    // add zone
    @PostMapping("/add")
    public Zone addZone(@RequestBody Zone zone) {

        return zoneService.addZone(zone);
    }

    // get zone by id
    @GetMapping("/get/{id}")
    public Zone getZoneById(@PathVariable("id") Long zoneId) {

        return zoneService.getZoneById(zoneId);
    }

    // get all zones
    @GetMapping("/all")
    public List<Zone> getAllZones() {

        return zoneService.getAllZones();
    }

    // delete zone
    @DeleteMapping("/delete/{id}")
    public String deleteZone(@PathVariable("id") Long zoneId) {

        zoneService.deleteZone(zoneId);

        return "Zone deleted successfully";
    }

}
