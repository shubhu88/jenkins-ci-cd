package com.irctc_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc_backend.model.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

}
