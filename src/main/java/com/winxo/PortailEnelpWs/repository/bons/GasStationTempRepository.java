package com.winxo.PortailEnelpWs.repository.bons;


import com.winxo.PortailEnelpWs.entities.bons.GasStationTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GasStationTempRepository extends JpaRepository<GasStationTemp, Integer> {

    @Query(value = "select g from GasStationTemp g where g.id_bordereau = :id")
    Optional<GasStationTemp> findGasStationTempById(Integer id);
}
