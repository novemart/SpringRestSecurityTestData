package com.sky.SpringDataBoot;

import com.sky.SpringDataBoot.controller.CarController;
import com.sky.SpringDataBoot.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataBootApplicationTests {

	@Autowired
	private CarController carController;

	@Autowired
	private OwnerService ownerService;

	@Test
	void contextLoads() {
		assertThat(carController).isNotNull();
		assertThat(ownerService).isNotNull();
	}

}
