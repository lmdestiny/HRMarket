package com.hrm.service;

import com.hrm.vo.LdlscUser;

public interface UserService{

	LdlscUser validate(String userloginname, String userpassword);

}
