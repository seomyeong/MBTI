package com.mycompany.myapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MbtiComments {
	private long id;
	private Member member;
	private MbtiMatch mbtiMatch;
	private String comments;
	private Date reportingDate;
}
