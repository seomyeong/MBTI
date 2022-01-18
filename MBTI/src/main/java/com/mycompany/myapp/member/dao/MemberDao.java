package com.mycompany.myapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.domain.Member;

@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 회원가입
	public void addMember(Member member) {
		String sql = "INSERT INTO MEMBER(email, pw, name, nickName, birth, mbti, gender, phone, profileImg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, member.getEmail(), member.getPw(), member.getName(), member.getNickName(),
				member.getBirth(), member.getMbti(), member.getGender(), member.getPhone(), member.getProfileImg());
	}

	// 회원정보 조회
	public Member memberInfo(Member member) {
		String sql = "SELECT * FROM MEMBER WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Member(rs.getLong("id"), rs.getString("email"), rs.getString("pw"), rs.getString("name"),
						rs.getString("nickname"), rs.getString("birth"), rs.getString("mbti"), rs.getString("gender"),
						rs.getString("phone"), rs.getTimestamp("regDate"), rs.getInt("level"), rs.getInt("mabPoint"), rs.getString("profileImg"), rs.getInt("contentsCount"), rs.getInt("commentsCount"));
			}

		}, member.getEmail());
	}
	
	// 회원정보 수정
	public void updateMember(Member member, long loginId) {
		String sql = "UPDATE MEMBER SET email=?, pw=?, name=?, nickName=?, birth=?, mbti=?, gender=?, phone=?, profileImg=? WHERE id=?";
		jdbcTemplate.update(sql, member.getEmail(), member.getPw(), member.getName(), member.getNickName(),
				member.getBirth(), member.getMbti(), member.getGender(), member.getPhone(), member.getProfileImg(), loginId);
	}
	
	
	
	// 로그인
	public boolean login(Member member) {
		String sql = "SELECT * FROM MEMBER WHERE email = ? AND pw = ?";
		List<Member> memberCheck = null;
		memberCheck = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getLong("id"), rs.getString("email"), rs.getString("pw"),
						rs.getString("name"), rs.getString("nickname"), rs.getString("birth"), rs.getString("mbti"),
						rs.getString("gender"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return member;
			}

		}, member.getEmail(), member.getPw());

		if (memberCheck.size() == 0) {
			return false;
		}
		return true;
	}

	
	
	//이메일 중복검사
	public boolean isEmailCheck(String email) {
		String sql = "SELECT * FROM Member WHERE email=?";
		List<Member> list = null;
		list = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Member();
			}
			
		}, email);
		
		
		if(list == null || list.equals(null) || list.size() == 0) {
			return true;
		}
		
		return false;
	}

	// 닉네임 중복검사
	public boolean isNickNameCheck(String nickName) {
		String sql = "SELECT * FROM Member WHERE nickName=?";
		List<Member> list = null;
		list = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Member();
			}
			
		}, nickName);
		
		
		if(list == null || list.equals(null) || list.size() == 0) {
			return true;
		}
		
		return false;
	}

}
