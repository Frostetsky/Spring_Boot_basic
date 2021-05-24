package com.nikita.spring_boot_rest_api.service;


import com.nikita.spring_boot_rest_api.entity.City;

import java.util.List;

public interface CityService {
    public List<City> findAll();

    public City findByID(Integer id);

    public void saveOrUpdate(City city);

    public void deleteByID(Integer id);
}

