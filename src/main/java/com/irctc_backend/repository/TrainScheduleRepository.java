package com.irctc_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.irctc_backend.model.TrainSchedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Long>
{


    @Query("SELECT ts FROM TrainSchedule ts WHERE ts.train.id = ?1")
    List<TrainSchedule> findByTrainId(Long trainId);

    @Query("SELECT ts FROM TrainSchedule ts WHERE ts.train.id = ?1 AND ts.runDate = ?2")
    Optional<TrainSchedule> findByTrainIdAndRunDate(Long trainId, LocalDateTime runDate);
}
