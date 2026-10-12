package com.example.urban_water_management_system.Service;

import com.example.urban_water_management_system.Entity.Zone;
import com.example.urban_water_management_system.Repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public Zone addZone(Zone zone) {

        return zoneRepository.save(zone);
    }

    public Zone getZoneById(Long zoneId) {

        return zoneRepository.findById(zoneId).orElseThrow(() -> new RuntimeException("Invalid Zone Id"));
    }

    public List<Zone> getAllZones() {

        return zoneRepository.findAll();
    }

    public void deleteZone(Long zoneId) {

        if (!zoneRepository.existsById(zoneId))throw new RuntimeException("Invalid Zone Id");

        zoneRepository.deleteById(zoneId);
    }
}
