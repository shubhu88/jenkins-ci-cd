package com.irctc_backend.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.irctc_backend.dto.TrainDto;
import com.irctc_backend.service.TrainService;

import java.util.List;

@RestController("adminTrainController")
@RequestMapping("/admin/trains")

public class TrainController {

	private TrainService trainService;

	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}

	@PostMapping
	public ResponseEntity<TrainDto> createTrain(@RequestBody TrainDto trainDTO) {
//        System.out.println(trainDTO.getNumber());
//        System.out.println(trainDTO.getName());
//        System.out.println(trainDTO.getSourceStation().getId());
		return new ResponseEntity<>(trainService.createTrain(trainDTO), HttpStatus.CREATED);
	}

	@GetMapping
	public List<TrainDto> getAllTrains() {
		return trainService.getAllTrains();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TrainDto> getTrainById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(trainService.getTrainById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TrainDto> updateTrain(@PathVariable("id") Long id, @RequestBody TrainDto trainDTO) {
		return new ResponseEntity<>(trainService.updateTrain(id, trainDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrain(@PathVariable("id") Long id) {
		trainService.deleteTrain(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}