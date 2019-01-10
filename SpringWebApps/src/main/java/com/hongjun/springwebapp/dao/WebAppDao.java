package com.hongjun.springwebapp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hongjun.springwebapp.model.UserReadListResDto;

@Service
public class WebAppDao extends SqlSessionDaoSupport {
	private static final Logger logger = LoggerFactory.getLogger(WebAppDao.class);
	
	public int insertUserInfo(HashMap<String, Object> map) throws Exception {
		logger.debug(map.toString());
		return getSqlSession().insert("sts.insertUserInfo", map);
	}
	public HashMap<String, Object> selectUserInfo(String userId) throws Exception {
		logger.debug(userId);
		return (HashMap<String, Object>) getSqlSession().selectOne("sts.selectUserInfo", userId);
	}
	public ArrayList<UserReadListResDto> selectUserList() throws Exception{
		return (ArrayList<UserReadListResDto>) getSqlSession().selectList("sts.selectUserList");
	}
	public int updateUserInfo(HashMap<String, Object> map) throws Exception {
		logger.debug(map.toString());
		return getSqlSession().insert("sts.updateUserInfo", map);
	}
	public int deleteUserInfo(String userId) throws Exception {
		logger.debug(userId);
		return getSqlSession().insert("sts.deleteUserInfo", userId);
	}
}
