package com.cg.healthify.beans;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Pojo class= WeightLog
 * 
 * @author vinotraj
 *
 */

@Entity
public class WeightLog {

	public WeightLog() {
		super();
	}

	public WeightLog(Long id,
			@NotBlank(message = "weightId Required") @Size(min = 2, max = 4, message = "Must be between the size(min=2 ,max=4)") String weightId,
			@NotBlank(message = "weight Required") String weight, LocalDateTime created_At, LocalDateTime updated_At) {
		super();
		this.id = id;
		this.weightId = weightId;
		this.weight = weight;
		this.created_At = created_At;
		Updated_At = updated_At;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param WeightId It must not be empty size of the string between 2 to 4
	 *                 weightId must be unique.
	 */
	@NotBlank(message = "weightId Required")
	@Size(min = 2, max = 4, message = "Must be between the size(min=2 ,max=4)")
	@Column(unique = true, updatable = false)

	private String weightId;

	/**
	 * @param weight It must not be empty
	 * 
	 */
	@NotBlank(message = "weight Required")
	private String weight;

	/**
	 * @param created_At Date must be in json format
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime created_At;

	/**
	 * @param updated_At Date must be json format
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime Updated_At;

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getWeightId() {
		return weightId;
	}

	public void setWeightId(String weightId) {
		this.weightId = weightId;
	}

	public LocalDateTime getCreated_At() {
		return created_At;
	}

	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}

	public LocalDateTime getUpdated_At() {
		return Updated_At;
	}

	public void setUpdated_At(LocalDateTime updated_At) {
		Updated_At = updated_At;
	}

	@PrePersist
	public void onCreate() {
		this.created_At = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		this.Updated_At = LocalDateTime.now();
	}
}
