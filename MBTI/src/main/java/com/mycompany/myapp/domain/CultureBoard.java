package com.mycompany.myapp.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CultureBoard {
	private long id;
	private Member member;
	private String title01;
	private String title02;
	private char contentType;
	private String contents;
	private Date reportingDate;
	private int likes;
	private String link;
}
