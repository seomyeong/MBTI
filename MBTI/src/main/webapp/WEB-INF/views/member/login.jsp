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
	href="<%=request.getContextPath()%>/resources/css/login.css">
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"
	defer></script>
</head>
<body>
	<jsp:include page="/resources/incl/nav.jsp"></jsp:include>
	<div id="main">
		        <h1>Login</h1>
                <h2>${errorMsg}</h2>
                <div id="login_wrap">
                    <form action="login" method="post">
                        <table>
                            <tr>
                                <th>ID</th>
                                <td><input type="text" placeholder="아이디를 입력하세요."
                                    name="email" value="${cookie.saveId.value}"></td>
                            </tr>
                            <tr>
                                <th>PW</th>
                                <td><input type="password" placeholder="비밀번호를 입력하세요."
                                    name="pw"></td>
                            </tr>
                        </table>
                        <div id="login_btn">
                            <div id="saveId">
                                <c:choose>
                                    <c:when test="${cookie.saveId.value==null}">
                                        <label><input type="checkbox" name="saveId"><span>아이디
                                                기억하기</span></label>
                                    </c:when>
                                    <c:otherwise>
                                        <label><input type="checkbox" name="saveId"
                                            checked="checked"><span>아이디 기억하기</span></label>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <!-- <a onclick="javascript:history.back()">이전</a> --> 
                            <a href="/myapp/index">이전</a> 
                            <input type="submit" value="로그인" id="submit">
                        </div>
                    </form>
                </div>	                                                                                                                                                                                            
	</div>
</body>
</html>