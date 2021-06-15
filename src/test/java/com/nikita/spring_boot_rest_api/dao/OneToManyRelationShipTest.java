package com.nikita.spring_boot_rest_api.dao;


import com.nikita.spring_boot_rest_api.entity.City;
import com.nikita.spring_boot_rest_api.entity.Sight;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OneToManyRelationShipTest {

    @Autowired
    public CityRepository cityRepository;

    @Autowired
    public SightRepository sightRepository;

    @Test
    @Rollback
    public void testRestApiFindAllSightInCityMoscow() {
        City city1 = new City("Russia", "Moscow", 12_000_000L);
        Sight sight1 = new Sight("Красная площадь");
        Sight sight2 = new Sight("ЦДМ");
        city1.getSights().add(sight1);
        city1.getSights().add(sight2);
        city1 = cityRepository.save(city1);
        City result = cityRepository.getById(city1.getId());
        Assert.assertEquals(result.getSights().size(), 2);
    }
}
