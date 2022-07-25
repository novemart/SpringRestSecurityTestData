package com.sky.SpringDataBoot.domain.dao;

import com.sky.SpringDataBoot.domain.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
}
