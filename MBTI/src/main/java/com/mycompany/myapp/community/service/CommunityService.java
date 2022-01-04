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
	
}
