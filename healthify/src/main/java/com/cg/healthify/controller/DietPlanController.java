package com.cg.healthify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cg.healthify.beans.DietPlan;
import com.cg.healthify.repository.DietPlanRepository;
import com.cg.healthify.service.DietPlanServiceImpl;
import com.cg.healthify.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/dietPlan")
@CrossOrigin
public class DietPlanController {
	@Autowired	
	private DietPlanServiceImpl dietPlanService;
	@Autowired
	private MapValidationErrorService validationService;
	@Autowired
	private DietPlanRepository dietPlanRepository;
	
/**-----------------------------Update Existing DietPlan Data--------------------------------------------**/	
	/**
	 * This method createNewDietPlan() is for creating new DietPlan
	 */	
	@PostMapping("/diet")
	public ResponseEntity<?> createNewDietPlan(@Valid @RequestBody DietPlan diet,BindingResult result) {
		ResponseEntity<?> errorMsg=	validationService.mapValidationError(result);
		if(errorMsg!=null)
			return errorMsg;
		DietPlan die=dietPlanService.saveDietPlan(diet);
		return new ResponseEntity<DietPlan>(die,HttpStatus.OK);
	}
/**-------------------------------------------------------------------------------------------------------**/
	
	
	/**
	 * This method getDietPlanByFoodType() is for getting a DietPlan by foodType
	 */
	@GetMapping("/{foodType}")
	public ResponseEntity<DietPlan> getDietPlanByFoodType(@PathVariable String foodType){
		DietPlan diet=dietPlanService.getDietPlanByFoodType(foodType);
		return new ResponseEntity<DietPlan>(diet,HttpStatus.OK);
	}
	
/**-------------------------------------------------------------------------------------------------------**/	
	/**
	 * This method getAllDietDetails() is for getting all the DietPlans
	 */	
	@GetMapping("/all")
	public Iterable<DietPlan> getAllDietDetails(){
		return dietPlanService.getAllDietDetails();
	}
/**--------------------------------------------------------------------------------------------------------**/	

	/**
	 * This method deleteByFoodType() is for deleting a DietPlan 
	 */
    	@DeleteMapping("/{foodType}")
	public ResponseEntity<?> deleteByFoodType(@PathVariable String foodType) {
		dietPlanService.deleteByFoodType(foodType);
		return new ResponseEntity<String>("DietPlan with FoodType "+foodType.toUpperCase()+" deleted successfully", HttpStatus.OK);
	}
	

}
