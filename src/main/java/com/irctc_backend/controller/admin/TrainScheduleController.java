package com.irctc_backend.controller.admin;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc_backend.dto.TrainScheduleDto;
import com.irctc_backend.service.TrainScheduleService;

@RestController
@RequestMapping("/admin/train-schedules")
public class TrainScheduleController {

    // This controller will handle train schedule management
    // Methods for creating, updating, deleting, and listing train schedules will be added here

    // Example method to create a train schedule
    // @PostMapping
    // public ResponseEntity<TrainScheduleDto> createTrainSchedule(@RequestBody TrainScheduleDto trainScheduleDto) {
    //     // Implementation here
    // }

    // Additional methods for train schedule management can be added here
    //
    //create train schedule

    private TrainScheduleService trainScheduleService;

    public TrainScheduleController(TrainScheduleService trainScheduleService) {
        this.trainScheduleService = trainScheduleService;
    }

    @PostMapping
    public ResponseEntity<TrainScheduleDto> createTrainSchedule(
            @RequestBody TrainScheduleDto trainScheduleDto) {
        // Implementation here
        TrainScheduleDto createdSchedule = trainScheduleService.createSchedule(trainScheduleDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchedule);
        return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
    }


    // get train schedules by train ID
    @GetMapping("/train/{trainId}")
    public List<TrainScheduleDto> getTrainSchedulesByTrainId(@PathVariable Long trainId) {
        return trainScheduleService.getTrainSchedulesByTrainId(trainId);
    }

    // delete train schedule
    @DeleteMapping("/{trainScheduleId}")
    public ResponseEntity<Void> deleteTrainSchedule(@PathVariable Long trainScheduleId) {
        trainScheduleService.deleteTrainSchedule(trainScheduleId);
        return ResponseEntity.noContent().build();
    }
    // update train schedule
    @PutMapping("/{trainScheduleId}")
    public ResponseEntity<TrainScheduleDto> updateTrainSchedule(
            @PathVariable Long trainScheduleId,
            @RequestBody TrainScheduleDto trainScheduleDto) {
        TrainScheduleDto updatedSchedule = trainScheduleService.updateTrainSchedule(trainScheduleId, trainScheduleDto);
        return ResponseEntity.ok(updatedSchedule);
    }

}