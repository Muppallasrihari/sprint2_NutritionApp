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

/**-----------------------------------Update Existing Diet Plan-------------------------**/	
	@Override
	public DietPlan saveDietPlan(DietPlan dietPlan) {
		try {
		//nutritionPlan.setPlanId(nutritionPlan.getPlanId().toUpperCase());/
		dietPlan.setFoodType(dietPlan.getFoodType().toUpperCase());
			return dietPlanRepository.save(dietPlan);	
		}
		catch(Exception e) {
			throw new DietPlanException("This Diet-Plan: "+dietPlan.getId()+" already exists");
		}
	}
/**--------------------------------------------------------------------------------------------**/

/**---------------------------------Find Diet Plan By FoodType---------------------------------------**/
	@Override	
	public DietPlan getDietPlanByFoodType(String foodType) {
		DietPlan diet= dietPlanRepository.findByFoodType(foodType);
		if(diet==null) {
			throw new DietPlanException("Id: "+foodType.toUpperCase()+" not exists");
		}
		return diet;
	}

/**---------------------------------------------------------------------------------------**/

/**------------------------------Get List of All Diet Plan--------------------------------**/
	@Override
	public Iterable<DietPlan>getAllDietDetails(){
		return dietPlanRepository.findAll();
	}
/**----------------------------------------------------------------------------------------**/
	
/**-----------------------Delete By FoodType------------------------------------------------**/
	
public int deleteByFoodType(String foodType) {
	int res=0;
	DietPlan diet= dietPlanRepository.findByFoodType(foodType);
	if(diet==null) {
		throw new DietPlanException("Id: "+foodType.toUpperCase()+"not exists");
	}else {
		 dietPlanRepository.delete(diet);
		res=1;
	}   
	       return res;
}

}
