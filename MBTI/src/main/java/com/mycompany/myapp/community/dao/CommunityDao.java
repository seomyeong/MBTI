package com.mycompany.myapp.community.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.domain.CommunityBoard;
import com.mycompany.myapp.domain.Member;


@Component
public class CommunityDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<CommunityBoard> findAllContents() {
		String sql = "SELECT * FROM CommunityBoard";
		
		return jdbcTemplate.query(sql, new RowMapper<CommunityBoard>() {

			@Override
			public CommunityBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				Member member = null;
				
				member = findMemberByMemberId(rs.getLong("memberId"));
				
				CommunityBoard cb = new CommunityBoard(rs.getString("title"), rs.getString("contents"), fmt.format(rs.getTimestamp("reportingDate")), rs.getInt("views"), rs.getInt("likes"), rs.getInt("commentsCount"));
				cb.setMember(member);
				
				return cb;
			}
			
		});
	}
	
	public Member findMemberByMemberId(Long memberId) {
		String sql = "SELECT * FROM Member WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m = new Member(rs.getLong("id"),rs.getString("email"), rs.getString("pw"), rs.getString("name"), rs.getString("nickName"), rs.getString("birth"), rs.getString("mbti"),
						rs.getString("gender").charAt(0), rs.getString("phone"), rs.getDate("regDate"), rs.getInt("level"), rs.getInt("mabPoint"), rs.getString("profileImg"), rs.getInt("contentsCount"),
						rs.getInt("commentsCount"));
				return m;
			}
			
		}, memberId);
	}
}
