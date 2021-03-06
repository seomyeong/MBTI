package com.mycompany.myapp.cultureBoard.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.cultureBoard.dao.CultureCommunityDao;
import com.mycompany.myapp.domain.CultureBoard;
import com.mycompany.myapp.domain.CultureBoardComment;
import com.mycompany.myapp.domain.Member;



@Service
public class CultureCommunityService {
	@Autowired
	CultureCommunityDao cultureCommunityDao;
	
	
	public List<CultureBoard> findFirstContents(){
		return cultureCommunityDao.findFirstContents();
	}
	
	
	public List<CultureBoard> findCultureContents(String contentType){
		return cultureCommunityDao.findCultureContents(contentType);
	}
	
	public List<CultureBoard> findMbtiContents(String mbtiValue, String contentType){
		return cultureCommunityDao.findMbtiContents(mbtiValue, contentType);
		
	}


	public Boolean isLike(long loginId, long boardId) {
		return cultureCommunityDao.isLike(loginId, boardId);
	}
	
	
	public long likePoint(long boardId) {
		cultureCommunityDao.likePoint(boardId);
		return cultureCommunityDao.findLikesByBoardId(boardId);
	}
	
	public long unlikePoint(long boardId) {
		cultureCommunityDao.unlikePoint(boardId);
		return cultureCommunityDao.findLikesByBoardId(boardId);
	}


	public void addLikePoint(long loginId, long boardId) {
		cultureCommunityDao.addLikePoint(loginId, boardId);
		
	}
	
	public void removeLikePoint(long loginId, long boardId) {
		cultureCommunityDao.removeLikePoint(loginId, boardId);
		
	}


	public Member findMemberByMemberId(Long loginId) {
		return cultureCommunityDao.findMemberByMemberId(loginId);
	}


	public String findCultureContentsByNicknameContent(String nickName, String content02) {
		return cultureCommunityDao.findCultureContentsByNicknameContent(nickName, content02);
	}
	
	
	public void addWrittenContent(long memberId,String contents01, String contents02, char contentType, String title, String link) {
		// ????????? ???????????? ??????
		cultureCommunityDao.addWrittenContent(memberId, contents01, contents02, contentType, title, link);
		
		// ?????? ????????? ??? ????????? ??? ????????? ??????
		cultureCommunityDao.addCultureContentsCount(memberId);
		
		// ?????? ????????? ??????????????? 
		Member m = cultureCommunityDao.findMemberByMemberId(memberId);
		// 50??? ????????? ?????? ??????.
		m.calcContentsPoint();
		
		// ????????? ??? ???????????? ????????? ?????? ????????? ?????? ?????? ???????????? ???????????? ??????
		cultureCommunityDao.plusMab(m.getId(), m.getMabPoint());
		
		//?????? ??????
		this.resultLevel(m);
		
	}
	
	
	
	//////////////?????? ??????///////////////
	//????????? ??????
	public List<CultureBoard> findLikesOrderByType(String contentType){
		return cultureCommunityDao.findLikesOrderByType(contentType);
	}


	public List<CultureBoard> findLikesOrderByTypeMbti(String contentType, String mbtiValue) {
		return cultureCommunityDao.findLikesOrderByTypeMbti(contentType, mbtiValue);
	}
	
	/////?????? ?????? ??? ?????? ??? ????????????////////
	
	public List<CultureBoardComment> Saved_findAllCultureBoardComment(Long loginId, Long boardId, String comment){
		cultureCommunityDao.addCultureBoardComment(loginId, boardId, comment);
		cultureCommunityDao.addCommentNum(boardId);
		cultureCommunityDao.addCommentCount(loginId);
		
		Member member = cultureCommunityDao.findMemberByMemberId(loginId);
		member.calcCommentsPoint();
		cultureCommunityDao.plusMab(member.getId(), member.getMabPoint());
		
		resultLevel(member);
		
		return cultureCommunityDao.findAllCultureBoardCommentByBoardId(boardId);
	}

	//// ??? ????????? ????????? ?????? ?????? ????????? ?????? //////
	public List<CultureBoardComment> findAllCultureBoardComment() {
		return cultureCommunityDao.findAllCultureBoardComment();
	}
	
	//
	public Long findCommentNumByBoardId(Long boardId) {
		return cultureCommunityDao.findCommentNumByBoardId(boardId);
	}
	
	/////////?????? ????????? ?????????//////////////

	public Boolean isLikeForComment(Long loginId, Long commentId) {
		return cultureCommunityDao.isLikeForComment(loginId, commentId);
	}


	public long likePointForComment(Long commentId) {
		cultureCommunityDao.likePointForComment(commentId);
		return cultureCommunityDao.findCommentLikesByCommentId(commentId);
	}


	public void addLikePointForComment(Long loginId, Long commentId) {
		cultureCommunityDao.addLikePointForComment(loginId,commentId);
	}


	public long unlikePointForComment(Long commentId) {
		cultureCommunityDao.unlikePointForComment(commentId);
		return cultureCommunityDao.findCommentLikesByCommentId(commentId);
	}


	public void removeLikePointForComment(Long loginId, Long commentId) {
		cultureCommunityDao.removeLikePointForComment(loginId,commentId);	
	}

	
	
	//////////////?????? ?????? ????????? ////////////

	public List<CultureBoardComment> deleteComment(Long loginId, Long boardId, Long commentId) {
		cultureCommunityDao.deleteComment(commentId);
		cultureCommunityDao.discountCommentNum(boardId);
		cultureCommunityDao.deleteCommentsCount(loginId);
		cultureCommunityDao.removeLikeCommentPoint(loginId, commentId);
		return cultureCommunityDao.findAllCultureBoardCommentByBoardId(boardId);
	}

	
	/**
	 * 
	 *  ?????? ?????? ??? ?????? ?????????
	 * 
	 * @param contentType
	 * @return List<CultureBoard>
	 */

	public List<CultureBoard> findCommentsOrderByType(String contentType) {
		
		return cultureCommunityDao.findCommentOrderByType(contentType);
	}


	public List<CultureBoard> findCommentsOrderByTypeMbti(String contentType, String mbtiValue) {
		return cultureCommunityDao.findCommentsOrderByTypeMbti(contentType, mbtiValue);
	}

	
	
	/**
	 * 
	 * 
	 * 
	 * @param m
	 */
	public void resultLevel(Member m) {
		int maxExp = 1000;
		int mab = m.getMabPoint();
		int levelUp = mab / maxExp;
	
		if(levelUp != 0) {
			
			//????????? ??? ?????? ??????
			cultureCommunityDao.resultLevel(m.getId(), levelUp);
			//????????? ??? ???????????? ?????????
			cultureCommunityDao.levelUpAfterMab(m.getId(), levelUp * maxExp);			
		}
	}

	
	/**
	 * 
	 * ?????? ????????? ???????????? ?????? ?????????,?????? ???????????? ?????? ????????? ????????????
	 * (?????? ????????? ????????? ??? ????????? ???????????? ?????????)
	 * 
	 * @param loginId
	 * @return
	 */


	public List<CultureBoard> findLikesContentByMemberId(Long loginId) {
		List<Long> likeContentsId = new ArrayList<Long>();
		List<CultureBoard> likeContents = new ArrayList<CultureBoard>();
		likeContentsId = cultureCommunityDao.findLikesContentIdByMemberId(loginId);
		
		Iterator<Long> it = likeContentsId.iterator();
		while(it.hasNext()) {
			Long likeConId = it.next();
			
			likeContents.add(cultureCommunityDao.findCultureBoardByBoardId(likeConId));
		}
		
		return likeContents;
	}


	public List<CultureBoardComment> findLikesCommentByMemberId(Long loginId) {
		List<Long> likeCommentsId = new ArrayList<Long>();
		List<CultureBoardComment> likeComments = new ArrayList<CultureBoardComment>();
		likeCommentsId = cultureCommunityDao.findLikesCommentByMemberId(loginId);
	
		
		Iterator<Long> it = likeCommentsId.iterator();
		while(it.hasNext()) {
			Long likeCommentId = it.next();
			likeComments.add(cultureCommunityDao.findCultureBoardCommentByCommentId(likeCommentId));
		}
		
		return likeComments;
	}	
}
