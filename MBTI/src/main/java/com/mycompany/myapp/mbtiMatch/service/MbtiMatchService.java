package com.mycompany.myapp.mbtiMatch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.MbtiComments;
import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.mbtiMatch.dao.MbtiMatchDao;

@Service
public class MbtiMatchService {

	@Autowired
	MbtiMatchDao dao;

	/*
	 * 사용자id를 통해 mbti정보를 가져오는 메소드
	 */
	public Member findMemberInfoById(Long loginId) {
		return dao.findMemberInfoById(loginId);
	}

	/*
	 * mbti궁합 결과 가져오는 메소드
	 */
	public int findResultByMbtiTypes(String type01, String type02) {
		return dao.findResultByMbtiTypes(type01, type02);
	}

	/*
	 * type01, type02로 mbtiComments 정보 찾아오는 메소드.
	 */
	public List<MbtiComments> findMcInfoByType(String type01, String type02) {
		return dao.findMcInfoByType(type01, type02);
	}

	public void addComment(Long loginId, String type01, String type02, String comment) {
		dao.addComment(loginId, type01, type02, comment);
	}

}
