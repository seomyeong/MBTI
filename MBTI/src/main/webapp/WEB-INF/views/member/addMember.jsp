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
	href="<%=request.getContextPath()%>/resources/css/addMember.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
</head>
<body>
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
    <div id="main">
	    <main id="addCustomer">
            <h1>회원가입</h1>
            <div id="addCustomer_wrap">
                <form:form action="successAddMember" method="post" modelAttribute="member">
                    <table>
                        <tr>
                            <th>ID</th>
                            <td><form:input placeholder="아이디를 입력하세요."
                                path="email" required="required"/></td>
                            <td><span class="errorTxt">${errorMsg}</span></td>

                        </tr>
                        <tr>
                            <th>PW</th>
                            <td><form:password placeholder="비밀번호를 입력하세요."
                                path="pw" required="required"/></td>
                            <td><span class="errorTxt">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td><form:input placeholder="이름을 입력하세요." path="name" required="required"/></td>
                            <td><span class="errorTxt">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>닉네임</th>
                            <td><form:input placeholder="닉네임을 입력하세요." path="nickName" required="required"/></td>
                            <td><span class="errorTxt">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>핸드폰</th>
                            <td><form:input maxlength="11"  placeholder="핸드폰 번호를 입력하세요"
                                path="phone" required="required"/></td>
                            <td><span class="errorTxt">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>생년월일</th>
                            <td><form:input maxlength="6" placeholder="주민번호 앞자리"
                                path="birth" required="required"/></td>
                            <td><span class="errorTxt errorTxt2">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>MBTI</th>
                            <td><form:input maxlength="4" placeholder="MBTI를 입력하세요" path="mbti" required="required"/></td>
                            <td><span class="errorTxt errorTxt2">${errorMsg}</span></td>
                        </tr>
                        <tr>
                            <th>성별</th>
                            <td><form:input placeholder="성별을 입력하세요" path="gender" required="required"/></td>
                            <td><span class="errorTxt errorTxt2">${errorMsg}</span></td>
                        </tr>
                    </table>
                    <div id="addCustomer_btn">
                        <a onclick="javascript:history.back()">이전</a> <input type="submit" value="회원가입" id="submit">
                    </div>
                </form:form>
            </div>
	    </main>
    </div>
</body>
</html>