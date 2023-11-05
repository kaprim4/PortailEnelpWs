package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.GasStation;

import java.util.List;

public interface GasStationService {

    List<GasStation> findAllGasStations();

    GasStation findGasStationById(Integer id);

    GasStation updateGasStation(GasStation user);

    void deleteGasStation(Integer id);
}
