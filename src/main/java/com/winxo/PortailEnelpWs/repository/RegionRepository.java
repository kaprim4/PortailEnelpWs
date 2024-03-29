package com.winxo.PortailEnelpWs.repository;

import com.winxo.PortailEnelpWs.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<Region> findRegionById(Integer id);
}
