package com.myself.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//로그인 체크할거니까 seesion 객체를 우선 가져와
		HttpSession session = request.getSession();
		
		//로그인처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴..
		//loginController에서 저장한거를 가져오는거야.
		return true;
	}

	
}
