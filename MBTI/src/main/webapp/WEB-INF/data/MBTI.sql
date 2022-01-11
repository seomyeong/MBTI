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

SELECT * FROM Member;
SELECT * FROM CommunityBoard;
SELECT * FROM CommunityComments;
SELECT * FROM CommunityComments_plus;

UPDATE Member SET level=57 WHERE id=1;
UPDATE Member SET level=38 WHERE id=5;
UPDATE Member SET nickName='에어포스' WHERE id=5;

DROP TABLE Member;
DROP TABLE CommunityBoard;
DROP TABLE CommunityComments;
DROP TABLE CommunityComments_plus;

INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('ydh1178@naver.com', '1234', '김종성', '성종', '961124', 'M', 'ISFJ', '010-8599-7622');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('test@test.com', '1234', '테스트계정', '테스트계정', '001122', 'W', 'ENFP', '010-1111-2222');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('tnals@test.com', '1234', '황수민', '민수', '967777', 'M', 'INFJ', '010-5555-6666');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('tjaud@test.com', '1234', '이서명', '뜨돈', '957777', 'W', 'INFJ', '010-0000-9999');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('dnjswls@test.com', '1234', '김원진', '나이키', '997777', 'M', 'ISFP', '010-1111-0000');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('wldud@test.com', '1234', '정지영', '정영지', '947777', 'W', 'INFP', '010-2222-0000');

CREATE TABLE Member(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	email			VARCHAR(50)		NOT NULL,
	pw				VARCHAR(20)		NOT NULL,
	name			VARCHAR(30)		NOT NULL,
	nickName		VARCHAR(30)		NOT NULL,
	birth			VARCHAR(20)		DEFAULT '',
	mbti			VARCHAR(4)		NOT NULL,
	gender			CHAR			NOT NULL,
	phone			VARCHAR(13)		DEFAULT '',
	regDate			TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	level			INT				DEFAULT 1,
	mabPoint		INT				DEFAULT 0,
	profileImg		VARCHAR(100)	DEFAULT '',
	contentsCount	INT				DEFAULT 0,
	commentsCount	INT				DEFAULT 0
);

CREATE TABLE CommunityBoard(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberId		BIGINT			NOT NULL,
	title			VARCHAR(100)	NOT NULL,
	contents		VARCHAR(1000)	NOT NULL,
	reportingDate	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	views			INT				DEFAULT 0,
	likes			INT				DEFAULT 0,
	commentsCount 	INT				DEFAULT 0,
	CONSTRAINT Member_memberId_FK FOREIGN KEY(memberId) REFERENCES Member(id) ON DELETE CASCADE
);

CREATE TABLE CommunityComments(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	boardId			BIGINT			NOT NULL,
	memberId		BIGINT			NOT NULL,
	comments		VARCHAR(200)	NOT NULL,
	likes			INT				DEFAULT 0,
	reportingDate	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT CommunityBoard_boardId_FK FOREIGN KEY(boardId) REFERENCES CommunityBoard(id) ON DELETE CASCADE
);

CREATE TABLE CommunityComments_plus(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	boardId			BIGINT			NOT NULL,
	commentId		BIGINT			NOT NULL,
	memberId		BIGINT			NOT NULL,
	comments		VARCHAR(200)	NOT NULL,
	likes			INT				DEFAULT 0,
	reportingDate	TIMESTAMP		DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT CommunityComments_commentId_FK FOREIGN KEY(commentId) REFERENCES CommunityComments(id) ON DELETE CASCADE
);

-- 추천 로그관리

SELECT * FROM LikeLog;
DROP TABLE LikeLog;

CREATE TABLE LikeLog(
	boardId			BIGINT			NOT NULL,
	memberId		BIGINT			NOT NULL
);