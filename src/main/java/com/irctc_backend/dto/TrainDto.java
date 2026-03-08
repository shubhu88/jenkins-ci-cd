package com.irctc_backend.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class TrainDto {


    private Long id;
    @NotEmpty(message = "train number is required !!")


    @Size(min = 3, max = 20, message = "Invalid length of train no.")
    @Pattern(regexp = "^\\d+$", message = "Invalid no , train no contains only numbers.")
    @Id
    private String number;


    @Pattern(regexp = "^[A-Za-z][A-Za-z -]*[A-Za-z]$", message = "Invalid train name. letters, spaces and hyphens are allowed")
    private String name;

//
//    @Email(message = "Invalid email")
//    private  String email;


    private Integer totalDistance;

    private StationDto sourceStation;


    private StationDto destinationStation;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getTotalDistance() {
		return totalDistance;
	}


	public void setTotalDistance(Integer totalDistance) {
		this.totalDistance = totalDistance;
	}


	public StationDto getSourceStation() {
		return sourceStation;
	}


	public void setSourceStation(StationDto sourceStation) {
		this.sourceStation = sourceStation;
	}


	public StationDto getDestinationStation() {
		return destinationStation;
	}


	public void setDestinationStation(StationDto destinationStation) {
		this.destinationStation = destinationStation;
	}
    
    
    


}