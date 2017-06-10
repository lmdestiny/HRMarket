package com.hrm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hrm.vo.LdlscUser;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception{
			HttpSession session = request.getSession();
			LdlscUser user = (LdlscUser)session.getAttribute("login");
			if(user !=null) {
				return true;
			}
			response.sendRedirect("/login/tologin");
		return false;
	}
}
