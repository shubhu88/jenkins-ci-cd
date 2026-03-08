package com.irctc_backend.dto;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class TrainScheduleDto {

    private Long Id;

    private Long trainId;

    private LocalDate runDate;

    private  Integer availableSeats;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public LocalDate getRunDate() {
		return runDate;
	}

	public void setRunDate(LocalDate runDate) {
		this.runDate = runDate;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
    
    


}