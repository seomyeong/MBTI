package com.mycompany.myapp.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CommunityBoard {
	private long id;
	private String title;
	private Member member;
	private String contents;
	private List<CommunityComments> comments;
	private Date reportingDate;
	private int views;
	private int likes;
	private int commentsCount;
}
