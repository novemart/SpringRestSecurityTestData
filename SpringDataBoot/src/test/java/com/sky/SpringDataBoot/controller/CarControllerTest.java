package com.sky.SpringDataBoot.controller;

import com.sky.SpringDataBoot.domain.dto.Car;
import com.sky.SpringDataBoot.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {

    @MockBean
    private CarService carService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllCars() throws Exception{
        ArrayList<Car> list = new ArrayList<>();
        Car car1 = new Car();
        car1.setBrand("BMW");
        Car car2 = new Car();
        car2.setBrand("Volvo");
        Car car3 = new Car();
        car3.setBrand("VW");
        list.add(car1);
        list.add(car2);
        list.add(car3);

        doReturn(list).when(carService).getAllCars();

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].brand").value("BMW"))
                .andExpect(jsonPath("$[1].brand").value("Volvo"))
                .andExpect(jsonPath("$[2].brand").value("VW"));
    }
}
