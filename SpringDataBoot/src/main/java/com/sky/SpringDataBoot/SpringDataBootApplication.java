package com.sky.SpringDataBoot;

import com.sky.SpringDataBoot.domain.dao.OwnerRepository;
import com.sky.SpringDataBoot.domain.dto.Car;
import com.sky.SpringDataBoot.domain.dto.Owner;
import com.sky.SpringDataBoot.service.CarService;
import com.sky.SpringDataBoot.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class SpringDataBootApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringDataBootApplication.class, args);
	}

}
