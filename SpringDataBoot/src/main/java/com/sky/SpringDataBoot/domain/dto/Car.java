package com.sky.SpringDataBoot.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    private int id;

    private String brand;

    private String model;

    private String colour;

    @NotNull
    private int price;

    private String registration_number;

    private int year;

    @ManyToOne(fetch = FetchType.EAGER,  cascade = CascadeType.PERSIST)
    @JoinColumn(name="owner")
    @JsonIgnore
    @ToString.Exclude
    private Owner owner;

}
