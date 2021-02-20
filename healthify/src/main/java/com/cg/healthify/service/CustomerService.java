package com.cg.healthify.service;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;

@Service
public interface CustomerService {
	public Customer save(Customer customer);
	
	public Customer findCustomerById(String customerIdentifier);
	
	public Iterable<Customer>getAllCustomerDetails();
	
	public void deleteCustomerById(String customerIdentifier);

}