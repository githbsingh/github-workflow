package com.mmm.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mmm.model.CustomErrorResponse;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class.getName());

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {

		CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		if (LOG.isDebugEnabled()) {
			LOG.debug("-- customHandleNotFound() > Got param: {}", errors);
		}
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}
}
