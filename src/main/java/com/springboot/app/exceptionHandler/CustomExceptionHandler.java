package com.springboot.app.exceptionHandler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.app.exception.RecordNotFoundException;
import com.springboot.app.model.ErrorResponse;
 
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
    private final String RECORD_NOT_FOUND = "RECORD_NOT_FOUND";
    private final String METHOD_NOT_SUPPORTED="METHOD_NOT_SUPPORTED";
    private final String ARGUMENT_NOT_SUPPORTED="ARGUMENT_NOT_SUPPORTED";
    
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) 
    {
    	String details=ex.getLocalizedMessage();        
        ErrorResponse error = new ErrorResponse(RECORD_NOT_FOUND, details,"404");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        ErrorResponse error = new ErrorResponse(METHOD_NOT_SUPPORTED, ex.getLocalizedMessage(),"405");
        return new ResponseEntity<Object>(error,HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    @Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	ErrorResponse error = new ErrorResponse(ARGUMENT_NOT_SUPPORTED, ex.getLocalizedMessage(),"400");
    	return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);
	}
    
  
    
}