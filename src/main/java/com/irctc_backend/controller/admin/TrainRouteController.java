package com.irctc_backend.controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc_backend.dto.TrainRouteDto;
import com.irctc_backend.service.TrainRouteService;

@RestController
@RequestMapping("/admin/train-routes")
public class TrainRouteController {

	private TrainRouteService trainRouteService;

	public TrainRouteController(TrainRouteService trainRouteService) {
		this.trainRouteService = trainRouteService;
	}

	// create train route
	@PostMapping
	public ResponseEntity<TrainRouteDto> createTrainRoute(

			@RequestBody TrainRouteDto trainRouteDto) {
		TrainRouteDto createdRoute = trainRouteService.addRoute(trainRouteDto);
		return ResponseEntity.status(201).body(createdRoute);
	}

	// List train routes by train ID
	@GetMapping("/train/{trainId}")
	public ResponseEntity<List<TrainRouteDto>> getRoutesByTrain(@PathVariable Long trainId) {
		List<TrainRouteDto> routes = trainRouteService.getRoutesByTrain(trainId);
		return ResponseEntity.ok(routes);
	}

	// Update train route
	@PutMapping("/{id}")
	public ResponseEntity<TrainRouteDto> updateTrainRoute(@PathVariable Long id,
			@RequestBody TrainRouteDto trainRouteDto) {
		TrainRouteDto updatedRoute = trainRouteService.updateRoute(id, trainRouteDto);
		return ResponseEntity.ok(updatedRoute);
	}

	// Delete train route
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrainRoute(@PathVariable Long id) {
		trainRouteService.deleteRoute(id);
		return ResponseEntity.noContent().build();
	}

	// Additional methods for train route management can be added here

}
