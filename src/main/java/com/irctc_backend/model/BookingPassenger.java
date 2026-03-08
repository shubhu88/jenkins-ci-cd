package com.irctc_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_passengers")
public class BookingPassenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private String name;

    private Integer age;

    private String gender;

    @ManyToOne
    private  TrainSeat trainSeat;
    private String seatNumber;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public TrainSeat getTrainSeat() {
		return trainSeat;
	}
	public void setTrainSeat(TrainSeat trainSeat) {
		this.trainSeat = trainSeat;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	@Override
	public String toString() {
		return "BookingPassenger [id=" + id + ", booking=" + booking + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", trainSeat=" + trainSeat + ", seatNumber=" + seatNumber + "]";
	}
    
    

}