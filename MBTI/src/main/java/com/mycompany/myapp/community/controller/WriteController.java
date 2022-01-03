package com.mycompany.myapp.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.myapp.community.service.CommunityService;

@Controller
public class WriteController {
	@Autowired
	CommunityService communityService;
	
	@GetMapping("/community/write")
	public String write() {
		return "/community/write";
	}
}
