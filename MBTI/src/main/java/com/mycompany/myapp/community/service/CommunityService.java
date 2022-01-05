package com.mycompany.myapp.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.community.dao.CommunityDao;
import com.mycompany.myapp.domain.CommunityBoard;
import com.mycompany.myapp.domain.CommunityComments;
import com.mycompany.myapp.domain.Member;

@Service
public class CommunityService {
	@Autowired
	CommunityDao communityDao;
	
	public List<CommunityBoard> findAllContents(){
		return communityDao.findAllContents();
	}

	public CommunityBoard findBoardByBoardId(long parseLong) {
		return communityDao.findBoardByBoardId(parseLong);
	}

	public void viewPoint(long boardId) {
		communityDao.viewPoint(boardId);
	}

	public Long likePoint(long boardId) {
		communityDao.likePoint(boardId);
		// 증가 후 현재 추천 수 반환
		return communityDao.findLikesByBoardId(boardId);
	}

	public List<CommunityComments> findCommentsByBoardId(long boardId) {
		return communityDao.findCommentsByBoardId(boardId);
	}

	public void addCommunityBoard(Long loginId, String title, String contents) {
		communityDao.addCommunityBoard(loginId, title, contents);
	}

	public Member findMemberByMemberId(Long loginId) {
		return communityDao.findMemberByMemberId(loginId);
	}

	public void addComment(long loginId, long boardId, String comment) {
		communityDao.addComment(loginId, boardId, comment);
	}

	public boolean isLike(long loginId, long boardId) {
		return communityDao.isLike(loginId, boardId);
	}

	public void addlikePoint(long loginId, long boardId) {
		communityDao.addLikePoint(loginId, boardId);
	}
	
}
