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
	 * 회원가입창
	 */
	@GetMapping("/member/addMember")
	public String addMember(@ModelAttribute Member member) {
		return "member/addMember";
	}

	/*
	 * 회원가입 성공
	 */
	@GetMapping("/member/successAddMember")
	public String successAddMemberGet() {
		return "member/successAddMember";
	}

	@PostMapping("/member/successAddMember")
	public ModelAndView successAddMember(Member member) {
		ModelAndView mav = new ModelAndView();
		memberService.addMember(member);
		mav.setViewName("/member/successAddMember");
		return mav;
	}

	/*
	 * 로그인
	 */
	@GetMapping("/member/login")
	public String loginGet() {
		return "member/login";
	}

	/*
	 * 로그인 실행
	 */
	@PostMapping("/member/login")
	public ModelAndView login(Member member, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		if(memberService.login(member)) {
			Member memberInfo = memberService.memberInfo(member);

			session.setAttribute("memberInfo", memberInfo);
			session.setAttribute("email", memberInfo.getEmail());
			session.setMaxInactiveInterval(-1);
			System.out.println(memberInfo);
			mav.addObject("member", memberInfo);
			mav.setViewName("../../index");
			System.out.println("로그인성공");
			return mav;
			
		}
		else {
			mav.addObject("errorMsg", "회원정보가 일치하지 않습니다.");
			mav.setViewName("/member/login");
			System.out.println("로그인실패");
			return mav;
		}
	}

	/*
	 * 로그아웃
	 */
	@PostMapping("member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "../../index";
	}


}