package com.mycompany.myapp.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MbtiPlayContents {
	private long id;
	private List<MemberChoice> memberChoice;
	private String question;
	private String answer01;
	private String answer02;
	private String answer03;
	private String answer04;
}
