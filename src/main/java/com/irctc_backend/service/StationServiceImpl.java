package com.irctc_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.irctc_backend.model.Station;
import com.irctc_backend.repository.StationRepository;
import com.irctc_backend.util.ResourceNotFoundException;

@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationRepository stationRepository;

	@Override
	public Station saveStation(Station station) {
		Station saveStation = stationRepository.save(station);
		return saveStation;
	}

	@Override
	public Page<Station> getListOfStations(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.trim().toLowerCase().equals("asc") ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
		Page<Station> allStation = stationRepository.findAll(pageRequest);

		return allStation;

	}

	@Override
	public Station getStationById(Long id) {
		Station station = stationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Station not found by given Id..."));
		return station;
	}

	@Override
	public Station updateStationById(Long id, Station station) {
		Station oldStation = stationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Station not found by given Id..."));

		oldStation.setName(station.getName());
		oldStation.setCity(station.getCity());
		oldStation.setCode(station.getCode());
		oldStation.setState(station.getState());

		Station savedStation = stationRepository.save(oldStation);
		return savedStation;
	}

	@Override
	public void deleteStationById(Long id) {
		stationRepository.deleteById(id);
	}

}
