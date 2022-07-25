package com.sky.SpringDataBoot.domain.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Owner {
    @Id
    @GeneratedValue
    private int ownerid;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Car> cars;

    public void addCar(Car car){
        if(cars == null){
            cars = new ArrayList<>();
        }
        cars.add(car);
    }

}
