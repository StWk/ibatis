package com.hongjun.springwebapp.model;

public class UserDeleteResDto {
	boolean success;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public String toString() {
		return "UserDeleteResDto [success=" + success + "]";
	}
}
