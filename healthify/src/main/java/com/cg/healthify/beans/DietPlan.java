package com.cg.healthify.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class DietPlan {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotBlank(message="Food Type Reqiured")
@Column(unique=true,updatable=false)
private String foodType;
//@NotBlank(message="Fat Ratio Required")
//@Column(unique=true,updatable=false)
private Double fatRatio;
//@NotBlank(message="carbs Ratio Reqiured")
//@Column(unique=true,updatable=false)
private Double carbsRatio;
//@NotBlank(message="protien Ratio Reqiured")
//@Column(unique=true,updatable=false)
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
