package com.irctc_backend.dto;

import java.time.LocalDateTime;

import com.irctc_backend.model.TrainImage;

public record TrainImageResponse(Long id, String fileName, String fileType, String url, long size,
		LocalDateTime uploadTime

) {

	public static TrainImageResponse from(TrainImage trainImage, String baseUrl) {
		return new TrainImageResponse(trainImage.getId(), trainImage.getFileName(),
				trainImage.getFileType(), baseUrl + "/" + trainImage.getFileName(), trainImage.getSize(),
				trainImage.getUploadTime());

	}

}
