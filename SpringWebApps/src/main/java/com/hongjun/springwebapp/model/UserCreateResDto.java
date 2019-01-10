package com.hongjun.springwebapp.model;

public class UserCreateResDto {
   String userId;
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   @Override
   public String toString() {
      return "UserCreateResDto [userId=" + userId + "]";
   }
}
