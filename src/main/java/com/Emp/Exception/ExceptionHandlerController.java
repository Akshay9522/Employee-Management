package com.Emp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
@ExceptionHandler(NoSuchEmployeeException.class)
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public ExceptionResponse handleException(NoSuchEmployeeException noSuchElementException) {
	ExceptionResponse exceptionResponse = new ExceptionResponse();
	exceptionResponse.setErrorCode("ERROR_EMPLOYEE");
	exceptionResponse.setErrorMessage(noSuchElementException.getMessage());
	return exceptionResponse;
	
}
}
