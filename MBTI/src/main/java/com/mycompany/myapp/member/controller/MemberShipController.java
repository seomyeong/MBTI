package com.mycompany.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import a.b.c.domain.MemberShip;
import a.b.c.service.MemberShipService;

@Controller
public class MemberShipController {
	@Autowired
	MemberShipService memberShipService;

	/*
	 * memberShip 가입 기능
	 * session이 가지고 있는 userId를 불러와서
	 * MEMBERSHIP 테이블에 INSERT 시킨다.
	 */

	@PostMapping("/pointService/pointShop")
	public String pointShop(MemberShip ms, HttpSession session) {
			Object memberInfo = session.getAttribute("memberInfo");
			System.out.println(memberInfo);

			Long Id = (long) session.getAttribute("Id");
			System.out.println(Id);
			memberShipService.addMemberShip(ms);
		return "pointService/pointShop";
	}

}
