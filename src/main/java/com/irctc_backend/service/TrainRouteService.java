package com.irctc_backend.service;

import java.util.List;

import com.irctc_backend.dto.TrainRouteDto;

public interface TrainRouteService {

	public TrainRouteDto addRoute(TrainRouteDto dto);

	List<TrainRouteDto> getRoutesByTrain(Long trainId);

	TrainRouteDto updateRoute(Long id, TrainRouteDto dto);

	void deleteRoute(Long id);

}