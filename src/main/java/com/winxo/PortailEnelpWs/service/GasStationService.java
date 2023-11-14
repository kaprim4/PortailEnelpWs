package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.GasStation;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface GasStationService {

    List<GasStation> findAllGasStations();

    GasStation findGasStationById(Integer id);

    GasStation addGasStation(GasStation gasStation);

    GasStation updateGasStation(GasStation gasStation);

    @Modifying
    void deleteGasStation(Integer id);
}
