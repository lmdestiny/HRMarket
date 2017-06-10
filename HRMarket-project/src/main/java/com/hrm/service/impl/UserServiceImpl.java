package com.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.LdlscUserMapper;
import com.hrm.service.UserService;
import com.hrm.vo.LdlscUser;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private LdlscUserMapper userMapper;
	@Override
	public LdlscUser validate(String userloginname, String userpassword){
		return userMapper.find(userloginname,userpassword);
	}

}
