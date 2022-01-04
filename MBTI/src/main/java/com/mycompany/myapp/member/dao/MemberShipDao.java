package com.mycompany.myapp.member.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import a.b.c.domain.MemberShip;

@Component
public class MemberShipDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//멤버쉽 가입
	public void addMemberShip(MemberShip ms) {
		String sql = "INSERT INTO MEMBERSHIP (memberId, memberPoint) VALUES (?,?) WHERE memberId=?";
		jdbcTemplate.update(sql, ms.getMember().getId(), ms.getMemberPoint());

	}

}
