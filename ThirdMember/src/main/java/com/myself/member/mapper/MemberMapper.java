package com.myself.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myself.member.dto.MemberVO;

//mapper는 선언만 해놓고 코드가 없어서 xml과 한세트
//인터페이스야!!
//왜?우리가 직접 다 코드 안적고 myBatis가 이 인터페이스와 xml가지고
//알아서 소스를 작성해서 클래스를 구현해서 db접속하고 정보주는거야.
//그래서 인터페이스!!
//안그러면 그냥 클래스로 만들어서 DAO로했지

@Repository
public interface MemberMapper {

	public List<MemberVO> memberList();
	
	public int memberRegist(MemberVO membervVO);
	
	public MemberVO memberGetOne(int mno);
	
	public MemberVO memberExist(MemberVO memberVO);
	
	public MemberVO checkIdDup(String email);
}
