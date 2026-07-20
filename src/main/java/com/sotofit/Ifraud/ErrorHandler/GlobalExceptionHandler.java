package com.sotofit.Ifraud.ErrorHandler;

import java.awt.datatransfer.StringSelection;
import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex
			.getBindingResult()
			.getFieldErrors()
			.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundException(ResourceNotFoundException ex) {
		log.warn("Email not found {}", ex.getMessage());

		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Email was not found");
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public Map<String, String> ResourceNotFoundException(IllegalArgumentException ex) {
		log.warn(" {}", ex.getMessage());

		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Enter user email");
		return errors;
	}
}
