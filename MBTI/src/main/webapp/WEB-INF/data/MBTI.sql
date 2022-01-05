SELECT * FROM MEMBER;
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
	id				BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	email 			VARCHAR(50)	NOT NULL,
	pw 				VARCHAR(20)	NOT NULL,
	name 			VARCHAR(30)	NOT NULL,
	nickName 		VARCHAR(30)	NOT NULL,
	birth 			VARCHAR(20) NOT NULL,
	mbti 			VARCHAR(4)	NOT NULL,
	gender 			CHAR(1)		NOT NULL,
	phone 			VARCHAR(13) NOT NULL,
	regDate 		TIMESTAMP 	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	level 			INT 		DEFAULT 1,
	mabPoint 		INT 		DEFAULT 0,
	profileImg 		VARCHAR(100) DEFAULT '',
	contentsCount 	INT DEFAULT 0,
	commentsCount 	INT DEFAULT 0
);

-- Community

SELECT * FROM CommunityBoard;
DROP TABLE CommunityBoard;

INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('ydh1178@naver.com', '1234', '김종성', '종성성종', '961124', 'M', 'ISFJ', '010-8599-7622');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('test@test.com', '1234', '테스트계정', '테스트계정', '001122', 'W', 'ENFP', '010-1111-2222');

INSERT INTO CommunityBoard(memberId, title, contents) VALUES(1, '처음왔어요 반갑습니다.', '안녕하세요 잘 부탁드립니다.');
INSERT INTO CommunityBoard(memberId, title, contents) VALUES(2, '테스트입니다.', '테스트중입니다.');

CREATE TABLE CommunityBoard(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberId		BIGINT			NOT NULL,
	title			VARCHAR(100)	NOT NULL,
	contents		VARCHAR(1000)	NOT NULL,
	reportingDate	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	views			INT				DEFAULT 0,
	likes			INT				DEFAULT 0,
	commentsCount 	INT				DEFAULT 0
);