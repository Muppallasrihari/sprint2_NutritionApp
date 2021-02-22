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
public DietPlan(Long id, @NotBlank(message = "Food Type Reqiured") String foodType, Double fatRatio, Double carbsRatio,
		Double proteinRatio) {
	super();
	this.id = id;
	this.foodType = foodType;
	this.fatRatio = fatRatio;
	this.carbsRatio = carbsRatio;
	this.proteinRatio = proteinRatio;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((carbsRatio == null) ? 0 : carbsRatio.hashCode());
	result = prime * result + ((fatRatio == null) ? 0 : fatRatio.hashCode());
	result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((proteinRatio == null) ? 0 : proteinRatio.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DietPlan other = (DietPlan) obj;
	if (carbsRatio == null) {
		if (other.carbsRatio != null)
			return false;
	} else if (!carbsRatio.equals(other.carbsRatio))
		return false;
	if (fatRatio == null) {
		if (other.fatRatio != null)
			return false;
	} else if (!fatRatio.equals(other.fatRatio))
		return false;
	if (foodType == null) {
		if (other.foodType != null)
			return false;
	} else if (!foodType.equals(other.foodType))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (proteinRatio == null) {
		if (other.proteinRatio != null)
			return false;
	} else if (!proteinRatio.equals(other.proteinRatio))
		return false;
	return true;
}
public DietPlan() {
	super();
	// TODO Auto-generated constructor stub
}

}
