package com.sky.SpringDataBoot.service;

import com.sky.SpringDataBoot.domain.dao.CarRepo;
import com.sky.SpringDataBoot.domain.dto.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CarServiceTest {

    @MockBean
    private CarRepo carRepo;

    @Autowired
    private CarService carService;

    @Test
    @DisplayName("Test get all cars success")
    public void getAllCarsTest(){
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        car1.setBrand("BMW");
        cars.add(car1);
        Car car2 = new Car();
        car2.setBrand("Volvo");
        cars.add(car2);
        Car car3 = new Car();
        car3.setBrand("VW");
        cars.add(car3);

        doReturn(cars).when(carRepo).findAll();

        List<Car> returnedCars = carService.getAllCars();
        assertEquals(3, returnedCars.size());

        verify(carRepo, times(1)).findAll();
    }
}
