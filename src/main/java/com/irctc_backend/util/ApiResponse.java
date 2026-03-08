package com.irctc_backend.util;

import java.sql.Timestamp;
import java.time.Instant;

public class ApiResponse<T> {

	private String message;
	private T data;
	private boolean success;
	private Instant timestamp;

	public static <T> ApiResponse<T> success(String message, T data) {
		ApiResponse apiResponse = new ApiResponse<>();

		apiResponse.success = true;
		apiResponse.message = message;
		apiResponse.data = data;
		apiResponse.timestamp = Instant.now();

		return apiResponse;
	}

	public static <T> ApiResponse<T> failure(String message) {
		ApiResponse<T> apiResponse = new ApiResponse<>();
		apiResponse.success = false;
		apiResponse.message = message;
		apiResponse.timestamp = Instant.now();
		return apiResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

}
