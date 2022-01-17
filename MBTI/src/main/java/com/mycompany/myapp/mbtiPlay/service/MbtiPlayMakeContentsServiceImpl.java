package com.mycompany.myapp.mbtiPlay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.ContentsLog;
import com.mycompany.myapp.domain.MbtiPlayContents;
import com.mycompany.myapp.domain.MbtiPlayContentsAnswer;
import com.mycompany.myapp.domain.Member;
import com.mycompany.myapp.mbtiPlay.command.MbtiPlayContentsAnswerCommand;
import com.mycompany.myapp.mbtiPlay.command.SubjectiveCountCommand;
import com.mycompany.myapp.mbtiPlay.dao.MbtiPlayMakeContentsDao;

@Service
public class MbtiPlayMakeContentsServiceImpl implements MbtiPlayMakeContentsService {
	@Autowired
	MbtiPlayMakeContentsDao dao;
	
	/*
	 * about Member table
	 */
	
	// Member테이블의 회원정보를 세션id로 조회
	public Member findMemberById(Long loginId) {
		return dao.findMemberById(loginId);
	}
	// 맙티플레이 생성한 멤버에게 맙티포인트 30p 적립
	public void calcQuizPoint(Long loginId) {
		dao.calcQuizPoint(loginId);
	}

	
	
	/*
	 * about MbtiPlayContents table
	 */
	// mbtiPlayMakeContents테이블에 유저가 만든 문답 데이터 추가
	@Override
	public void addContents(long memberId, MbtiPlayContents con) {
		dao.addContent(memberId, con);
	}
	// MbtiPlayContents테이블의 pk수 조회
	public List<MbtiPlayContents> findContentsPk() {
		return dao.findContentsPk();
	}
	// MbtiPlayContents테이블의 문제를 랜덤으로 조회
	public List<MbtiPlayContents> findQuestionByRandomNum(long randomNum) {
		return dao.findQuestionByRandomNum(randomNum);
	}
	
	
	/*
	 * about MbtiPlayContentsAnswer table
	 */

	// MbtiPlayContentsAnswer테이블에 유저가 선택한 객관식 데이터 추가
	public void addAnswer(String memberMbti, Long questionNum, String choosenNum, String isSubjective,
			String subjectiveContent, int choosenNumCount) {
		dao.addAnswer(memberMbti, questionNum, choosenNum, isSubjective, subjectiveContent, choosenNumCount);
	}
	
	// MbtiPlayContentsAnswer테이블의 객관식 보기값 조회
	public MbtiPlayContentsAnswer findObjectiveAnswer(String memberMbti, Long questionNum, String choosenNum) {
		return dao.findObjectiveAnswer(memberMbti, questionNum, choosenNum);
	}

	// MbtiPlayContentsAnswer테이블에 로그인한 유저의 MBTI와 해당 문제번호의 데이터가 있는지 검사
	public boolean isMbtiTypeAndQuestion(String memberMbti, Long questionNum) {
		if (dao.isMbtiTypeAndQuestion(memberMbti, questionNum)) {
			return true;
		} else {
			return false;
		}
	}

	// MbtiPlayContentsAnswer테이블에 객관식 보기에 대한 count를 업데이트
	public void updateObjectiveAnswer(String subjectiveContent, String memberMbti, Long questionNum, String choosenNum, String isSubjective) {
		dao.updateObjectiveAnswer(subjectiveContent, memberMbti, questionNum, choosenNum, isSubjective);
	}
	
	// MbtiPlayContentsAnswer테이블의 해당하는 문제의 주관식답변 수 조회
	public SubjectiveCountCommand findSubCount(Long questionNum) {
		return dao.findSubCount(questionNum);
	}
	
	// MbtiPlayContentsAnswer테이블에 questionNum=?의 주관식 데이터가 있는지 검사
	public boolean isSubjectiveAnswer(Long questionNum) {
		if(dao.isSubjectiveAnswer(questionNum)) {
			return true;
		}else {
			return false;
		}

	}
	
	// MbtiPlayContentsAnswer테이블에 questionNum이 있는지 검사
	public boolean isQuestionNum(long questionNum) {
		if(dao.isQuestionNum(questionNum)) {
			return true;
		}else {
			return false;
		}
	}

	//MbtiPlayContentsAnswer테이블의 모든 주관식 답변 조회
	public List<MbtiPlayContentsAnswerCommand> findAllSubjectiveAnswers(Long questionNum) {
		return dao.findAllSubjectiveAnswers(questionNum);
	}
	
	// MbtiPlayContentsAnswer테이블에 객관식이 풀린 기록이 있는지 검사
	public boolean isObjectiveAnswer(String memberMbti, long questionNum) {
		if(dao.isObjectiveAnswer(memberMbti, questionNum)) {
			return true;
		}else {
			return false;
		}
	}
	

	/*
	 * about Log tables
	 */
	// AnswersLog 테이블에 문답을 풀었는 기록이 있는지 검사
	public boolean isAnswersLog(Long loginId, Long questionNum) {
		if (dao.isAnswersLog(loginId, questionNum)) {
			return true;
		} else {
			return false;
		}
	}

	// AnswersLog테이블에 문답 이력 데이터 추가
	public void addAnswersLog(Long loginId, Long questionNum) {
		dao.addAnswersLog(loginId, questionNum);
	}

	// AnswersLog테이블의 pk수 조회
	public long isAnswerLogSize(long memberId) {
		return dao.isAnswersLogSize(memberId);
	}

	// ContentsLog테이블에 문답 생성이력 데이터 추가
	public void addContentsLog(Long loginId) {
		dao.addContentsLog(loginId);
	}

	// ContentsLog테이블에 문답 생성이력 있는지 검사
	public boolean isContentsLog(Long loginId) {
		if (dao.isContentsLog(loginId)) {
			return true;
		} else {
			return false;
		}
	}

	// 유저가 문답을 만들었을 때 ContentsLog에 찍히는 년-월-일 조회
	public ContentsLog findContentsLogDate(Long loginId) {
		return dao.findContentsLogDate(loginId);
	}

	// ContentsLog 테이블의 contentsCount가 3번인지 검사
	public boolean isContentsLogLimitTime(Long loginId, String nowYear, String nowMonth, String nowDay) {
		if (dao.isContentsLogLimitTime(loginId, nowYear, nowMonth, nowDay)) {
			return true;
		} else {
			return false;
		}
	}

	// ContentsLog 테이블의 contentsCount가 3이 아닐 때 contentsCount++
	public void updateContentsLog(Long loginId, String nowYear, String nowMonth, String nowDay) {
		dao.updateContentsLog(loginId, nowYear, nowMonth, nowDay);
	}

	// ContentsLog테이블에서 조회하는 당일 날짜와 일치하는 log데이터가 있는지 검사
	public boolean isContentsLogDate(Long loginId, String nowYear, String nowMonth, String nowDay) {
		if (dao.isContentsLogDate(loginId, nowYear, nowMonth, nowDay)) {
			return true;
		} else {
			return false;
		}
	}


}
