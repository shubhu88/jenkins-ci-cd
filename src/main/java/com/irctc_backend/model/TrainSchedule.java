package com.irctc_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "train_schedule")
public class TrainSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate runDate;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    private Integer availableSeats;


    // kitni seat ki type :

    @OneToMany(mappedBy = "trainSchedule")
    private List<TrainSeat> trainSeats;


    // booking
    @OneToMany(mappedBy = "trainSchedule")
    private  List<Booking> bookings;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getRunDate() {
		return runDate;
	}


	public void setRunDate(LocalDate runDate) {
		this.runDate = runDate;
	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
	}


	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	public List<TrainSeat> getTrainSeats() {
		return trainSeats;
	}


	public void setTrainSeats(List<TrainSeat> trainSeats) {
		this.trainSeats = trainSeats;
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}


	@Override
	public String toString() {
		return "TrainSchedule [id=" + id + ", runDate=" + runDate + ", train=" + train + ", availableSeats="
				+ availableSeats + ", trainSeats=" + trainSeats + ", bookings=" + bookings + "]";
	}
    
    

}