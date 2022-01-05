package com.mycompany.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.member.command.MemberCommand;
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
	public ModelAndView successAddMember(MemberCommand memberCommand) {
		ModelAndView mav = new ModelAndView();
		Member member = new Member(memberCommand.getEmail(), memberCommand.getPw(), memberCommand.getName(),memberCommand.getNickName(),
				memberCommand.getBirth(), memberCommand.getMbti(), memberCommand.getGender(), memberCommand.getPhone());
		
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

//			session.setAttribute("memberInfo", memberInfo);
//			session.setAttribute("email", memberInfo.getEmail());
			// 세션에 id 값 할당
			System.out.println("loginId : " + memberInfo.getId());
			session.setAttribute("loginId", memberInfo.getId());
			session.setMaxInactiveInterval(-1);
			mav.setViewName("redirect:/index");
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