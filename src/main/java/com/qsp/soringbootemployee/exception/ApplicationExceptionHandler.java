package com.qsp.soringbootemployee.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.soringbootemployee.util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with given id not found");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotPresent.class)
	public ResponseEntity<ResponseStructure<String>> emailNotPresentExceptionHandler(EmailNotPresent ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with given email not present");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoData.class)
	public ResponseEntity<ResponseStructure<String>> noDataExceptionHandler(NoData ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("No Data Present in the table");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNotPresent.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotPresentExceptionHandler(PhoneNotPresent ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Employee with given phone not present");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotPresentInGivenRange.class)
	public ResponseEntity<ResponseStructure<String>> notPresentInGivenRangeExceptionHandler(NotPresentInGivenRange ex)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("No Data Present In Given Range");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map =new HashMap<String, String>();
		for(ObjectError objectError : errors)
		{
			FieldError error =(FieldError) objectError;
			String field=error.getField();
			String message= error.getDefaultMessage();
			map.put(field, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
