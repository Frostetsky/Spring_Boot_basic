package com.nikita.spring_boot_rest_api.controller;

import com.nikita.spring_boot_rest_api.entity.City;
import com.nikita.spring_boot_rest_api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> findAllCities() {
        return cityService.findAll();
    }

    @GetMapping("/cities/{id}")
    public City findCityByID(@PathVariable Integer id) {
        return cityService.findByID(id);
    }

    @PostMapping("/cities")
    public City addCity(@RequestBody City city) {
        cityService.saveOrUpdate(city);
        return city;
    }

    @PutMapping("/cities")
    public City updateCity(@RequestBody City city) {
        cityService.saveOrUpdate(city);
        return city;
    }

    @DeleteMapping("/cities/{id}")
    public String deleteCityByID(@PathVariable Integer id) {
        cityService.deleteByID(id);
        return "Employee with id " + id + " was deleted.";
    }

    @GetMapping("/cities/country/{country}")
    public List<City> findAllCitiesByCountry(@PathVariable String country) {
        return cityService.findAllCityByCountry(country);
    }
}
