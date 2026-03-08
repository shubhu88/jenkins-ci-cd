package com.irctc_backend.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc_backend.model.Station;
import com.irctc_backend.service.StationService;

@RestController
@RequestMapping("/admin/station")
public class StationController {

	@Autowired
	private StationService stationService;

	@PostMapping
	public ResponseEntity<?> saveStation(@RequestBody Station station) {

		Station saveStation = stationService.saveStation(station);

		return new ResponseEntity<>(saveStation, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getListOfStations(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "name") String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) {

		Page<Station> listOfStations = stationService.getListOfStations(pageNo, pageSize, sortBy, sortDir);

		return new ResponseEntity<>(listOfStations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStationById(@PathVariable Long id) {
		return new ResponseEntity<>(stationService.getStationById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStationById(@PathVariable Long id, @RequestBody Station station) {
		return new ResponseEntity<>(stationService.updateStationById(id, station), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStationById(@PathVariable Long id) {
		stationService.deleteStationById(id);
		return new ResponseEntity<>("Station Deleted Successfully...", HttpStatus.OK);
	}

}
