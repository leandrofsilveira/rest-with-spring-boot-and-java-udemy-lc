package br.com.lfrancisco.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDateTime timeStamp;
	private String message;
	private String details;

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
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

	public ExceptionResponse(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
}
