package com.irctc_backend.service;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc_backend.dto.TrainScheduleDto;
import com.irctc_backend.model.Train;
import com.irctc_backend.model.TrainSchedule;
import com.irctc_backend.repository.TrainRepository;
import com.irctc_backend.repository.TrainScheduleRepository;
import com.irctc_backend.util.ResourceNotFoundException;

@Service

public class TrainScheduleServiceImpl implements TrainScheduleService {

    private TrainScheduleRepository trainScheduleRepository;
    private TrainRepository trainRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public TrainScheduleServiceImpl(TrainScheduleRepository trainScheduleRepository, TrainRepository trainRepository, ModelMapper modelMapper) {
        this.trainScheduleRepository = trainScheduleRepository;
        this.trainRepository = trainRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TrainScheduleDto createSchedule(TrainScheduleDto trainScheduleDto) {
        Train train = trainRepository.findById(trainScheduleDto.getTrainId()).orElseThrow(() -> new ResourceNotFoundException("Train not found with id: " + trainScheduleDto.getTrainId()));
        TrainSchedule trainSchedule = modelMapper.map(trainScheduleDto, TrainSchedule.class);
        trainSchedule.setTrain(train);
        TrainSchedule savedSchedule = trainScheduleRepository.save(trainSchedule);
        return modelMapper.map(savedSchedule, TrainScheduleDto.class);


    }

    @Override
    public List<TrainScheduleDto> getTrainSchedulesByTrainId(Long trainId) {
        List<TrainSchedule> trainSchedules = trainScheduleRepository.findByTrainId(trainId);
        return trainSchedules.stream().map(trainSchedule -> modelMapper.map(trainSchedule, TrainScheduleDto.class)).toList();
    }

    @Override
    public void deleteTrainSchedule(Long trainScheduleId) {
        TrainSchedule trainSchedule = trainScheduleRepository.findById(trainScheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Train schedule not found with id: " + trainScheduleId));
        trainScheduleRepository.delete(trainSchedule);
    }

    @Override
    public TrainScheduleDto updateTrainSchedule(Long trainScheduleId, TrainScheduleDto trainScheduleDto) {
        TrainSchedule trainSchedule = trainScheduleRepository.findById(trainScheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Train schedule not found with id: " + trainScheduleId));
        Train train = trainRepository.findById(trainScheduleDto.getTrainId()).orElseThrow(() -> new ResourceNotFoundException("Train not found with id: " + trainScheduleDto.getTrainId()));
        trainSchedule.setTrain(train);
        trainSchedule.setAvailableSeats(trainScheduleDto.getAvailableSeats());
        trainSchedule.setRunDate(trainScheduleDto.getRunDate());
        TrainSchedule updatedSchedule = trainScheduleRepository.save(trainSchedule);
        return modelMapper.map(updatedSchedule, TrainScheduleDto.class);
    }
}