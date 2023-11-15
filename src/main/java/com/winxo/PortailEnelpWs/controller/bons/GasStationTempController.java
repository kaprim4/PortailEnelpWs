package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.GasStationTemp;
import com.winxo.PortailEnelpWs.repository.bons.GasStationTempRepository;
import com.winxo.PortailEnelpWs.service.bons.GasStationTempService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gas-station-temp")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GasStationTempController {

    private final GasStationTempService gasStationTempService;

    @Autowired
    private GasStationTempRepository gasStationRepository;

    @GetMapping("/all")
    public ResponseEntity<List<GasStationTemp>> getAllGasStationTemps () {
        List<GasStationTemp> gasStationTemp = gasStationTempService.findAllGasStationTemps();
        return new ResponseEntity<>(gasStationTemp, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GasStationTemp> addGasStationTemp(@RequestBody GasStationTemp gasStationTemp) {
        gasStationTemp.setIsDeleted(false);
        GasStationTemp user_added = gasStationTempService.addGasStationTemp(gasStationTemp);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GasStationTemp> getGasStationTempById (@PathVariable("id") Integer id) {
        Optional<GasStationTemp> gasStationTempOptional = gasStationRepository.findById(id);
        if (gasStationTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        GasStationTemp gasStationTemp_found = gasStationTempService.findGasStationTempById(id);
        return new ResponseEntity<>(gasStationTemp_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GasStationTemp> updateGasStationTemp(@RequestBody GasStationTemp gasStationTemp) {
        Optional<GasStationTemp> userOptional = gasStationRepository.findGasStationTempById(gasStationTemp.getId_bordereau());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        gasStationTemp.setIsDeleted(false);
        gasStationRepository.save(gasStationTemp);
        System.out.println(gasStationTemp);
        return new ResponseEntity<>(gasStationTemp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGasStationTemp(@PathVariable("id") Integer id) {
        Optional<GasStationTemp> gasStationOptional = gasStationRepository.findGasStationTempById(id);
        if (gasStationOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        gasStationTempService.deleteGasStationTemp(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
