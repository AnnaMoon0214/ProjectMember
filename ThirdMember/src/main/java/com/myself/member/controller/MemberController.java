package com.myself.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myself.member.dto.MemberVO;
import com.myself.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	//리스트 담당..
	//db에서 가져와서 화면출력해야해(jsp)
	//get만 하고 post는 안해.
	@GetMapping("/member/list")
	public String memberList(Model model) {
		
		//db에서 멤버 리스트 가져와서..
		//jsp에서 꺼내쓸 수 있도록 저장을 할건데 기존에는 sc, request, session보관소에 저장했다면
		//spirng에서는 pojo형식으로 다 일반클래스라서 저 3보관소에 접근이 안되서
		//model이라는 곳에 저장해서 넣었따 뺐다 할거야.
		//그리고 db에서 가져온 정보를 넣을 객체 즉, DTO(VO)도 필요
		
		//db접속 myBatis를 통해서 DataSource는 Hikari CP
		//spring-jdbc
		//spring-myBatis
		//mybitis
		//Hikari CP
		//ojdbc
		//log4jdbc
		model.addAttribute("members", memberService.memberList());
		return "MemberList";
	}
	
	@GetMapping("member/add")
	public String memberRegisterGet() {
		//새로 가입할 회원의 정보를 입력받는 화면만 출력..
		return "MemberAddGet";
	}
	
	@PostMapping("member/add")
	public String memberRegisterPost(Model model, MemberVO memberVO) {
		model.addAttribute("name", memberVO.getMname());
		model.addAttribute("member", memberService.memberRegist(memberVO));
		return "MemberAddPost";
	}
	
	@GetMapping("member/update")
	public String memberUpdateGet(@RequestParam("mno") int mno, Model model, MemberVO memberVO) {
		//사용자한테 수텅하러고 화면도 주고,
		//수정할 기존의 정보를 db에서도 가져오고
		//mno를 기준으로...
		model.addAttribute("member", memberService.memberGetOne(mno));
		return "MemberUpdateGet";
	}
}
