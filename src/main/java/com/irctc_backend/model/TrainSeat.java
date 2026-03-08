package com.irctc_backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "train_seats")
//dibba
public class TrainSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "train_schedule_id")
    private TrainSchedule trainSchedule;

    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    private Integer totalSeats;

    //42-2=40=0
    private Integer availableSeats;

    private Double price;

    private Integer trainSeatOrder;

    //1+2=3.... >42
    private Integer seatNumberToAssign;

    public boolean isChochFull() {
        return availableSeats <= 0;
    }

    public boolean isSeatAvailable(int seatToBook) {
        return seatToBook <= availableSeats;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrainSchedule getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(TrainSchedule trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	public CoachType getCoachType() {
		return coachType;
	}

	public void setCoachType(CoachType coachType) {
		this.coachType = coachType;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTrainSeatOrder() {
		return trainSeatOrder;
	}

	public void setTrainSeatOrder(Integer trainSeatOrder) {
		this.trainSeatOrder = trainSeatOrder;
	}

	public Integer getSeatNumberToAssign() {
		return seatNumberToAssign;
	}

	public void setSeatNumberToAssign(Integer seatNumberToAssign) {
		this.seatNumberToAssign = seatNumberToAssign;
	}

	@Override
	public String toString() {
		return "TrainSeat [id=" + id + ", trainSchedule=" + trainSchedule + ", coachType=" + coachType + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", price=" + price + ", trainSeatOrder="
				+ trainSeatOrder + ", seatNumberToAssign=" + seatNumberToAssign + "]";
	}


}
