<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맙티</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/mainCommunity.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
<script
	src="<%=request.getContextPath()%>/resources/js/mainCommunity.js" defer></script>
</head>

<body>
	<!-- // 기본양식 -->
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		<!-- 작성 구역 -->
		<a id="viewAll" href="javascript:allView()">전체</a>

		<form action="javascript:checkMbti()" method="POST">

			<div id="type1" class="toggle-switch">
				<input type="checkbox" name="type01" />
				<div class="switch"></div>
				<span class="front">E</span> <span class="back">I</span>
			</div>

			<div id="type2" class="toggle-switch">
				<input type="checkbox" name="type02" />
				<div class="switch"></div>
				<span class="front">N</span> <span class="back">S</span>
			</div>

			<div id="type3" class="toggle-switch">
				<input type="checkbox" name="type03" />
				<div class="switch"></div>
				<span class="front">F</span> <span class="back">T</span>
			</div>

			<div id="type4" class="toggle-switch">
				<input type="checkbox" name="type04" />
				<div class="switch"></div>
				<span class="front">P</span> <span class="back">J</span>
			</div>

			<input type="submit" value="필터적용" />

		</form>

		<a id="viewName">전체글</a>

		<table>
			<tr>
				<th>추천</th>
				<th>MBTI</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="communityBoard" items="${cbList}">
				<tr class="contents">
					<td>${communityBoard.likes}</td>
					<td>${communityBoard.member.mbti}</td>
					<td>${communityBoard.member.nickName}</td>
					<td><a href="write?boardId=${communityBoard.id}">${communityBoard.title}</a></td>
					<td>${communityBoard.reportingDate}</td>
					<td>${communityBoard.views}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div id="searchBar">
			<form action="javascript:search()">
				<select name="searchOption">
					<option>제목</option>
					<option>작성자</option>
				</select> <input type="text" name="searchContents" placeholder="검색" /> <input
					type="submit" value="검색" />
			</form>
		</div>

		<a href="write" id="write">글쓰기</a>

	</div>
	<!-- 기본양식 // -->
</body>
</html>