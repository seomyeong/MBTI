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
	gender 			CHAR		NOT NULL,
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

INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종', '처음왔어요 반갑습니다.', '안녕하세요 잘 부탁드립니다.');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종1', '처음왔어요 반갑습니다.1', '안녕하세요 잘 부탁드립니다.1');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종2', '처음왔어요 반갑습니다.2', '안녕하세요 잘 부탁드립니다.2');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종3', '처음왔어요 반갑습니다.3', '안녕하세요 잘 부탁드립니다.3');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종4', '처음왔어요 반갑습니다.4', '안녕하세요 잘 부탁드립니다.4');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종5', '처음왔어요 반갑습니다.5', '안녕하세요 잘 부탁드립니다.5');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종6', '처음왔어요 반갑습니다.6', '안녕하세요 잘 부탁드립니다.6');
INSERT INTO CommunityBoard(memberNickName, title, contents) VALUES('종성성종7', '처음왔어요 반갑습니다.7', '안녕하세요 잘 부탁드립니다.7');

CREATE TABLE CommunityBoard(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberNickName	VARCHAR(30)		NOT NULL, -- 참조
	title			VARCHAR(100)	NOT NULL,
	contents		VARCHAR(1000)	NOT NULL,
	reportingDate	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	views			INT				DEFAULT 0,
	likes			INT				DEFAULT 0,
	commentsCount 	INT				DEFAULT 0
);