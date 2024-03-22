package com.dushime.utility;

public class Return {
	private String message;
	private boolean check;
	private Exception error;
	
	public Return(String message, boolean check, Exception error) {
		super();
		this.message = message;
		this.check = check;
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public Exception getError() {
		return error;
	}
	public void setError(Exception error) {
		this.error = error;
	}
	
	public String toString() {
		return this.message;
	}
	
}
