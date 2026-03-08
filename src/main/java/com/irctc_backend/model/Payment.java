package com.irctc_backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private  Booking booking;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private  PaymentStatus paymentStatus;

    private  String paymentMethod;

    private  String tansactionId;
    private LocalDateTime createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTansactionId() {
		return tansactionId;
	}
	public void setTansactionId(String tansactionId) {
		this.tansactionId = tansactionId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", booking=" + booking + ", amount=" + amount + ", paymentStatus=" + paymentStatus
				+ ", paymentMethod=" + paymentMethod + ", tansactionId=" + tansactionId + ", createdAt=" + createdAt
				+ "]";
	}
    
    
	
}