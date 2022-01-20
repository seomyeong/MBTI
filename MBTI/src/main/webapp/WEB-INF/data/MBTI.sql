SELECT * FROM MEMBER;
DROP TABLE MEMBER;

CREATE TABLE MEMBER(
	id				BIGINT		PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	email 			VARCHAR(40)	NOT NULL,
	pw 				VARCHAR(20)	NOT NULL,
	name 			VARCHAR(30)	NOT NULL,
	nickName 		VARCHAR(10)	NOT NULL,
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

SELECT * FROM Member WHERE mbti='ENFP' AND pw='1234' OR mbti='INFJ' AND pw='1234';

SELECT * FROM Member;
SELECT * FROM CommunityBoard;
SELECT * FROM CommunityComments;
SELECT * FROM CommunityComments_plus;

SELECT * FROM sys.systables;
SELECT level, mbti FROM Member;
SELECT * FROM CommunityBoard WHERE likes>=20 ORDER BY ReportingDate DESC;

UPDATE Member SET level=31 WHERE id=3;
UPDATE Member SET level=29 WHERE id=6;
UPDATE Member SET nickName='이즈리얼 연구원' WHERE id=1;
UPDATE Member SET profileImg='/myapp/resources/img/avatar/MBTI_ESFJ.png' WHERE id=4;
UPDATE Member SET mbti='ESFJ' WHERE id=4;
UPDATE Member SET profileImg='/myapp/resources/img/avatar/MBTI_ISFJ.png' WHERE id=1;
UPDATE Member SET profileImg='/myapp/resources/img/avatar/MBTI_ENFP.png' WHERE id=1;

DROP TABLE Member;
DROP TABLE CommunityBoard;
DROP TABLE CommunityComments;
DROP TABLE CommunityComments_plus;

INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('ydh1178@naver.com', '1234', '김종성', '성종', '961124', 'M', 'ISFJ', '010-8599-7622');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('test@test.com', '1234', '테스트계정', '테스트계정', '001122', 'W', 'ENFP', '010-1111-2222');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('tnals@test.com', '1234', '황수민', '민수', '967777', 'M', 'INFJ', '010-5555-6666');
INSERT INTO Member(email, pw, name, nickName, birth, gender, mbti, phone) VALUES('tjaud@test.com', '1234', '이서명', '뜨돈', '957777', 'W', 'ESFJ', '010-0000-9999');
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



--MbtiPlay
SELECT * FROM MbtiPlayContents;
SELECT * FROM MbtiPlayContentsAnswer;
SELECT * FROM ContentsLog;
SELECT * FROM AnswersLog;

DROP TABLE MbtiPlayContents;
DROP TABLE MbtiPlayContentsAnswer;
DROP TABLE ContentsLog;
DROP TABLE AnswersLog;

UPDATE Member SET mabPoint=980 WHERE id=1;
UPDATE ContentsLog SET contentsCount=0 WHERE id=1;

--문답 쿼리
INSERT INTO MbtiPlayContents (memberId, question, answer01, answer02, answer03) VALUES (1, '친구들과 놀이동산을 간 당신, 놀이기구를 탈 때의 나는?', '오늘 이거 다섯 개는 꼭 타야 돼! 지도를 보며 계획을 세운다.', '오, 저거 재밌어 보인다! 일단 보이는 것부터 탄다.', '놀이기구는 흥미가 들지 않아 이끌려다닌다.');
INSERT INTO MbtiPlayContents (memberId, question, answer01, answer02, answer03) VALUES (1, '소개팅을 나간 당신, 첫 만남에 어색할 때','준비해온 멘트들을 건네며 대화에 시동을 건다.','미소만 지으며 상대가 말할 때까지 기다린다.','즉흥적으로 대화를 진행하다 집에가서 후회한다.');
INSERT INTO MbtiPlayContents (memberId, question, answer01, answer02, answer03) VALUES (1, '연인이 길을 가다가 누군가와 부딪혔다. 그때의 나는?','저기요! 사과하셔야죠! 일단 따지고 본다.','괜찮아? 다친데 없어? 연인을 위로한다.','그럴수도 있지. 대수롭지 않게 넘긴다.');
INSERT INTO MbtiPlayContents (memberId, question, answer01, answer02, answer03) VALUES (1, '친구한테 지금 내가 있는 카페 위치를 알려줄 때','5번 출구로 나와서 두번째 블록에서 좌회전 하면 나오는 사거리 근처야','거기 그 햄버거집 알지? 그 앞이야','지도보고 알아서 찾아와!');

CREATE TABLE MbtiPlayContents(
	id				BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberId		BIGINT			NOT NULL, --멤버FK
	question		VARCHAR(500)	NOT NULL,
	answer01		VARCHAR(100)	NOT NULL,
	answer02		VARCHAR(100)	NOT NULL,
	answer03		VARCHAR(100)	NOT NULL,
	CONSTRAINT memberId_FK FOREIGN KEY(memberId) REFERENCES Member(id)
);

CREATE TABLE MbtiPlayContentsAnswer(
	id					BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberMbti			VARCHAR(4)		NOT NULL, --회원의 MBTI
	questionNum			BIGINT			NOT NULL, --문제번호 FK
	choosenNum			CHAR(1)			NOT NULL, --선지번호
	isSubjective		VARCHAR(10)		NOT NULL, --주관식여부
	subjectiveContent	VARCHAR(100)	NOT NULL DEFAULT '', --주관식내용
	choosenNumCount		INT				NOT NULL DEFAULT 0,  --선지번호 선택건수
	CONSTRAINT questionNum_FK FOREIGN KEY(questionNum) REFERENCES MbtiPlayContents(id)
);

CREATE TABLE ContentsLog(
	id					BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberId			BIGINT			NOT NULL,
	contentsCount		INT				DEFAULT 0,
	regDate 			TIMESTAMP 		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT ContentsLog_memberId_FK FOREIGN KEY(memberId) REFERENCES Member(id)
);

CREATE TABLE AnswersLog(
	id					BIGINT			PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	memberId			BIGINT			NOT NULL,
	contentsNum			BIGINT			NOT NULL,
	CONSTRAINT AnswersLog_memberId_FK FOREIGN KEY(memberId) REFERENCES Member(id)
);
