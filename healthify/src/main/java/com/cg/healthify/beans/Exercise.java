package com.cg.healthify.beans;

import java.time.LocalDate;

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
	private LocalDate createdAt;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updatedAt;
	
	
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
		this.createdAt = LocalDate.now();  
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = LocalDate.now();
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
	public Exercise(int id,
			@NotBlank(message = "Exercise Identifier should not be blank") @Size(min = 3, max = 10, message = "Please use 3 to 10 charecters") String exIdentifier,
			@NotBlank String exType,
			@NotNull @Range(min = 1, max = 10, message = "set range should be within 1 to 10 ") int exSets,
			@NotNull @Range(min = 1, max = 40, message = "rep range should be within 1 to 40 ") int exReps,
			Collection<String> exPlans, LocalDate createdAt, LocalDate updatedAt) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((exIdentifier == null) ? 0 : exIdentifier.hashCode());
		result = prime * result + ((exPlans == null) ? 0 : exPlans.hashCode());
		result = prime * result + exReps;
		result = prime * result + exSets;
		result = prime * result + ((exType == null) ? 0 : exType.hashCode());
		result = prime * result + id;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Exercise other = (Exercise) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (exIdentifier == null) {
			if (other.exIdentifier != null)
				return false;
		} else if (!exIdentifier.equals(other.exIdentifier))
			return false;
		if (exPlans == null) {
			if (other.exPlans != null)
				return false;
		} else if (!exPlans.equals(other.exPlans))
			return false;
		if (exReps != other.exReps)
			return false;
		if (exSets != other.exSets)
			return false;
		if (exType == null) {
			if (other.exType != null)
				return false;
		} else if (!exType.equals(other.exType))
			return false;
		if (id != other.id)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_At == null) ? 0 : created_At.hashCode());
		result = prime * result + ((exIdentifier == null) ? 0 : exIdentifier.hashCode());
		result = prime * result + ((exPlans == null) ? 0 : exPlans.hashCode());
		result = prime * result + exReps;
		result = prime * result + exSets;
		result = prime * result + id;
		result = prime * result + ((updated_At == null) ? 0 : updated_At.hashCode());
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
		Exercise other = (Exercise) obj;
		if (created_At == null) {
			if (other.created_At != null)
				return false;
		} else if (!created_At.equals(other.created_At))
			return false;
		if (exIdentifier == null) {
			if (other.exIdentifier != null)
				return false;
		} else if (!exIdentifier.equals(other.exIdentifier))
			return false;
		if (exPlans == null) {
			if (other.exPlans != null)
				return false;
		} else if (!exPlans.equals(other.exPlans))
			return false;
		if (exReps != other.exReps)
			return false;
		if (exSets != other.exSets)
			return false;
		if (id != other.id)
			return false;
		if (updated_At == null) {
			if (other.updated_At != null)
				return false;
		} else if (!updated_At.equals(other.updated_At))
			return false;
		return true;
	}

}
