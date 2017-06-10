package com.hrm.dao;

import org.apache.ibatis.annotations.Param;

import com.hrm.vo.LdlscUser;

public interface LdlscUserMapper {

	LdlscUser find(@Param("userloginname")String userloginname,@Param("userpassword") String userpassword);
   
}