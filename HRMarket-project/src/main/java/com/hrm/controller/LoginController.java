package com.hrm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.hrm.service.UserService;
import com.hrm.utils.HRMResult;
import com.hrm.vo.LdlscUser;

@Controller
@RequestMapping("/login")
public final class LoginController{
	@Autowired
	private UserService UserService;
	@RequestMapping("/tologin")
	public String toLogin() {
		return "login";
	}
	@RequestMapping("/login")
	@ResponseBody
	public HRMResult login(String userloginname,String userpassword,HttpSession session) {
		LdlscUser user = null;
		try {
			user = UserService.validate(userloginname,userpassword);
		}catch(Exception e) {
			return HRMResult.build(400, "用户名或密码错误");
		}
		if(user ==null) {
			return HRMResult.build(400, "用户名或密码错误");
		}else
		{
			session.setAttribute("login", user);
			return HRMResult.ok();
		}
	} 
	
}
