package com.irctc_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc_backend.dto.TrainRouteDto;
import com.irctc_backend.model.Station;
import com.irctc_backend.model.Train;
import com.irctc_backend.model.TrainRoute;
import com.irctc_backend.repository.StationRepository;
import com.irctc_backend.repository.TrainRepository;
import com.irctc_backend.repository.TrainRouteRepository;
import com.irctc_backend.util.ResourceNotFoundException;

@Service
public class TrainRouteServiceImpl implements TrainRouteService {

	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private StationRepository stationRepository;

	@Autowired
	private TrainRouteRepository trainRouteRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TrainRouteDto addRoute(TrainRouteDto dto) {

		Train train = trainRepository.findById(dto.getTrain().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Train not found with id: " + dto.getTrain().getId()));
		Station station = stationRepository.findById(dto.getTrain().getId()).orElseThrow(
				() -> new ResourceNotFoundException("Station not found with id: " + dto.getTrain().getId()));

		TrainRoute trainRoute = modelMapper.map(dto, TrainRoute.class);
		trainRoute.setStation(station);
		trainRoute.setTrain(train);

		TrainRoute savedTrainRoute = trainRouteRepository.save(trainRoute);

		TrainRouteDto trainRouteDto = modelMapper.map(savedTrainRoute, TrainRouteDto.class);

		return trainRouteDto;
	}

	@Override
	public List<TrainRouteDto> getRoutesByTrain(Long trainId) {
		Train train = this.trainRepository.findById(trainId)
				.orElseThrow(() -> new ResourceNotFoundException("Train not found with ID: " + trainId));

		List<TrainRoute> trainRoutesList = trainRouteRepository.findRoutesByTrainId(trainId);

		List<TrainRouteDto> list = trainRoutesList.stream()
				.map(trainRoute -> modelMapper.map(trainRoute, TrainRouteDto.class)).toList();

		return list;
	}

	@Override
	public TrainRouteDto updateRoute(Long id, TrainRouteDto dto) {

		TrainRoute existingRoute = trainRouteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Train route not found with ID: " + id));

		Station station = this.stationRepository.findById(dto.getStation().getId()).orElseThrow(
				() -> new ResourceNotFoundException("Station not found with ID: " + dto.getStation().getId()));
		Train train = this.trainRepository.findById(dto.getTrain().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Train not found with ID: " + dto.getTrain().getId()));
		// Update the existing route with new values
		existingRoute.setStation(station);
		existingRoute.setTrain(train);
		existingRoute.setStationOrder(dto.getStationOrder());
		existingRoute.setArrivalTime(dto.getArrivalTime());
		existingRoute.setDepartureTime(dto.getDepartureTime());
		existingRoute.setHaultMinutes(dto.getHaultMinutes());
		existingRoute.setDistanceFromSource(dto.getDistanceFromSource());
		// Save the updated route
		TrainRoute updatedRoute = trainRouteRepository.save(existingRoute);
		// Convert updated entity back to DTO
		TrainRouteDto updatedRouteDto = modelMapper.map(updatedRoute, TrainRouteDto.class);
		return updatedRouteDto;
	}

	@Override
	public void deleteRoute(Long id) {

		TrainRoute existingRoute = trainRouteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Train route not found with ID: " + id));

		// Delete the route
		trainRouteRepository.delete(existingRoute);
	}
}
