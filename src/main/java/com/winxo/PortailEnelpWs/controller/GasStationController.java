package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.service.GasStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gas_stations")
@RequiredArgsConstructor
public class GasStationController {

    private final GasStationService gasStationService;

    @GetMapping("/all")
    public ResponseEntity<List<GasStation>> getAllGasStations () {
        List<GasStation> gasStations = gasStationService.findAllGasStations();
        return new ResponseEntity<>(gasStations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GasStation> getGasStationById (@PathVariable("id") Integer id) {
        GasStation gasStation = gasStationService.findGasStationById(id);
        return new ResponseEntity<>(gasStation, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GasStation> updateGasStation(@RequestBody GasStation gasStation) {
        GasStation updateGasStation = gasStationService.updateGasStation(gasStation);
        return new ResponseEntity<>(updateGasStation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGasStation(@PathVariable("id") Integer id) {
        gasStationService.deleteGasStation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
