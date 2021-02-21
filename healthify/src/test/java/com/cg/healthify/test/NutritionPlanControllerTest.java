package com.cg.healthify.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.cg.healthify.service.NutritionPlanServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NutritionPlanControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private NutritionPlanServiceImpl nutritionPlanServiceImpl;

	@LocalServerPort
	private int port;

}
