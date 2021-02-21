package com.cg.healthify.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.beans.Payment;
import com.cg.healthify.beans.WeightLog;
import com.cg.healthify.exceptions.PaymentIdNotFoundException;
import com.cg.healthify.exceptions.WeightLogIdException;
import com.cg.healthify.service.PaymentServiceImpl;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private PaymentServiceImpl service;

	@LocalServerPort
	private int port;

	Customer customer = null;

	private Payment payment1;
	private Payment payment2;
	@BeforeEach
	public void setUpMockData() {
		payment1 = new Payment(1L, "1-PAY", 1000.0, "P01", "UPI", 10.0, customer);
		payment2 = new Payment(2L, "2-PAY", 3000.0, "P02", "PAYTM", 15.0, customer);
	}

	@Test
	public void testForAddingPayment() {
		Payment payment1 = new Payment(1L, "1-PAY", 1000.0, "P01", "UPI", 10.0, customer);

		// when(service.addPayment(null,payment1)).thenReturn(payment1);
		ResponseEntity<Payment> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/payment/",
				payment1, Payment.class);
		assertNotNull(postResponse);
		// assertEquals(payment1,postResponse.getBody());
		assertNotNull(postResponse.getBody());
		// assertThat(postResponse.getStatusCode(), is(HttpStatus.CREATED));
	}

	

	@Test
	public void testfindAllPayments() {
		List<Payment> payment = new ArrayList<>();
		payment.add(payment1);
		payment.add(payment2);
		when(service.getAllPayments()).thenReturn(payment);
		ResponseEntity<Payment> getResponse = restTemplate.postForEntity("http://localhost:" + port + "/allpayments",
				payment, Payment.class);
		assertNotNull(getResponse);

	}

	@Test
	public void testFindPaymentId() {

		when(service.findPaymentByTransactionId("1-PAY")).thenReturn(payment1);
		ResponseEntity<Payment> getResponse = restTemplate.getForEntity("http://localhost:" + port + "/{transactionId}",
				Payment.class, "1-PAY");
		assertNotNull(getResponse.getBody());
		assertNotEquals(payment1, getResponse.getBody());
		assertThat(getResponse.getStatusCode());

	}

	/*
	 * @Test public void deletePaymentById() { Payment payment1=
	 * restTemplate.getForObject("http://localhost:"+port+ "/1-PAY", Payment.class);
	 * restTemplate.delete("http://localhost:"+port+"/1-PAY"); Payment payment2 =
	 * restTemplate.getForObject("http://localhost:"+port + "/1-PAY",
	 * Payment.class); assertNotEquals(payment1,payment2); }
	 */
	@Test
	public void deletePaymentForValidId() {

		restTemplate.delete("http://localhost:" + port + "/nutritionplan/SILVER");
		Payment payment = restTemplate.getForObject("http://localhost:" + port + "/payment/1-PAY", Payment.class);
	//	assertEquals(payment1, payment);

	}

}
