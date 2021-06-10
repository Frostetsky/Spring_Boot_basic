package com.nikita.spring_boot_rest_api.dao;


import com.nikita.spring_boot_rest_api.entity.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CityRepositoryTest {

    @Autowired
    public CityRepository cityRepository;

    @Test
    @Rollback
    public void testRestApiFindAll() {
        cityRepository.save(new City("USA", "San-Diego", 1_200_000L));
        List<City> cityList = cityRepository.findAll();
        Assert.assertNotNull(cityList);
    }

    @Test
    @Rollback
    public void testRestApiSFindCityById() {
        City city = cityRepository.save(new City("Russia", "Moscow", 12_500_000L));
        City result = cityRepository.getById(city.getId());
        Assert.assertEquals(city.getName(), result.getName());
    }

    @Test
    @Rollback
    public void testRestApiDeleteCityById() {
        City city = cityRepository.save(new City("France", "Paris", 8_500_000L));
        cityRepository.save(new City("Russia", "Saratov", 800_000L));
        cityRepository.deleteById(city.getId());
        List<City> result = cityRepository.findAll();
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    @Rollback
    public void testRestApiFindAllByNameCriteria() {
        City city1 = new City("Russia", "Saratov", 800_000L);
        City city2 = new City("USA", "Washington", 6_400_000L);
        City city3 = new City("Russia", "Tambov", 450_000L);
        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
        List<City> result = cityRepository.findAllByCountry("Russia");
        Assert.assertEquals(result.size(), 2);
    }

    @Test
    @Rollback
    public void testRestApiFindCityWithMaxPopulation() {
        City city1 = new City("Russia", "Saratov", 800_000L);
        City city2 = new City("USA", "Washington", 6_400_000L);
        City city3 = new City("Russia", "Tambov", 450_000L);
        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
        City result = cityRepository.findFirstByOrderByPopulationDesc();
        Assert.assertEquals(result.getPopulation(), city2.getPopulation());
    }



}