package com.lms.controller.response;

import com.lms.enums.ResponseStatus;

public class GeneralResponse<T> {
	
	private T data;
	private String message;
	private ResponseStatus status;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
	

}
