package com.nikita.spring_boot_rest_api.dao;

import com.nikita.spring_boot_rest_api.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<City> findAll() {
        List<City> result = entityManager.createQuery("from City", City.class).getResultList();
        return result;
    }

    @Override
    public City findByID(Integer id) {
        City city = entityManager.find(City.class, id);
        return city;
    }

    @Override
    public void saveOrUpdate(City city) {
        City newCity = entityManager.merge(city);
        city.setId(newCity.getId());
    }

    @Override
    public void deleteByID(Integer id) {
        City deleted = entityManager.find(City.class, id);
        entityManager.remove(deleted);
    }
}
