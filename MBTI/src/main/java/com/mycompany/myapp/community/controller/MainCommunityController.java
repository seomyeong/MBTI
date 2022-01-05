package com.mycompany.myapp.community.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.community.service.CommunityService;
import com.mycompany.myapp.domain.CommunityBoard;

@Controller
public class MainCommunityController {
	@Autowired
	CommunityService communityService;

	@GetMapping("community/mainCommunity")
	public ModelAndView getMainCommunity() {
		ModelAndView mav = new ModelAndView();

		List<CommunityBoard> cbList = new ArrayList<CommunityBoard>();

		cbList = communityService.findAllContents();

		mav.addObject("cbList", cbList);
		mav.setViewName("community/mainCommunity");

		return mav;
	}

	@ResponseBody
	@PostMapping("community/mainCommunity")
	public Map<String, String> ajaxMainCommunity(@RequestBody Map<String, String> param) {
		String view = "";

		Iterator<String> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String strKey = keys.next();
			String strValue = param.get(strKey);
			view = view.concat(strValue);
		}

		System.out.println(view);

		Map<String, String> map = new HashMap<String, String>();
		map.put("view", view);

		return map;
	}

	
}
