package com.nikita.spring_boot_rest_api.dao;

import com.nikita.spring_boot_rest_api.entity.City;
import org.hibernate.Session;
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
        Session session = entityManager.unwrap(Session.class);
        List<City> result = session.createQuery("from City", City.class).getResultList();
        return result;
    }

    @Override
    public City findByID(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public void saveOrUpdate(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void deleteByID(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        City deleted = session.get(City.class, id);
        session.delete(deleted);
    }
}
