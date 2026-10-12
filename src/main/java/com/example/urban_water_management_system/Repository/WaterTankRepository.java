package com.example.urban_water_management_system.Repository;

import com.example.urban_water_management_system.Entity.WaterTank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterTankRepository extends JpaRepository<WaterTank, Long> {

}
