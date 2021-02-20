package com.cg.healthify.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class DietPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Food Type Reqiured")
	@Column(unique = true, updatable = false)
	private String foodType;
	private Double fatRatio;
	private Double carbsRatio;
	private Double proteinRatio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Double getFatRatio() {
		return fatRatio;
	}

	public void setFatRatio(Double fatRatio) {
		this.fatRatio = fatRatio;
	}

	public Double getCarbsRatio() {
		return carbsRatio;
	}

	public void setCarbsRatio(Double carbsRatio) {
		this.carbsRatio = carbsRatio;
	}

	public Double getProteinRatio() {
		return proteinRatio;
	}

	public void setProteinRatio(Double proteinRatio) {
		this.proteinRatio = proteinRatio;
	}

}
