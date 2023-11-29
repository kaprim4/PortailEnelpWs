package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.repository.CityRepository;
import com.winxo.PortailEnelpWs.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    private final CityService cityService;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/all")
    public ResponseEntity<List<City>> getAllCities () {
        List<City> cities = cityService.findAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        city.setIsDeleted(false);
        City user_added = cityService.addCity(city);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<City> getCityById (@PathVariable("id") Integer id) {
        Optional<City> userOptional = cityRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        City user_found = cityService.findCityById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        if (cityRepository.findCityById(city.getId()).isPresent()) {
            City city1 = cityRepository.findCityById(city.getId()).get();
            city1.setLibelle(city.getLibelle());
            city1.setUpdatedAt(LocalDateTime.now());
            city1.setIsDeleted(false);
            city1.setIsActivated(city.getIsActivated());
            cityRepository.save(city1);
            System.out.println(city1);
            return new ResponseEntity<>(city1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Integer id) {
        Optional<City> cityOptional = cityRepository.findCityById(id);
        if (cityOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
