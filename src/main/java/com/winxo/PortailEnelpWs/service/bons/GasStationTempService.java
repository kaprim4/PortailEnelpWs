package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.GasStationTemp;
import java.util.List;

public interface GasStationTempService {

    List<GasStationTemp> findAllGasStationTemps();

    GasStationTemp findGasStationTempById(Integer id);

    GasStationTemp addGasStationTemp(GasStationTemp gasStationTemp);

    GasStationTemp updateGasStationTemp(GasStationTemp gasStationTemp);

    void deleteGasStationTemp(Integer id);
}
