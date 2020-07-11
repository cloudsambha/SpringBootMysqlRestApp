package com.springboot.app.model;

public class ErrorResponse
{
    public ErrorResponse(String message,String details,String code) {
        super();
        this.message = message;
        this.details = details;
        this.code=code;
    }
  
    private String message;
    private String details;
    private String code;
    
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
 
    
}
