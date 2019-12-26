package com.ligne.bleue.uphf.exeptions;

import java.util.Date;

public class Success {
	private Date timestamp;
	private boolean success;
	private String message;

	public Success(boolean success, String msg, Date timestamp) {
		super();
		this.success = success;
		this.message = msg;
		this.timestamp = timestamp;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return message;
	}

	public void setMsg(String msg) {
		this.message = msg;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
