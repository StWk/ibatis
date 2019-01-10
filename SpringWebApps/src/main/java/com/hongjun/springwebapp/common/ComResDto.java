package com.hongjun.springwebapp.common;

public class ComResDto {
   String code;
   Object data;
   public ComResDto(String code, Object data){
      this.code = code;
      this.data = data;
   }
   public String getCode() {
      return code;
   }
   public void setCode(String code) {
      this.code = code;
   }
   public Object getData() {
      return data;
   }
   public void setData(Object data) {
      this.data = data;
   }
   @Override
   public String toString() {
      return "ComResDto [code=" + code + ", data=" + data.toString() + "]";
   }
}