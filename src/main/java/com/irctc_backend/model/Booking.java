package com.irctc_backend.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;

    private  String pnr;

    @ManyToOne
    @JoinColumn(name = "train_schedule_id")
    private  TrainSchedule trainSchedule;

    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private  Station sourceStation;

    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private  Station destinationStation;

    private LocalDate journeyDate;

    private BigDecimal totalFare;

    @Enumerated(EnumType.STRING)
    private  BookingStatus bookingStatus;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<BookingPassenger> passengers;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private  Payment payment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public TrainSchedule getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(TrainSchedule trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	public Station getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(Station sourceStation) {
		this.sourceStation = sourceStation;
	}

	public Station getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Station destinationStation) {
		this.destinationStation = destinationStation;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public BigDecimal getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(BigDecimal totalFare) {
		this.totalFare = totalFare;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<BookingPassenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<BookingPassenger> passengers) {
		this.passengers = passengers;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", pnr=" + pnr + ", trainSchedule=" + trainSchedule
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", journeyDate="
				+ journeyDate + ", totalFare=" + totalFare + ", bookingStatus=" + bookingStatus + ", createdAt="
				+ createdAt + ", passengers=" + passengers + ", payment=" + payment + "]";
	}

    
    

}