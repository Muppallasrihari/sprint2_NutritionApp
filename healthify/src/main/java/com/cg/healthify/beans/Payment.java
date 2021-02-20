package com.cg.healthify.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String transactionId;
	private Double currentAmount;
	public Double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}

	private Double actualAmount;
	private String paymentIdentifier;
	@NotBlank(message = "Payment Gateway Reqiured")
	private String paymentGateway;
	private Double discount;

	/**
	 * ---------------------------ManytoOne Mapping with
	 * customer--------------------------------
	 **/
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "customer_id", updatable = false, nullable = false)
	@JsonIgnore
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getPaymentIdentifier() {
		return paymentIdentifier;
	}

	public void setPaymentIdentifier(String paymentIdentifier) {
		this.paymentIdentifier = paymentIdentifier;
	}

	public String getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment(Long id, String transactionId, Double actualAmount, String paymentIdentifier,
			@NotBlank(message = "Payment Gateway Reqiured") String paymentGateway, Double discount, Customer customer) {
		super();
		this.id = id;
		this.transactionId = transactionId;
		this.actualAmount = actualAmount;
		this.paymentIdentifier = paymentIdentifier;
		this.paymentGateway = paymentGateway;
		this.discount = discount;
		this.customer = customer;
	}

	public Payment() {
		super();
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", transactionId=" + transactionId + ", actualAmount=" + actualAmount
				+ ", paymentIdentifier=" + paymentIdentifier + ", paymentGateway=" + paymentGateway + ", discount="
				+ discount + ", customer=" + customer + "]";
	}

}
