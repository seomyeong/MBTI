package com.mycompany.myapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CommunityComments {
	private long id;
	private Member member;
	private String comments;
	private int likes;
	private Date reportingDate;
}
