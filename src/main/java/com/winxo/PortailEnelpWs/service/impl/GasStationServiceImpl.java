package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.GasStationRepository;
import com.winxo.PortailEnelpWs.service.GasStationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class GasStationServiceImpl implements GasStationService
{

    private final GasStationRepository gasStationRepository;

    @Autowired
    public GasStationServiceImpl(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public GasStation addGasStation(GasStation employee) {
        return gasStationRepository.save(employee);
    }

    public List<GasStation> findAllGasStations() {
        return gasStationRepository.findAll();
    }

    public GasStation updateGasStation(GasStation employee) {
        return gasStationRepository.save(employee);
    }

    public GasStation findGasStationById(Integer id) {
        return gasStationRepository.findGasStationById(id)
                .orElseThrow(() -> new NotFoundException("GasStation by id " + id + " was not found"));
    }

    public void deleteGasStation(Integer id){
        gasStationRepository.deleteGasStationById(id);
    }
}
