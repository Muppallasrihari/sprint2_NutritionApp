package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.DietPlan;
import com.cg.healthify.exceptions.DietPlanException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.DietPlanRepository;

@Service
public class DietPlanServiceImpl implements DietPlanService{
	@Autowired
	private DietPlanRepository dietPlanRepository;
	@Autowired
	private CustomerRepository customerRepository;
	/**
	 * This method saveDietPlan() is for saving DietPlan
	 */
	@Override
	public DietPlan saveDietPlan(DietPlan dietPlan) {
		try {
			dietPlan.setFoodType(dietPlan.getFoodType().toUpperCase());
			return dietPlanRepository.save(dietPlan);	
		}catch(Exception e) {
			throw new DietPlanException("This Diet-Plan: "+dietPlan.getFoodType()+" already exists");
		}
	}
/**--------------------------------------------------------------------------------------------**/
	/**
	 * This method getDietPlanByFoodType() is for getting a DietPlan by foodType
	 */
	@Override	
	public DietPlan getDietPlanByFoodType(String foodType) {
		DietPlan diet= dietPlanRepository.findByFoodType(foodType);
		if(diet==null) {
			throw new DietPlanException("Id: "+foodType.toUpperCase()+" not exists");
		}
		return diet;
	}

/**---------------------------------------------------------------------------------------**/

	/**
	 * This method getAllDietDetails() is for getting all the DietPlans
	 */
	@Override
	public Iterable<DietPlan>getAllDietDetails(){
		return dietPlanRepository.findAll();
	}
/**---------------------------------------------------------------------------------------**/
	/**
	 * This method deleteByFoodType() is for deleting a DietPlan 
	 */
 	@Override
	public void deleteByFoodType(String foodType) {
		DietPlan diet = dietPlanRepository.findByFoodType(foodType);
		if (diet == null) {
			throw new DietPlanException("Diet Plan with foodtype---" + foodType.toUpperCase() + " ---does not exists.");
		}
		dietPlanRepository.delete(diet);
	}

}
