package com.hongjun.springwebapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hongjun.springwebapp.dao.WebAppDao;
import com.hongjun.springwebapp.model.UserCreateReqDto;
import com.hongjun.springwebapp.model.UserCreateResDto;
import com.hongjun.springwebapp.model.UserDeleteResDto;
import com.hongjun.springwebapp.model.UserModifyReqDto;
import com.hongjun.springwebapp.model.UserModifyResDto;
import com.hongjun.springwebapp.model.UserReadListResDto;
import com.hongjun.springwebapp.model.UserReadResDto;

@Service
public class WebAppService {
	private static final Logger logger = LoggerFactory.getLogger(WebAppService.class);
	
	@Autowired
	private WebAppDao dao;
	
	public UserCreateResDto userCreate(UserCreateReqDto reqDto, Model model) {
		logger.debug("userCreate");
		
		String userId = "UID" + new Date().getTime();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userId", userId);
		map.put("userName", reqDto.getUserName());
		map.put("phoneNumber", reqDto.getPhoneNumber());
		
		int insertUserInfoCnt = 0;
		
		try {
			insertUserInfoCnt = dao.insertUserInfo(map);
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.debug("insertUserInfoCnt" + insertUserInfoCnt);
		
		UserCreateResDto resDto = new UserCreateResDto();
		resDto.setUserId(userId);
		
		return resDto;
	}
	public UserReadResDto userRead(String userId, Model model) {
		logger.debug("userRead");

		HashMap<String, Object> outmap = null;
		
		try {
			outmap = dao.selectUserInfo(userId);
			logger.debug(outmap.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserReadResDto resDto = new UserReadResDto();
		resDto.setUserName(outmap.get("userName").toString());
		resDto.setPhoneNumber(outmap.get("phoneNumber").toString());
		
		return resDto;
	}
	public ArrayList<UserReadListResDto> userList(Model model) {
		logger.debug("userList");
		
		ArrayList<UserReadListResDto> list = new ArrayList<UserReadListResDto>();
		ArrayList<UserReadListResDto> outlist = null;
		
		try {
			outlist = dao.selectUserList();
			logger.debug(outlist.toString());
		
			for (int i=0; i<outlist.size(); i++) {
				UserReadListResDto resDto = outlist.get(i);
				logger.debug(resDto.toString());
				list.add(resDto);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public UserModifyResDto userModify(UserModifyReqDto reqDto, String userId, Model model) {
		logger.debug("userModify");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("userName", reqDto.getUserName());
		map.put("phoneNumber", reqDto.getPhoneNumber());
		
		int updateUserInfoCnt = 0;
		try {
			updateUserInfoCnt = dao.updateUserInfo(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("updateUserInfoCnt: " + updateUserInfoCnt);
		
		UserModifyResDto resDto = new UserModifyResDto();

		if(updateUserInfoCnt == 1) {
			resDto.setSuccess(true);
		}
		return resDto;
	}
	public UserDeleteResDto userDelete(String userId, Model model) {
		logger.debug("userDelete");
		
		int deleteUserInfoCnt = 0;
		try {
			deleteUserInfoCnt = dao.deleteUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("deleteUserInfoCnt: " + deleteUserInfoCnt);
		
		UserDeleteResDto resDto = new UserDeleteResDto();
		
		if (deleteUserInfoCnt ==1) {
			resDto.setSuccess(true);
		}
		return resDto;
	}
}
