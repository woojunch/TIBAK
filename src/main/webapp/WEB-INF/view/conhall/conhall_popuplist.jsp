<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
tr,td{
	border:1px solid black;
}
</style>
<body>
      <table>
                    <tr>
                        <td>공연장번호</td>
                        <td>공연장이름</td>
                        <td>좌석수</td>
                        <td>주소</td>
                        <td>좌석행</td>
                        <td>좌석열</td>
                    </tr>
<c:forEach items="${conHallList }" var="conHallList">
                    <tr>
                        <td><a>${conHallList.num }</a></td>
                        <td>사진</td>
                        <td>${conHallList.name }</td>
                        <td>${conHallList.capacity }</td>
                        <td>${conHallList.row}</td>
                        <td>${conHallList.column}</td>
                    </tr>
</c:forEach>
                </table>
</body>
</html>