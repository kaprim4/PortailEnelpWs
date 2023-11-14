package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.CityRepository;
import com.winxo.PortailEnelpWs.service.CityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService
{

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    public City findCityById(Integer id) {
        return cityRepository
                .findCityById(id)
                .orElseThrow(() -> new NotFoundException("City by id " + id + " was not found"));
    }

    public void deleteCity(Integer id) {
        cityRepository.deleteById(id);
    }
}
