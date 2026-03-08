package com.irctc_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc_backend.model.TrainImage;

@Repository
public interface TrainImageRepository extends JpaRepository<TrainImage, Long> {

}
