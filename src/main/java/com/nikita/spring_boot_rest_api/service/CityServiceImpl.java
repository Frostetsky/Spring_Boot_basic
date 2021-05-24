package com.nikita.spring_boot_rest_api.service;


import com.nikita.spring_boot_rest_api.dao.CityRepository;
import com.nikita.spring_boot_rest_api.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findByID(Integer id) {
        City city = null;
        Optional<City> result = cityRepository.findById(id);
        if (result.isPresent()) {
            city = result.get();
        }
        return city;
    }

    @Override
    public void saveOrUpdate(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteByID(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> findAllCityByCountry(String country) {
        return cityRepository.findAllByCountry(country);
    }
}
