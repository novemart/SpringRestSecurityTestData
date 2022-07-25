package com.sky.SpringDataBoot.service;

import com.sky.SpringDataBoot.domain.dao.CarRepo;
import com.sky.SpringDataBoot.domain.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }
}
