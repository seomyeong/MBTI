<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맙티</title>
</head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/updateMember.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
<script src="<%=request.getContextPath()%>/resources/js/updateMember.js"
	defer></script>
<body>
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		<main id="updateCustomer">
			<h1>정보수정</h1>
			<div id="updateCustomer_wrap">
				<form:form action="successUpdateMember" method="post"
					modelAttribute="memberCommand">
					<table>
						<tr>
							<th>이메일</th>
							<td><form:input type="text" maxlength="30" readonly="true"
									value="${sessionScope.memberInfo.email}" path="email1"
									autocomplete="off" oninput="emailCheck(this.form)" /></td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><form:password id="password1" placeholder="비밀번호"
									 path="pw" /></td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>비밀번호 <br>확인
							</th>
							<td><form:password id="password2" placeholder="비밀번호 재확인"
									path="" /></td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><form:input path="name" maxlength="30"
									value="${sessionScope.memberInfo.name}" autocomplete="off"
									readonly="true" /></td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td><form:input value="${sessionScope.memberInfo.nickName}"
									path="nickName" autocomplete="off" maxlength="10"
									oninput="nickNameCheck(this.form)" /></td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td><form:select id="year" path="birth" /> 년 <select
								id="month" name="birth"></select> 월 <select id="day"
								name="birth"></select> 일</td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>MBTI</th>
							<td>
								<%-- <form:select maxlength="4" placeholder="MBTI를 입력하세요"
									path="mbti" required="required"
									 /> --%> <select name="mbti"
								value="${sessionScope.memberInfo.mbti}">
									<option value="ENTJ">ENTJ</option>
									<option value="ENTP">ENTP</option>
									<option value="ENFJ">ENFJ</option>
									<option value="ENFP">ENFP</option>
									<option value="ESTJ">ESTJ</option>
									<option value="ESTP">ESTP</option>
									<option value="ESFJ">ESFJ</option>
									<option value="ESFP">ESFP</option>
									<option value="INTJ">INTJ</option>
									<option value="INTP">INTP</option>
									<option value="INFJ">INFJ</option>
									<option value="INFP">INFP</option>
									<option value="ISTJ">ISTJ</option>
									<option value="ISTP">ISTP</option>
									<option value="ISFJ">ISFJ</option>
									<option value="ISFP">ISFP</option>
							</select> <!-- <button
									onclick="window.open('https://www.16personalities.com/ko/%EB%AC%B4%EB%A3%8C-%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-%EA%B2%80%EC%82%AC','popup','width=1080, height=700, left=200, top=50');">검사하기</button> -->
								<a id="mbtiBtn"
								href="javascript:void(window.open('https://www.16personalities.com/ko/%EB%AC%B4%EB%A3%8C-%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-%EA%B2%80%EC%82%AC', 'popup','width=1080, height=700, left=200, top=50'))">검사하기</a>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>성별(선택)</th>
							<td id="radioBtn" value="${sessionScope.memberInfo.gender}">남자:
								<form:radiobutton path="gender" value="M" /> 여자: <form:radiobutton
									path="gender" value="W" /> 선택안함: <form:radiobutton
									path="gender" value="N" checked="checked" />
							</td>
							<td><span class="errorTxt"></span></td>
						</tr>
						<tr>
							<th>휴대전화</th>
							<td>
							<form:input value="${sessionScope.memberInfo.phone}" type="text" path="phone" maxlength="11"
									minlength="11" placeholder="11자리 숫자" pattern="[0-9]+" />
							</td>

							<td><span class="errorTxt errorTxt2"></span></td>
						</tr>
					</table>
					<div id="updateCustomer_btn">
						<!-- <a onclick="javascript:history.back()">이전</a> -->
						<a href="/myapp/index">이전</a> <input type="submit" value="정보수정"
							onclick="checkPattern(this.form); return false" id="submit">
					</div>
				</form:form>
			</div>
		</main>

	</div>
	<script>
		$("#radioBtn").val()
	</script>
</body>
</html>