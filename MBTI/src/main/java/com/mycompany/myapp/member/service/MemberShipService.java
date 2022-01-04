package com.mycompany.myapp.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import a.b.c.dao.MemberShipDao;
import a.b.c.domain.MemberShip;

@Service
public class MemberShipService {
	@Autowired
	MemberShipDao memberShipDao;

	public void addMemberShip(MemberShip ms) {
		memberShipDao.addMemberShip(ms);
	}
}
