package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.Region;

import java.util.List;

public interface RegionService {

    List<Region> findAllRegions();

    Region findRegionById(Integer id);

    Region addRegion(Region region);

    Region updateRegion(Region region);

    void deleteRegion(Integer id);
}
