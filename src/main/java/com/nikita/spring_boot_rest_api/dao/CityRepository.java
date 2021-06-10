package com.nikita.spring_boot_rest_api.dao;

import com.nikita.spring_boot_rest_api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    public List<City> findAllByCountry(String country);

    public City findFirstByOrderByPopulationDesc();
}
