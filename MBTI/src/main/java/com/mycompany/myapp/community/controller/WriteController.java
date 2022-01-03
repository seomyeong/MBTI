package com.mycompany.myapp.community.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.community.service.CommunityService;
import com.mycompany.myapp.domain.CommunityBoard;

@Controller
public class WriteController {
	@Autowired
	CommunityService communityService;
	
	@GetMapping("/community/write")
	public ModelAndView write(@RequestParam String boardId) {
		ModelAndView mav = new ModelAndView();
		
		// 조회수 올리기
		communityService.viewPoint(Long.parseLong(boardId));
		
		CommunityBoard cb = communityService.findBoardByBoardId(Long.parseLong(boardId));
		mav.addObject("board", cb);
		mav.setViewName("/community/write");
		
		return mav;
	}
	
	@ResponseBody
	@PostMapping("community/likes")
	public Map<String, String> ajaxWrite(@RequestBody Map<String, String> param) {
		String boardId = param.get("id");
		String nowLikes = null;
		
		// 추천수 올리기
		nowLikes = Long.toString(communityService.likePoint(Long.parseLong(boardId)));
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("likes", nowLikes);
		
		return map;
	}
}