package com.irctc_backend.service;

import org.springframework.data.domain.Page;

import com.irctc_backend.model.Station;

public interface StationService {
	
	public Station saveStation(Station station);

	public Page<Station> getListOfStations(int pageNo, int pageSize, String sortBy, String sortDir);

	public Station getStationById(Long id);

	public Station updateStationById(Long id, Station station);

	public void deleteStationById(Long id);

}
