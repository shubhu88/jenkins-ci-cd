package com.irctc_backend.dto;

import java.time.LocalDateTime;

public class TrainRouteDto {
	
	private Long id;
	
	private StationDto station;

	private TrainDto train;
	
	private Integer stationOrder;
	
	private LocalDateTime arrivalTime;
	
	private LocalDateTime departureTime;
	
	private Integer haultMinutes;
	
	private Integer distanceFromSource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StationDto getStation() {
		return station;
	}

	public void setStation(StationDto station) {
		this.station = station;
	}

	public TrainDto getTrain() {
		return train;
	}

	public void setTrain(TrainDto train) {
		this.train = train;
	}

	public Integer getStationOrder() {
		return stationOrder;
	}

	public void setStationOrder(Integer stationOrder) {
		this.stationOrder = stationOrder;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getHaultMinutes() {
		return haultMinutes;
	}

	public void setHaultMinutes(Integer haultMinutes) {
		this.haultMinutes = haultMinutes;
	}

	public Integer getDistanceFromSource() {
		return distanceFromSource;
	}

	public void setDistanceFromSource(Integer distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
	
	

}
