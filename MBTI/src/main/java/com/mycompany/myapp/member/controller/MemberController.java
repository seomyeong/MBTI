package com.mycompany.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	/*
	 * ------------------------
	 * 회원가입창 진입
	 * ------------------------
	 */
	@GetMapping("/memberService/addMember")
	public String addMember(@ModelAttribute Member member) {
		return "memberService/addMember";
	}

	/*
	 * -------------------------
	 * 회원가입
	 * -------------------------
	 */
	@GetMapping("/memberService/successAddMember")
	public String successAddMemberGet() {
		return "memberService/successAddMember";
	}

	@PostMapping("/memberService/successAddMember")
	public ModelAndView successAddMember(Member member) {
		ModelAndView mav = new ModelAndView();
		memberService.addMember(member);
		mav.setViewName("/memberService/successAddMember");
		return mav;
	}

	/*
	 * ------------------------
	 * 로그인창 진입
	 * ------------------------
	 */
	@GetMapping("/memberService/login")
	public String loginGet() {
		return "memberService/login";
	}

	/*
	 * ------------------------
	 * 로그인 실행
	 * 입력된 member의 정보를 session에 보낸다.
	 * ------------------------
	 */
	@PostMapping("/memberService/login")
	public ModelAndView login(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		if(memberService.login(member)) {
			Member memberInfo = memberService.memberInfo(member);

			session.setAttribute("memberInfo", memberInfo);
			session.setAttribute("Id", memberInfo.getId());
			session.setMaxInactiveInterval(-1);

			mav.addObject("member", memberInfo);
			mav.setViewName("../../index");
			System.out.println("로그인성공");
			return mav;
		}
		else {
			mav.addObject("errorMsg", "회원정보가 일치하지 않습니다.");
			mav.setViewName("/memberService/login");
			System.out.println("로그인실패");
			return mav;
		}
	}

	/*
	 * ------------------------
	 * 로그아웃 실행 (경로문제 고치기)
	 * ------------------------
	 */
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "../../index";
	}

	/*
	 * ------------------------
	 * 자유게시판 진입
	 * ------------------------
	 */
	@GetMapping("/memberService/memberFreeBoard")
	public String memberFreeBoard() {
		return "memberService/memberFreeBoard";
	}

}