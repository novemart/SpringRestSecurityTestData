package com.sky.SpringDataBoot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.SpringDataBoot.domain.dto.Car;
import com.sky.SpringDataBoot.domain.dto.Owner;
import com.sky.SpringDataBoot.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class OwnerControllerTest {

    @MockBean
    private OwnerService ownerService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createNewOwner() throws Exception {
        Car car = new Car();
        car.setBrand("BMW");
        Owner o = new Owner();
        o.addCar(car);

        doReturn(new Owner()).when(ownerService).insertOwnerAndCars(any());

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/owners")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(o))
                .contentType(MediaType.APPLICATION_JSON);

       MvcResult result =  mockMvc.perform(requestBuilder).andReturn();

       assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
