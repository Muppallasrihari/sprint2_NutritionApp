package com.cg.healthify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthify.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerIdentifier(String customerIdentifier);
	Customer findByPaymentIdentifier(String paymentIdentifier);
}
