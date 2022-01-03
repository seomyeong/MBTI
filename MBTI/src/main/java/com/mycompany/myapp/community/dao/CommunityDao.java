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
				CommunityBoard cb = new CommunityBoard(rs.getString("memberNickName"), rs.getString("title"), rs.getString("contents"), fmt.format(rs.getTimestamp("reportingDate")), rs.getInt("views"), rs.getInt("likes"), rs.getInt("commentsCount"));
				
				return cb;
			}
			
		});
	}
}

