package com.irctc_backend.util;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResourceNotFoundExce(ResourceNotFoundException ex) {
		ApiResponse<?> apiResponse = new ApiResponse<>();
		apiResponse.setSuccess(false);
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setData(null);
		apiResponse.setTimestamp(Instant.now());
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentException(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			@Nullable
			String errorMsg = error.getDefaultMessage();
			String field = ((FieldError) error).getField();
			errorMap.put(field, errorMsg);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

		Map<String, String> errorMap = new HashMap<>();

		String name = ex.getName(); // parameter name
		String type = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "Unknown";
		String value = ex.getValue() != null ? ex.getValue().toString() : "null";

		String message = String.format("Parameter '%s' must be of type '%s', but received value '%s'", name, type,
				value);
		errorMap.put(name, message);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}

}
