package com.irctc_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc_backend.model.Station;

public interface StationRepository extends JpaRepository<Station, Long>{

}
