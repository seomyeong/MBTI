package com.mycompany.myapp.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.mycompany.myapp.domain.CommunityComments;
import com.mycompany.myapp.domain.CommunityCommentsPlus;
import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.domain.PagingVO;

@Controller
public class BoardController {
	@Autowired
	CommunityService communityService;

	/*
	 * board GetMapping
	 */
	@GetMapping("/community/board")
	public ModelAndView write(@RequestParam String boardId, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// 조회수 올리기
		communityService.viewPoint(Long.parseLong(boardId));

		CommunityBoard cb = communityService.findBoardByBoardId(Long.parseLong(boardId));
		List<CommunityComments> cc = communityService.findCommentsByBoardId(Long.parseLong(boardId));
		List<CommunityCommentsPlus> ccp = communityService.findCommentsPlusByBoardId(Long.parseLong(boardId));
		
		// 로그인 아이디의 정보를 들고온다.
		Long loginId;
		Member loginMemberInfo = null;

		if (!(session == null || session.getAttribute("loginId") == null
				|| session.getAttribute("loginId").equals(""))) {
			loginId = Long.parseLong(String.valueOf(session.getAttribute("loginId")));
			loginMemberInfo = communityService.findMemberByMemberId(loginId);
		}
		// 댓글 수 가져오기
		cb.setCommentsCount(cc.size() + ccp.size());

		mav.addObject("loginMemberInfo", loginMemberInfo);
		mav.addObject("board", cb);
		mav.addObject("comments", cc);
		mav.addObject("commentsPlus", ccp);
		mav.setViewName("/community/board");

		return mav;
	}
	
	/*
	 * 댓글 작성시
	 */
	@ResponseBody
	@PostMapping("community/addComment")
	public Map<String, String> ajaxAddComment(@RequestBody Map<String, String> param) {
		Long loginId = Long.parseLong(param.get("loginId"));
		Long boardId = Long.parseLong(param.get("boardId"));
		String comment = param.get("comment");

		// 댓글 테이블에 할당
		long commentId = communityService.addComment(loginId, boardId, comment);

		System.out.println(param.get("loginId") + param.get("boardId") + param.get("comment"));
		Member loginMember = communityService.findMemberByMemberId(loginId);

		Map<String, String> map = new HashMap<String, String>();
		map.put("mbti", loginMember.getMbti());
		map.put("level", Integer.toString(loginMember.getLevel()));
		map.put("nickName", loginMember.getNickName());
		map.put("comment", comment);
		map.put("commentId", Long.toString(commentId));
		
		return map;
	}

	/*
	 * 게시물 삭제시
	 */
	@GetMapping("/community/deleteBoard")
	public String deleteBoard(@RequestParam String boardId, HttpSession session) {

		String type = session.getAttribute("type").equals("") ? "" : (String) session.getAttribute("type");
		String q = session.getAttribute("q").equals("") ? "" : (String) session.getAttribute("q");
		PagingVO pagingVO = (PagingVO) session.getAttribute("pagingVO");
		String page = pagingVO.getPage() == 1 ? "1" : Integer.toString(pagingVO.getPage());
		String range = pagingVO.getRange() == 1 ? "1" : Integer.toString(pagingVO.getRange());
		
		System.out.println(type + ", " + q + ", " + page + ", " + range);
		
		CommunityBoard cb = communityService.findBoardByBoardId(Long.parseLong(boardId));
		communityService.deleteBoard(cb.getMember().getId(), boardId);
		
		return "redirect:/community/mainCommunity?type=" + type + "&q=" + q + "&page=" + page + "&range=" + range;
	}
	
	/*
	 * 댓글 삭제시
	 */
	@ResponseBody
	@PostMapping("/community/deleteComment")
	public void deleteComment(@RequestBody Map<String, String> param) {
		System.out.println("삭제할 댓글 ID : " + param.get("commentId"));
		
		String boardId = param.get("boardId");
		String commentId = param.get("commentId");
		
		CommunityComments cc = communityService.findCommentByCommentId(Long.parseLong(commentId));
		
		
		communityService.deleteComment(cc.getMember().getId(), Long.parseLong(boardId), Long.parseLong(commentId));
		
	}

	/*
	 * 대댓글 작성시
	 */
	@ResponseBody
	@PostMapping("/community/addPlusComment")
	public void addPlusComment(@RequestBody Map<String, String> param) {
		Long boardId = Long.parseLong(param.get("boardId"));
		Long commentId = Long.parseLong(param.get("commentId"));
		Long memberId = Long.parseLong(param.get("memberId"));
		String comments = param.get("comments");
		
		communityService.addPlusComment(boardId, commentId, memberId, comments);
	}

	/*
	 * 대댓글 삭제시
	 */
	@ResponseBody
	@PostMapping("/community/deletePlusComment")
	public void deletePlusComment(@RequestBody Map<String, String> param) {
		
		String boardId = param.get("boardId");
		String plusCommentId = param.get("plusCommentId");
		CommunityCommentsPlus ccp = communityService.findCommentPlusByPlusCommentId(plusCommentId);
		
		communityService.deletePlusComment(ccp.getMember().getId(), Long.parseLong(boardId), Long.parseLong(plusCommentId));
		
	}
	
	/*
	 * 추천시
	 */
	@ResponseBody
	@PostMapping("community/likes")
	public Map<String, String> ajaxWrite(@RequestBody Map<String, String> param) {
		String loginId = param.get("loginId");
		String boardId = param.get("boardId");
		String nowLikes = null;

		// 추천이 눌려있으면 true 안눌려있으면 false
		Boolean likeCheck = communityService.isLike(Long.parseLong(loginId), Long.parseLong(boardId));

		// 해당 게시물에 추천을 눌렀었는지 확인
		if (!(likeCheck) || loginId.equals("1")) {
			// 누른 로그가 없다면 추천올리기
			nowLikes = Long.toString(communityService.likePoint(Long.parseLong(boardId)));
			communityService.addlikePoint(Long.parseLong(loginId), Long.parseLong(boardId));
		}
		
		if(loginId.equals("1")) {
			likeCheck = false;
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("likes", nowLikes);
		map.put("likeCheck", String.valueOf(likeCheck));

		return map;
	}
	
	/*
	 * 실시간 추천
	 */
	@ResponseBody
	@PostMapping("/community/liveLikes")
	public Map<String, String> liveLikes(@RequestBody Map<String, String> param) {
		
		String boardId = param.get("boardId");
		
		CommunityBoard cb = communityService.findBoardByBoardId(Long.parseLong(boardId));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("likes", Integer.toString(cb.getLikes()));
		
		return map;		
	}
}
