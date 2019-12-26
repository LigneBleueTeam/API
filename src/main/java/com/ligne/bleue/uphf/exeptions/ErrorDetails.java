package com.ligne.bleue.uphf.exeptions;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private boolean success;
	private String message;
	private String path;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details, String path, boolean success) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
		this.success = success;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
