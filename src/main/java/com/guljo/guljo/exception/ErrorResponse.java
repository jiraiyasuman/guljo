package com.guljo.guljo.exception;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private long timestamp;
	private String message;
}
