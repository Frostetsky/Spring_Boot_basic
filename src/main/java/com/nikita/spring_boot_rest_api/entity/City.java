package com.nikita.spring_boot_rest_api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private Long population;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sight> sights = new HashSet<>();

    public City() {
    }

    public City(Integer id, String country, String name, Long population) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.population = population;
    }

    public City(String country, String name, Long population) {
        this.country = country;
        this.name = name;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Set<Sight> getSights() {
        return sights;
    }

    public void setSights(Set<Sight> sights) {
        this.sights = sights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(id, city.id)
                && Objects.equals(country, city.country)
                && Objects.equals(name, city.name)
                && Objects.equals(population, city.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, name, population);
    }
}
