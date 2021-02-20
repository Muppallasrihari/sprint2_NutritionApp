package com.cg.healthify.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Exercise Identifier should not be blank")
	@Size(min=3, max=10, message = "Please use 3 to 10 charecters")
	@Column(updatable = false, unique = true)
	private String exIdentifier;
	
	@NotBlank(message = "Exercise Type should not be blank")
	private String exType;
	
	@NotNull
	@Range(min=1,max=10,message="set range should be within 1 to 10 ")
	private int exSets;
	
	@NotNull
	@Range(min=1,max=40,message="rep range should be within 1 to 40 ")
	private int exReps;
	
	@ElementCollection
	@CollectionTable(name="ExercisePlans")
	private Collection<String> exPlans = new ArrayList<>();
	
	
	public Collection<String> getExPlans() {
		return exPlans;
	}
	public void setExPlans(Collection<String> exPlans) {
		this.exPlans = exPlans;
	}
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime createdAt;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updatedAt;
	
	
	public String getExIdentifier() {
		return exIdentifier;
	}
	public void setExIdentifier(String exIdentifier) {
		this.exIdentifier = exIdentifier;
	}
	
	public int getExSets() {
		return exSets;
	}
	public void setExSets(int exSets) {
		this.exSets = exSets;
	}
	public int getExReps() {
		return exReps;
	}
	public void setExReps(int exReps) {
		this.exReps = exReps;
	}
	
	public String getExType() {
		return exType;
	}
	public void setExType(String exType) {
		this.exType = exType;
	}
	
	@PrePersist
	public void onCreate() {
		this.createdAt = LocalDateTime.now();  
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Exercise(int id,
			@NotBlank(message = "Exercise Identifier should not be blank") @Size(min = 3, max = 10, message = "Please use 3 to 10 charecters") String exIdentifier,
			@NotBlank String exType,
			@NotNull @Range(min = 1, max = 10, message = "set range should be within 1 to 10 ") int exSets,
			@NotNull @Range(min = 1, max = 40, message = "rep range should be within 1 to 40 ") int exReps,
			Collection<String> exPlans, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.exIdentifier = exIdentifier;
		this.exType = exType;
		this.exSets = exSets;
		this.exReps = exReps;
		this.exPlans = exPlans;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Exercise() {
		super();
	}
	@Override
	public String toString() {
		return "Exercise [id=" + id + ", exIdentifier=" + exIdentifier + ", exType=" + exType + ", exSets=" + exSets
				+ ", exReps=" + exReps + ", exPlans=" + exPlans + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
	
	
	
	

}
