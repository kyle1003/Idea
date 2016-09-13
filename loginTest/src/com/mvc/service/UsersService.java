package com.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService extends BaseService {
	@Autowired
	@Transactional
	public List<Object> getAllList(){
		List<Object> list = getAllList("com.mvc.entity.Users");
		return list;
	}
	public boolean isExist(String username, String password){
		List<Object> list = findByWhere("com.mvc.entity.Users", new String[]{"user","password"}, new String[] {username,password});
		return list!=null?true:false;
	}
}
