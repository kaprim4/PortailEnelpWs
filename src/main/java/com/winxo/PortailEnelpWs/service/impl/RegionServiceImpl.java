package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.Region;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.RegionRepository;
import com.winxo.PortailEnelpWs.service.RegionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegionServiceImpl implements RegionService
{

    private final RegionRepository RegionRepository;

    @Autowired
    public RegionServiceImpl(RegionRepository RegionRepository) {
        this.RegionRepository = RegionRepository;
    }

    public Region addRegion(Region Region) {
        return RegionRepository.save(Region);
    }

    public List<Region> findAllRegions() {
        return RegionRepository.findAll();
    }

    public Region updateRegion(Region Region) {
        return RegionRepository.save(Region);
    }

    public Region findRegionById(Integer id) {
        return RegionRepository
                .findRegionById(id)
                .orElseThrow(() -> new NotFoundException("Region by id " + id + " was not found"));
    }

    public void deleteRegion(Integer id) {
        RegionRepository.deleteById(id);
    }
}
