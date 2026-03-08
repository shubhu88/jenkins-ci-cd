package com.irctc_backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trainRoute")
public class TrainRoute {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private Station station;
	
	@ManyToOne
	private Train train;
	
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
	
	

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
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

	@Override
	public String toString() {
		return "TrainRoute [id=" + id + ", station=" + station + ", stationOrder=" + stationOrder + ", arrivalTime="
				+ arrivalTime + ", departureTime=" + departureTime + ", haultMinutes=" + haultMinutes
				+ ", distanceFromSource=" + distanceFromSource + "]";
	}
	
	
	
	
	

}
