package com.ligne.bleue.uphf.exeptions;

import java.util.Date;

public class Success {
	private Date timestamp;
	private boolean success;
	private String message;

	public Success(boolean success, String message, Date timestamp) {
		super();
		this.success = success;
		this.message = message;
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

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
