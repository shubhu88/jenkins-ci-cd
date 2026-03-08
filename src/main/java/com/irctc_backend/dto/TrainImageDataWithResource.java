package com.irctc_backend.dto;

import org.springframework.core.io.Resource;

import com.irctc_backend.model.TrainImage;

public record TrainImageDataWithResource(
		TrainImage trainImage,
		Resource resource
		) {
	
	

}
