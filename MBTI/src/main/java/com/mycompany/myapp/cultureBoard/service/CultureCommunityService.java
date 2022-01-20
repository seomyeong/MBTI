package com.mycompany.myapp.cultureBoard.service;

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
		cultureCommunityDao.addWrittenContent(memberId, contents01, contents02, contentType, title, link);
	}
	
	
	
	//////////////댓글 부분///////////////
	//추천순 조회
	public List<CultureBoard> findLikesOrderByType(String contentType){
		return cultureCommunityDao.findLikesOrderByType(contentType);
	}


	public List<CultureBoard> findLikesOrderByTypeMbti(String contentType, String mbtiValue) {
		return cultureCommunityDao.findLikesOrderByTypeMbti(contentType, mbtiValue);
	}
	
	/////댓글 저장 및 조회 및 갯수증가////////
	
	public List<CultureBoardComment> Saved_findAllCultureBoardComment(Long loginId, Long boardId, String comment){
		cultureCommunityDao.addCultureBoardComment(loginId, boardId, comment);
		cultureCommunityDao.addCommentNum(boardId);
		return cultureCommunityDao.findAllCultureBoardCommentByBoardId(boardId);
	}

	//// 첫 페이지 진입시 전체 댓글 리스트 출력 //////
	public List<CultureBoardComment> findAllCultureBoardComment() {
		return cultureCommunityDao.findAllCultureBoardComment();
	}
	
	//
	public Long findCommentNumByBoardId(Long boardId) {
		return cultureCommunityDao.findCommentNumByBoardId(boardId);
	}
	
	/////////댓글 좋아요 서비스//////////////

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

	
	
	//////////////댓글 삭제 서비스 ////////////

	public List<CultureBoardComment> deleteComment(Long loginId, Long boardId, Long commentId) {
		cultureCommunityDao.deleteComment(commentId);
		cultureCommunityDao.discountCommentNum(boardId);
		cultureCommunityDao.removeLikeCommentPoint(loginId, commentId);
		return cultureCommunityDao.findAllCultureBoardCommentByBoardId(boardId);
	}

	
	/**
	 * 
	 *  댓글 많은 순 출력 서비스
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



	
	
	
	
	
	
	
}
