package com.cg.healthify.beans;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NutritionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nutrition Plan Id is required.")
	@Column(unique = true, updatable = false)
	private String planId;
	@NotBlank(message = "Nutrition Plan Name is required.")
	private String name;
	@NotBlank(message = "Nutrition Plan Description is required.")
	private String description;
	@JsonFormat
	private LocalDate createdAt;
	@JsonFormat
	private LocalDate updatedAt;
	@NotNull(message = "Nutrition Plan Price is required.")
	@Min(value = 0)
	private double price;

	public NutritionPlan() {
		super();
	}
	

	public NutritionPlan(Long id, @NotBlank(message = "Nutrition Plan Id is required.") String planId,
			@NotBlank(message = "Nutrition Plan Name is required.") String name,
			@NotBlank(message = "Nutrition Plan Description is required.") String description, LocalDate createdAt,
			LocalDate updatedAt, @NotNull(message = "Nutrition Plan Price is required.") @Min(0) double price) {
		super();
		this.id = id;
		this.planId = planId;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.price = price;
	}


	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDate.now();

	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDate.now();
	}


	@Override
	public String toString() {
		return "NutritionPlan [id=" + id + ", planId=" + planId + ", name=" + name + ", description=" + description
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", price=" + price + "]";
	}
	
	

}
