package com.cg.healthify.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


import java.util.Collection;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthify.beans.Exercise;
import com.cg.healthify.exceptions.ExerciseIdException;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExerciseControllerTest {
	
	Exercise exercise = new Exercise();

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	private LocalDate date = LocalDate.now();
	
	private LocalDate date1 = LocalDate.of(2020, 02, 1);
	 
	
	private Collection<String> exPlans = null;
	
	@Test
	public void addExerciseTest() {
		Exercise exercise = new Exercise(1, "CARDIO1", "Cardio", 3, 12, exPlans, date, date1);
		ResponseEntity<Exercise> postResponse = restTemplate.postForEntity(getRootUrl() + "/healthify/exercise", exercise,
				Exercise.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test 
	public void updateExerciseTest() {
		Exercise exercise = new Exercise(1, "CARDIO1", "Cardio", 3, 12, exPlans, date, date1);
		restTemplate.put(getRootUrl() + "/healthify/exercise/1", exercise);
		Exercise exercise2 = restTemplate.getForObject(getRootUrl() + "/exercise/1", Exercise.class);
		assertNotNull(exercise2);
	}
	
	@Test
	public void deleteExerciseByExIdentifier() {
		Exercise exercise1 = new Exercise(1, "CARDIO1", "Cardio", 3, 12, exPlans, date, date1);
		exercise1 = restTemplate.getForObject(getRootUrl() + "healthify/exercise/CARDIO1", Exercise.class);
		restTemplate.delete(getRootUrl() + "healthify/exercise/CARDIO1");
		Exercise exercise2 = restTemplate.getForObject(getRootUrl() + "healthify/exercise/CARDIO1", Exercise.class);
		String expected = "CARDIO1 does not exist";
		assertNotEquals(exercise2, expected);
	}
	
	
	
}


