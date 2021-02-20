package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.DietPlan;
import com.cg.healthify.beans.Exercise;
import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exceptions.CustomerException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.DietPlanRepository;
import com.cg.healthify.repository.ExerciseRepository;
import com.cg.healthify.repository.NutritionPlanRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
private CustomerRepository customerRepository;
@Autowired
private DietPlanRepository dietPlanRepository;
@Autowired
private NutritionPlanRepository nutritionPlanRepository;
@Autowired
private ExerciseRepository exerciseRepository;

/**-----------------------------Create Customer Data Along with Connected Entities----------**/
@Override
public Customer save(Customer customer) {
	try {
		customer.setCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase());		  
/**------------------------------------------DIET PLAN PART---------------------------------------------------------------**/			
	 DietPlan dietplan=dietPlanRepository.findByFoodType(customer.getFoodType().toUpperCase());
	 if(dietplan!=null) {
		 customer.setDietPlan(dietplan); 
	 }
/**-----------------------------------------------------------------------------------------------------------------------**/	 

/**-------------------------------------NUTRITION PLAN PART---------------------------------------------------------------**/	 
	 NutritionPlan plan=nutritionPlanRepository.findByPlanId(customer.getPlanId().toUpperCase());
	 if(plan!=null) {
		 customer.setNutritionPlan(plan);
	 }
/**-----------------------------------------------------------------------------------------------------------------------**/	 
		
/**-------------------------------------EXERCISE PART---------------------------------------------------------------------**/	 
	 Exercise exercise = exerciseRepository.findByExIdentifier(customer.getPlanId().toUpperCase());
		if(exercise!=null) {
			 customer.setExercise(exercise); 
		 }	 
	}
/**-----------------------------------------------------------------------------------------------------------------------**/	
	catch(Exception e) {
		throw new CustomerException("Contact: "+customer.getContact()+" already exists");
	}
	return customerRepository.save(customer);
	}
/**----------------------------------------------------------------------------------------**/

/**-------------------------------Find Customer By CustomerIdentifier---------------------------------------**/
@Override
public Customer findCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerException("Id: "+customerIdentifier+" doesn't exists");
	}
	return customer;
}

/**--------------------------------------------------------------------------------------------------------**/


/**---------------------------Get List of All Customer Details---------------------------------------------**/
@Override
public Iterable<Customer>getAllCustomerDetails(){
	return customerRepository.findAll();
}

/**--------------------------------------------------------------------------------------------------------**/


/**------------------------------Delete Customer By CustomerIdentifier-------------------------------------**/
@Override
public void deleteCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerException("Id: "+customerIdentifier+" doesn't exists");
	}
	customerRepository.delete(customer);
}
}
/**-------------------------------------------------------------------------------------------------------**/