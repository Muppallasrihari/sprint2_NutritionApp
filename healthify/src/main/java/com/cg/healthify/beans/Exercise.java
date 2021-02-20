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
	private LocalDateTime created_At;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime updated_At;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public LocalDateTime getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}
	public LocalDateTime getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(LocalDateTime updated_At) {
		this.updated_At = updated_At;
	}
	
	@PrePersist
	public void onCreate() {
		this.created_At = LocalDateTime.now();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At = LocalDateTime.now();
	}

}
