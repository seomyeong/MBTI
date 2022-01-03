package com.mycompany.myapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MbtiInfo {
	private long id;
	private String mbti;
	private String mbtiTip01;
	private String mbtiTip02;
	private String mbtiTip03;
}
