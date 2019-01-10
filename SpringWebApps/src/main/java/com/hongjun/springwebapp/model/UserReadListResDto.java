package com.hongjun.springwebapp.model;

public class UserReadListResDto {
	String userId;
	String userName;
	String phoneNumber;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
		return "UserReadResDto [userId=" + userId + ", userName=" + userName + ", phoneNumber=" + phoneNumber + "]";
	}
}
