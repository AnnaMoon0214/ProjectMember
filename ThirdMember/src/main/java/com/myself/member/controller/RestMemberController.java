package com.myself.member.controller;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myself.member.dto.MemberVO;
import com.myself.member.service.MemberService;

@RestController
@RequestMapping(value="/member/rest", produces="text/plain;charset=UTF-8")
public class RestMemberController {
	//private static final Logger logger=LoggerFactory.getLogger(RestMemberController.class)
	
	@Autowired
	MemberService memberService;
	
	@GetMapping(path="/listJson", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<MemberVO> memberRestListJson() {
		return memberService.memberList();
	}
	
	@GetMapping(path="/listXML", produces=MediaType.APPLICATION_XML_VALUE)
	public List<MemberVO> memberRestListXML(){
		return memberService.memberList();
	}

	// ajaxTestCheckEmail.jsp에서 바로 실행했을 때
	   @GetMapping(path="/checkEmailJson", produces=MediaType.APPLICATION_JSON_VALUE)
	   public String checkEmailJson(@RequestParam("email") String email) {
//	      logger.info("RestMemberController_Get_/checkEmailJson 실행");
//	      
//	      logger.info("Client에서 받은 email1 = " + email);
	      
	      return email;
	   }
	   
	   @GetMapping(path="checkIdDup", produces=MediaType.APPLICATION_JSON_VALUE)
	   public String checkIdDup(@RequestParam("email") String email) {
		   MemberVO member = memberService.checkIdDup(email);
		   if(member==null) {
			   return "0"; //db에서 일치하는 email이 없어서 중복이 아니다
		   } else {
			   return "1";
		   }
	   }
}
