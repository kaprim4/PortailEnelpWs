package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.City;

import java.util.List;

public interface CityService {

    List<City> findAllCities();

    City findCityById(Integer id);

    City addCity(City role);

    City updateCity(City role);

    void deleteCity(Integer id);
}
