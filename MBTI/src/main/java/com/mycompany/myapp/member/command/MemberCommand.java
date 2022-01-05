package com.mycompany.myapp.member.command;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberCommand {
	private long id;
	private String email;
	private String pw;
	private String name;
	private String nickName;
	private String birth;
	private String mbti;
	private String gender;
	private String phone;
	private Date regDate;
	private int level;
	private int mabPoint;
	private String profileImg;
	private int contentsCount;
	private int commentsCount;
	
	public MemberCommand() {}

	public MemberCommand(String email, String pw, String name, String nickName, String birth, String mbti, String gender,
			String phone) {
		super();
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.nickName = nickName;
		this.birth = birth;
		this.mbti = mbti;
		this.gender = gender;
		this.phone = phone;
	}
	
	
}
