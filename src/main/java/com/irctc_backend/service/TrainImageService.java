package com.irctc_backend.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.irctc_backend.dto.TrainImageDataWithResource;
import com.irctc_backend.dto.TrainImageResponse;
import com.irctc_backend.model.Train;
import com.irctc_backend.model.TrainImage;
import com.irctc_backend.repository.TrainImageRepository;
import com.irctc_backend.repository.TrainRepository;
import com.irctc_backend.util.ResourceNotFoundException;

@Service
public class TrainImageService {

	@Value("${train.image.folder.path}")
	private String folderPath;

	@Autowired
	private TrainImageRepository trainImageRepository;

	@Autowired
	private TrainRepository trainRepository;

	public TrainImageResponse upload(MultipartFile file, Long trainNo) throws IOException {

		Train train = trainRepository.findById(trainNo)
				.orElseThrow(() -> new ResourceNotFoundException("Train Not Available for given Train ID!!!"));

		if (!Files.exists(Paths.get(folderPath))) {
			Files.createDirectories(Paths.get(folderPath));
		}

		String fullFilePath = folderPath + File.separator + UUID.randomUUID() + "_" + file.getOriginalFilename();

		Files.copy(file.getInputStream(), Paths.get(fullFilePath), StandardCopyOption.REPLACE_EXISTING);

		TrainImage image = new TrainImage();
		image.setFileName(fullFilePath);
		image.setFileType(file.getContentType());
		image.setSize(file.getSize());
		image.setTrain(train);
		train.setTrainImage(image);
		
		Train savedTrain = trainRepository.save(train);
		
		return TrainImageResponse.from(savedTrain.getTrainImage(), "http://localhost:8080");

	}
	
	
	public TrainImageDataWithResource getTrainImageByTrainId(Long trainId) {

	    Train train = trainRepository.findById(trainId)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Train not found with id: " + trainId));

	    TrainImage trainImage = train.getTrainImage();
	    if (trainImage == null) {
	        throw new ResourceNotFoundException("Image not found for train id: " + trainId);
	    }

	    String fileName = trainImage.getFileName();

	    Path imagePath = Paths.get(folderPath).resolve(fileName).normalize();
	    Resource resource;

	    try {
	        resource = new UrlResource(imagePath.toUri());
	    } catch (MalformedURLException e) {
	        throw new RuntimeException("Invalid image path", e);
	    }

	    if (!resource.exists() || !resource.isReadable()) {
	        throw new ResourceNotFoundException("Image file not found: " + fileName);
	    }

	    return new TrainImageDataWithResource(trainImage,resource);
	}


}
