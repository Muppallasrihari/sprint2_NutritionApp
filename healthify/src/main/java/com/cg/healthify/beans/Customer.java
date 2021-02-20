package com.cg.healthify.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Contact Required")
//@Size(max=10,min=10,message="Phone number must be 10 digits")
//@Column(unique=true)
	private String contact;
	@NotBlank(message = "Name Required")
	private String name;
	@NotBlank(message = "Gender Required")
	private String gender;
	@NotBlank(message = "Customer Identifier Reqiured")
	@Column(unique = true, updatable = false)
	private String customerIdentifier;
	@NotBlank(message = "Payment Identifier Required")
	@Column(unique = true, updatable = false)
	private String paymentIdentifier;
	@NotBlank(message = "Plan Id is Required")
	private String planId;
	@NotBlank(message = "Food Type Required")
	private String foodType;


	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	private Integer PTSequence = 0;

	/**
	 * ----------------------------------OneToOne mapping with
	 * DietPlan-------------------------
	 **/
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, targetEntity =DietPlan.class)
	private DietPlan dietPlan;
	
	/**
	 * ----------------------------------OneToOne mapping with
	 * NutritionPLan-------------------------
	 **/
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH, targetEntity = NutritionPlan.class)
	private NutritionPlan nutritionPlan;

	/**
	 * ----------------------------------OneToMany mapping with
	 * Payment-----------------------
	 **/
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Payment> payment = new ArrayList<>();
	
	/**
	 *  ----------------------------------OneTOne mapping with Exercise
	 *-----------------------
	 **/
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,targetEntity = Exercise.class)
	private Exercise exercise;

/**
 * ---------------------------OneToMany mapping with WeightLog
 * ----------------
 */
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL,targetEntity=WeightLog.class)
     private List<WeightLog> weightLog=new ArrayList<>();
	
	
	public List<WeightLog> getWeightLog() {
	return weightLog;
}
	/**
	 *  ----------------------------------OneTOne mapping with CaloriesLog
	 *-----------------------
	 **/
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,targetEntity = CaloriesLog.class)
	private CaloriesLog calorieslog;


public void setWeightLog(List<WeightLog> weightLog) {
	this.weightLog = weightLog;
}

	@Column(updatable = false)
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	@PrePersist
	public void onCreate() {
		this.createdDate = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedDate = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getPaymentIdentifier() {
		return paymentIdentifier;
	}

	public void setPaymentIdentifier(String paymentIdentifier) {
		this.paymentIdentifier = paymentIdentifier;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Integer getPTSequence() {
		return PTSequence;
	}

	public void setPTSequence(Integer pTSequence) {
		PTSequence = pTSequence;
	}

	public DietPlan getDietPlan() {
		return dietPlan;
	}

	public void setDietPlan(DietPlan dietPlan) {
		this.dietPlan = dietPlan;
	}

	public NutritionPlan getNutritionPlan() {
		return nutritionPlan;
	}

	public void setNutritionPlan(NutritionPlan nutritionPlan) {
		this.nutritionPlan = nutritionPlan;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	public CaloriesLog getCalorieslog() {
		return calorieslog;
	}

	public void setCalorieslog(CaloriesLog calorieslog) {
		this.calorieslog = calorieslog;
	}

	
	public Customer(Long id, @NotBlank(message = "Contact Required") String contact,
			@NotBlank(message = "Name Required") String name, @NotBlank(message = "Gender Required") String gender,
			@NotBlank(message = "Customer Identifier Reqiured") String customerIdentifier,
			@NotBlank(message = "Payment Identifier Required") String paymentIdentifier,
			@NotBlank(message = "Plan Id is Required") String planId,
			@NotBlank(message = "Food Allergy Required") String foodType, Integer pTSequence, DietPlan dietPlan,
			NutritionPlan nutritionPlan, List<Payment> payment, Exercise exercise, List<WeightLog> weightLog,
			CaloriesLog calorieslog, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.contact = contact;
		this.name = name;
		this.gender = gender;
		this.customerIdentifier = customerIdentifier;
		this.paymentIdentifier = paymentIdentifier;
		this.planId = planId;
		this.foodType = foodType;
		PTSequence = pTSequence;
		this.dietPlan = dietPlan;
		this.nutritionPlan = nutritionPlan;
		this.payment = payment;
		this.exercise = exercise;
		this.weightLog = weightLog;
		this.calorieslog = calorieslog;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", contact=" + contact + ", name=" + name + ", gender=" + gender
				+ ", customerIdentifier=" + customerIdentifier + ", paymentIdentifier=" + paymentIdentifier
				+ ", planId=" + planId + ", PTSequence=" + PTSequence + ", dietPlan=" + dietPlan + ", nutritionPlan="
				+ nutritionPlan + ", payment=" + payment + ", exercise=" + exercise + ", weightLog=" + weightLog
				+ ", calorieslog=" + calorieslog + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
	public Customer() {
		super();
		
	}
}