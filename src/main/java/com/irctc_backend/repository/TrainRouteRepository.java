package com.irctc_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irctc_backend.model.TrainRoute;

@Repository
public interface TrainRouteRepository extends JpaRepository<TrainRoute, Long>{

	@Query("SELECT tr FROM TrainRoute tr WHERE tr.train.id = ?1 order by tr.stationOrder")
	List<TrainRoute> findRoutesByTrainId(Long trainId);

}
