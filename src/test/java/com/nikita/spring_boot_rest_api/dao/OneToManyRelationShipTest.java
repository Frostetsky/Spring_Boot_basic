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
        City city1 = new City("Россия", "Москва", 12_000_000L);
        Sight sight1 = new Sight("Красная площадь");
        Sight sight2 = new Sight("ЦДМ");
        city1.getSights().add(sight1);
        city1.getSights().add(sight2);
        city1 = cityRepository.save(city1);
        City result = cityRepository.getById(city1.getId());
        Assert.assertEquals(result.getSights().size(), 2);
    }

    @Test
    @Rollback
    public void testRestApiFindAllSight() {
        City city1 = new City("Россия", "Москва", 880_000L);
        Sight sight1 = new Sight("Набережная Космонавтов");
        city1.getSights().add(sight1);
        City city2 = new City("США", "Нью-Йорк", 12_530_000L);
        Sight sight2 = new Sight("Статуя свободы");
        Sight sight3 = new Sight("Центральный парк");
        city2.getSights().add(sight2);
        city2.getSights().add(sight3);

        cityRepository.save(city1);
        cityRepository.save(city2);

        boolean sizeSightIs3 = sightRepository.findAll().size() == 3;
        Assert.assertTrue(sizeSightIs3);
    }

    @Test
    @Rollback
    public void testRestApiWhenDeleteCityMustDeleteAllSightThisCity() {
        City city1 = new City("Россия", "Москва", 880_000L);
        Sight sight1 = new Sight("Набережная Космонавтов");
        city1.getSights().add(sight1);
        City city2 = new City("США", "Нью-Йорк", 12_530_000L);
        Sight sight2 = new Sight("Статуя свободы");
        Sight sight3 = new Sight("Центральный парк");
        city2.getSights().add(sight2);
        city2.getSights().add(sight3);

        city1 = cityRepository.save(city1);
        city2 = cityRepository.save(city2);

        cityRepository.deleteById(city1.getId());

        boolean sizeCityIs1 = cityRepository.findAll().size() == 1;
        boolean sizeSightIs2 = sightRepository.findAll().size() == 2;
        Assert.assertTrue(sizeSightIs2);
        Assert.assertTrue(sizeCityIs1);
    }
}
