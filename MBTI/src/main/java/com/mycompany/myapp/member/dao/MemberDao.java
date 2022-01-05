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

	//회원가입
	public void addMember(Member member) {
		String sql = "INSERT INTO MEMBER(email, pw, name, nickName, birth, mbti, gender, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, member.getEmail(), member.getPw(), member.getName(), member.getNickName(), 
				member.getBirth(), member.getMbti(), member.getGender(), member.getPhone());
	}

	//회원정보 조회
	public Member memberInfo(Member member) {
		String sql = "SELECT * FROM MEMBER WHERE email = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Member(rs.getLong("id"),rs.getString("email"), rs.getString("pw"), rs.getString("name"), 
						rs.getString("nickname"), rs.getString("birth"), rs.getString("mbti"), 
						rs.getString("gender").charAt(0), rs.getString("phone"), rs.getTimestamp("regDate"));
			}

		}, member.getEmail());
	}

	//로그인			
	public boolean login(Member member) {
		String sql = "SELECT * FROM MEMBER WHERE email = ? AND pw = ?";
		List<Member> memberCheck = null;
		memberCheck = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getLong("id"),rs.getString("email"), rs.getString("pw"), rs.getString("name"), 
						rs.getString("nickname"), rs.getString("birth"), rs.getString("mbti"), 
						rs.getString("gender").charAt(0), rs.getString("phone"), rs.getTimestamp("regDate"));
				return member;
			}

		}, member.getEmail(), member.getPw());

		if(memberCheck.size()==0) {
			return false;
		}
		return true;
	}


}
