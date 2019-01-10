package com.hongjun.springwebapp.model;

public class UserModifyReqDto {
	String userName;
	String phoneNumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "UserModifyReqDto [userName=" + userName + ", phoneNumber=" + phoneNumber + "]";
	}
}
