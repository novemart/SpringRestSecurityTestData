package com.sky.SpringDataBoot.controller;

import com.sky.SpringDataBoot.domain.dto.Car;
import com.sky.SpringDataBoot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public List<Car> showCars(){
        return carService.getAllCars();
    }
}
