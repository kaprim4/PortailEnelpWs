package com.winxo.PortailEnelpWs.repository;

import com.winxo.PortailEnelpWs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findCityById(Integer id);
}
