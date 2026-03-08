package com.irctc_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "trains")
public class Train {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String name;

    private Integer totalDistance;


    @ManyToOne
    @JoinColumn(name = "source_station_id")
    private Station sourceStation;


    @ManyToOne
    @JoinColumn(name = "destination_station_id")
    private Station destinationStation;


//
//    @Email(message = "Invalid email")
//    private  String email;


    //train routes

    // schedules

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private TrainImage trainImage;


    @OneToMany(mappedBy = "train")
    private List<TrainRoute> routes;

    @OneToMany(mappedBy = "train")
    private  List<TrainSchedule> schedules;

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

	public TrainImage getTrainImage() {
		return trainImage;
	}

	public void setTrainImage(TrainImage trainImage) {
		this.trainImage = trainImage;
	}

	public List<TrainRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(List<TrainRoute> routes) {
		this.routes = routes;
	}

	public List<TrainSchedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<TrainSchedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", number=" + number + ", name=" + name + ", totalDistance=" + totalDistance
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", trainImage="
				+ trainImage + ", routes=" + routes + ", schedules=" + schedules + "]";
	}

	
	
	

}
