package com.nikita.spring_boot_rest_api.service;

import com.nikita.spring_boot_rest_api.dao.CityDAO;
import com.nikita.spring_boot_rest_api.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityDAO cityDAO;

    @Override
    @Transactional
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    @Transactional
    public City findByID(Integer id) {
        return cityDAO.findByID(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(City city) {
        cityDAO.saveOrUpdate(city);
    }

    @Override
    @Transactional
    public void deleteByID(Integer id) {
        cityDAO.deleteByID(id);
    }
}
