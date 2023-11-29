package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.Region;
import com.winxo.PortailEnelpWs.repository.RegionRepository;
import com.winxo.PortailEnelpWs.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/regions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Region>> getAllRegions () {
        List<Region> regions = regionService.findAllRegions();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Region> addRegion(@RequestBody Region region) {
        region.setIsDeleted(false);
        Region user_added = regionService.addRegion(region);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Region> getRegionById (@PathVariable("id") Integer id) {
        Optional<Region> userOptional = regionRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Region user_found = regionService.findRegionById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Region> updateRegion(@RequestBody Region region) {
        if (regionRepository.findRegionById(region.getId()).isPresent()) {
            Region region1 = regionRepository.findRegionById(region.getId()).get();
            region1.setLibelle(region.getLibelle());
            region1.setCode(region.getCode());
            region1.setUpdatedAt(LocalDateTime.now());
            region1.setIsDeleted(false);
            region1.setIsActivated(region.getIsActivated());
            regionRepository.save(region1);
            System.out.println(region1);
            return new ResponseEntity<>(region1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable("id") Integer id) {
        Optional<Region> regionOptional = regionRepository.findRegionById(id);
        if (regionOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
