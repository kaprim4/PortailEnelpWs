package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.*;
import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.repository.GasStationRepository;
import com.winxo.PortailEnelpWs.service.*;
import com.winxo.PortailEnelpWs.service.GasStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gas_stations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GasStationController {

    private final GasStationService gasStationService;
    private final CompanyService companyService;
    private final SupervisorService supervisorService;
    private final CityService cityService;

    @Autowired
    private GasStationRepository gasStationRepository;

    @GetMapping("/all")
    public ResponseEntity<List<GasStation>> getAllGasStations () {
        List<GasStation> gasStations = gasStationService.findAllGasStations();
        return new ResponseEntity<>(gasStations, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GasStation> addGasStation(@RequestBody GasStation gasStation) {
        Company company = companyService.findCompanyById(gasStation.getCompany().getId());
        Supervisor supervisor = supervisorService.findSupervisorById(gasStation.getSupervisor().getId());
        City city = cityService.findCityById(gasStation.getCity().getId());
        gasStation.setCompany(company);
        gasStation.setSupervisor(supervisor);
        gasStation.setCity(city);
        gasStation.setIsDeleted(false);
        GasStation user_added = gasStationService.addGasStation(gasStation);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GasStation> getGasStationById (@PathVariable("id") Integer id) {
        Optional<GasStation> userOptional = gasStationRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        GasStation user_found = gasStationService.findGasStationById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GasStation> updateGasStation(@RequestBody GasStation gasStation) {
        if (gasStationRepository.findGasStationById(gasStation.getId()).isPresent()) {
            GasStation gasStation1 = gasStationRepository.findGasStationById(gasStation.getId()).get();
            Company company = companyService.findCompanyById(gasStation.getCompany().getId());
            Supervisor supervisor = supervisorService.findSupervisorById(gasStation.getSupervisor().getId());
            City city = cityService.findCityById(gasStation.getCity().getId());
            gasStation1.setCompany(company);
            gasStation1.setSupervisor(supervisor);
            gasStation1.setCity(city);
            gasStation1.setLibelle(gasStation.getLibelle());
            gasStation1.setAddress(gasStation.getAddress());
            gasStation1.setCode_sap(gasStation.getCode_sap());
            gasStation1.setLatitude(gasStation.getLatitude());
            gasStation1.setLongitude(gasStation.getLongitude());
            gasStation1.setZip_code(gasStation.getZip_code());
            gasStation1.setUpdatedAt(LocalDateTime.now());
            gasStation1.setIsDeleted(false);
            gasStation1.setIsActivated(gasStation.getIsActivated());
            gasStationRepository.save(gasStation1);
            System.out.println(gasStation1);
            return new ResponseEntity<>(gasStation1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGasStation(@PathVariable("id") Integer id) {
        Optional<GasStation> gasStationOptional = gasStationRepository.findGasStationById(id);
        if (gasStationOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        gasStationService.deleteGasStation(id);
        return new ResponseEntity<>(gasStationOptional, HttpStatus.OK);
    }

}
