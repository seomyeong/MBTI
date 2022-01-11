package com.mycompany.myapp.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String addMember(@ModelAttribute MemberCommand memberCommand) {
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
		String email = memberCommand.getEmail1() + memberCommand.getEmail2();
		String phone = memberCommand.getPhone1() + memberCommand.getPhone2();
		Member member = new Member(email, memberCommand.getPw(), memberCommand.getName(),
				memberCommand.getNickName(), memberCommand.getBirth(), memberCommand.getMbti(),
				memberCommand.getGender(), phone);

		memberService.addMember(member);
		System.out.println("회원가입성공");
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

		if (memberService.login(member)) {
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

		} else {
			mav.addObject("errorMsg", "회원정보가 일치하지 않습니다.");
			mav.setViewName("/member/login");
			System.out.println("로그인실패");
			return mav;
		}
	}

	/*
	 * 로그아웃
	 */
	@GetMapping("/member/logout")
	public String logoutMainGET(HttpSession session) throws Exception {

//		session.getAttribute("loginId");
//		session.invalidate();
		session.removeAttribute("loginId");

		System.out.println("로그아웃");
		return "redirect:/index";
	}
	
	
	
	/*
	 * 회원가입 중복체크
	 */
	@ResponseBody
	@PostMapping("/member/emailCheck")
	public Map<String, String> isEmailCheck(@RequestBody Map<String, String> param) {
		System.out.println("email입력 : " + param.get("email"));
		String msg = "";
		String email = param.get("email");
		String email1 = param.get("email1");
		
		if(memberService.isEmailCheck(email)) {
			if ( email1.length() > 4 ) {
				msg = "사용가능한 이메일입니다!";
			} else { 
				msg = "5~20자로 설정해주세요.";
			}
			
		} else if(email1.equals(null) || email1 == "") {
			msg = "";
		} else {
			msg = "중복되는 이메일이 존재합니다.";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", msg);
		map.put("email1", email1);

		return map;
	}
	
	@ResponseBody
	@PostMapping("/member/nickNameCheck")
	public Map<String, String> isNickCheck(@RequestBody Map<String, String> param) {
		System.out.println("nickName입력 : " + param.get("nickName"));

		String msg = "";
		String nickName = param.get("nickName");
		
		if(memberService.isNickNameCheck(nickName)) {
			msg = "사용가능한 닉네임입니다.";
		} else {
			msg = "중복되는 닉네임 존재합니다.";
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", msg);
		map.put("nickName", nickName);

		return map;
	}
	


	

}