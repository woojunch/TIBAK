<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>아이디</td>
		<td>회원등급</td>
		<td>이름</td>
		<td>생년월일</td>
		<td>성별</td>
		<td>이메일</td>
		<td>연락처</td>
		<td>주소</td>
		<td>이메일수신여부</td>
		<td>문자수신여부</td>
		<td>가입날짜</td>
		<td>비밀번호변경날짜</td>
	</tr>
<c:forEach items="${memberList }" var="memberList">
	<tr>
		<td>${memberList.mId}</td>
		<td>${memberList.mGrade }</td>
		<td>${memberList.mName }</td>
		<td>${memberList.mBirth }</td>
		<td>${memberList.mGender }</td>
		<td>${memberList.mEmail }</td>
		<td>${memberList.mPhone }</td>
		<td>${memberList.mAddr }</td>
		<td>${memberList.mMailReceived }</td>
		<td>${memberList.mMessageReceived }</td>
		<td>${memberList.mDate }</td>
		<td>${memberList.mPasswordDate }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>