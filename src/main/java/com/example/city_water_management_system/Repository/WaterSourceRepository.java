package com.example.city_water_management_system.Repository;

import com.example.city_water_management_system.Entity.WaterSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterSourceRepository extends JpaRepository<WaterSource, Long> {


}
