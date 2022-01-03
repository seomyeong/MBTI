package com.mycompany.myapp.community.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainCommunityController {
//	@Autowired
//	CommunityService communityService;
	
//	@GetMapping("community/mainCommunity")
//	public ModelAndView getMainCommunity() {
//		ModelAndView mav = new ModelAndView();
//		
//		List<CommunityBoard> cbList = new ArrayList<CommunityBoard>();
//		
//		cbList = communityService.findAllContents();
//		
//		
//		return mav;
//	}
	
	@GetMapping("community/mainCommunity")
	public String getMainCommunity() {
		return "community/mainCommunity";
	}
	
//	@PostMapping("community/mainCommunity")
//	public ModelAndView postMainCommunity(@RequestBody Map<String, Object> param) {
//		String mbti = (String)param.get("type01") + param.get("type02") + param.get("type03") + param.get("type04");
//		System.out.println(mbti);
//		
//		ModelAndView mav = new ModelAndView();
//		
//		mav.addObject("mbti", mbti);
//		mav.setViewName("/community/mainCommunity");
//		
////		PrintWriter out = response.getWriter();
////        JSONObject mbtiInfo = new JSONObject();
////        
////        mbtiInfo.put("mbti", mbti);
////        
////        out.print(mbtiInfo);
//		
//		return mav;
//	}
	
	@ResponseBody
	@PostMapping("community/mainCommunity")
	public Map<String,String> ajaxMainCommunity(@RequestBody Map<String, String> param) {
		String view = "";
		
		Iterator<String> keys = param.keySet().iterator();
		while(keys.hasNext()) {
			String strKey = keys.next();
			String strValue = param.get(strKey);
			view = view.concat(strValue);
		}
		
		System.out.println(view);
		
		Map<String,String> map = new HashMap<String,String>();
	    map.put("view",view);
	    
		return map;
	}
}
