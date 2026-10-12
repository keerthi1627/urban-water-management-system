package com.example.city_water_management_system.Repository;

import com.example.city_water_management_system.Entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

}
