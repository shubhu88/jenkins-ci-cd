package com.irctc_backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.irctc_backend.dto.TrainDto;
import com.irctc_backend.model.Train;

public interface TrainService {

	  // create train
    public TrainDto createTrain(TrainDto trainDTO);

    //list trains
    public List<TrainDto> getAllTrains();

    //get train by id
    public TrainDto getTrainById(Long id);

    //update train
    public TrainDto updateTrain(Long id, TrainDto trainDTO);

    //delete train
    public void deleteTrain(Long id);


    //    search trains for booking
    //List<AvailableTrainResponse> userTrainSearch(UserTrainSearchRequest request);


}
