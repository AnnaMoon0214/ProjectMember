package com.myself.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myself.member.dto.MemberVO;
import com.myself.member.service.MemberService;

@Controller
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public String loinGet() {
		return "auth/loginGet";
	}
	

	@PostMapping("/login")
	public String loginPost(MemberVO memberVO, HttpSession session) {
		MemberVO loginMember;
		loginMember=memberService.memberExist(memberVO);
		session.setAttribute("loginMember", loginMember);
		if(loginMember!=null) {
			return "redirect:/member/list";
		} else {
			return "auth/loginGet";
		}
	}
}
