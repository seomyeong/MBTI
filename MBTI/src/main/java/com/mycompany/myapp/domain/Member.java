package com.mycompany.myapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Member {
	private long id;
	private String email;
	private String pw;
	private String name;
	private String nickName;
	private String birth;
	private String mbti;
	private char gender;
	private String phone;
	private Date regDate;
	private int level;
	private int mabPoint;
	private String profileImg;
	private int contentsCount;
	private int commentsCount;
}
