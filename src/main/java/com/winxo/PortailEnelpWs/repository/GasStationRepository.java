package com.winxo.PortailEnelpWs.repository;

import com.winxo.PortailEnelpWs.entities.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
    Optional<GasStation> findGasStationById(Integer id);

    void deleteGasStationById(Integer id);
}
