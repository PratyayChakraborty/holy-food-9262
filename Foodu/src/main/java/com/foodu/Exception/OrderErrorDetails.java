package com.foodu.Exception;

import java.time.LocalDateTime;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class OrderErrorDetails {
	
	private LocalDateTime TimeStamp;
	private String message;
	private String details;
	public OrderErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		TimeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	public OrderErrorDetails() {

	}
	public LocalDateTime getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		TimeStamp = timeStamp;
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
	@Override
	public String toString() {
		return "OrderErrorDetails [TimeStamp=" + TimeStamp + ", message=" + message + ", details=" + details + "]";
	}

	
	
	
	
}
