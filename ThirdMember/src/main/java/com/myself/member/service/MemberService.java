package com.myself.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myself.member.dto.MemberVO;
import com.myself.member.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public List<MemberVO> memberList() {
		return memberMapper.memberList();
	}

	public int memberRegist(MemberVO memberVO) {
		return memberMapper.memberRegist(memberVO);
	}
	
	public MemberVO memberGetOne(int mno) {
		return memberMapper.memberGetOne(mno);
	}
	
	public MemberVO memberExist(MemberVO memberVO) {
		return memberMapper.memberExist(memberVO);
	}
	
	public MemberVO checkIdDup(String email) {
		return memberMapper.checkIdDup(email);
	}
}
