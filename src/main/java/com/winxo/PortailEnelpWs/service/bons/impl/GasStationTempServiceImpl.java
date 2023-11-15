package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.GasStationTemp;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.GasStationTempRepository;
import com.winxo.PortailEnelpWs.service.bons.GasStationTempService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class GasStationTempServiceImpl implements GasStationTempService
{

    private final GasStationTempRepository gasStationTempRepository;

    @Autowired
    public GasStationTempServiceImpl(GasStationTempRepository gasStationTempRepository) {
        this.gasStationTempRepository = gasStationTempRepository;
    }

    public GasStationTemp addGasStationTemp(GasStationTemp GasStationTemp) {
        return gasStationTempRepository.save(GasStationTemp);
    }

    public List<GasStationTemp> findAllGasStationTemps() {
        return gasStationTempRepository.findAll();
    }

    public GasStationTemp updateGasStationTemp(GasStationTemp GasStationTemp) {
        return gasStationTempRepository.save(GasStationTemp);
    }

    public GasStationTemp findGasStationTempById(Integer id) {
        return gasStationTempRepository
                .findGasStationTempById(id)
                .orElseThrow(() -> new NotFoundException("GasStationTemp by id " + id + " was not found"));
    }

    public void deleteGasStationTemp(Integer id) {
        gasStationTempRepository.deleteById(id);
    }
}
