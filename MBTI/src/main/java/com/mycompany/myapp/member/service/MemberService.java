package com.mycompany.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.member.dao.MemberDao;

@Service
public class MemberService {
	@Autowired
	MemberDao dao;

	//회원가입
	public void addMember(Member member) {
		dao.addMember(member);
	}

	//로그인
	public boolean login(Member member) {
		return dao.login(member);
	}

	//회원정보 조회
	public Member memberInfo(Member member) {
		return dao.memberInfo(member);
	}
}
