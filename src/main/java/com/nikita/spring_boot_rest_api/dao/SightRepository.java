package com.nikita.spring_boot_rest_api.dao;

import com.nikita.spring_boot_rest_api.entity.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightRepository extends JpaRepository<Sight, Integer> {
}
