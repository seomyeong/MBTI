package com.mycompany.myapp.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.community.dao.CommunityDao;
import com.mycompany.myapp.domain.CommunityBoard;

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
	
}