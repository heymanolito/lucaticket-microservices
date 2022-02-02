package com.grupo1.lucaticket.exception;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.RollbackException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import com.mongodb.DuplicateKeyException;
import com.grupo1.lucaticket.dto.ErrorDTO;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(NoSuchElementException exc){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(RollbackException exc){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, new RuntimeException("Email repetido"));
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(DuplicateKeyException exc){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(IllegalArgumentException exc){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, exc);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(InvalidDataException exc){
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		List<String> errors = exc.getResult().getFieldErrors()
								 .stream().map(FieldError::getDefaultMessage)
								 .collect(Collectors.toList());
		return buildResponseEntity(httpStatus, new RuntimeException("Datos invalidos"), errors);
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(MethodArgumentTypeMismatchException exc){
		//cuando los argumentos son invalidos: String por int
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		return buildResponseEntity(httpStatus, new RuntimeException("Tipo de Argumento invalido"));
	}
	
	@ExceptionHandler
	protected ResponseEntity<ErrorDTO> handlerExceptionHandler(Exception exc){
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		return buildResponseEntity(httpStatus, new RuntimeException("Datos invalidos"));
	}
	
	protected ResponseEntity<ErrorDTO> buildResponseEntity(HttpStatus httpStatus,Exception exc){
		return buildResponseEntity(httpStatus, exc, null);
	}
	
	protected ResponseEntity<ErrorDTO> buildResponseEntity(HttpStatus httpStatus,Exception exc, List<String> errors){
		
		ErrorDTO error = new ErrorDTO();
		error.setMessage(exc.getMessage());
		error.setStatus(httpStatus.value());
		//error.setTimestamp(new Date());
		error.setErrors(errors);
		error.setErrors(errors);
		return new ResponseEntity<>(error, httpStatus);
	}
	
}
