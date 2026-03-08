package com.irctc_backend.service;

import java.util.List;

import com.irctc_backend.dto.TrainScheduleDto;

public interface TrainScheduleService {

	TrainScheduleDto createSchedule(TrainScheduleDto trainScheduleDto);

	List<TrainScheduleDto> getTrainSchedulesByTrainId(Long trainId);

	void deleteTrainSchedule(Long trainScheduleId);

	TrainScheduleDto updateTrainSchedule(Long trainScheduleId, TrainScheduleDto trainScheduleDto);

}