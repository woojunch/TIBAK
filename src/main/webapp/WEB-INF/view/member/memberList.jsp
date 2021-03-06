<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Model.MemberJoinDTO"%> 
<%
ArrayList<MemberJoinDTO> members = null;
if(request.getAttribute("members")!=null){
	members = (ArrayList<MemberJoinDTO>)request.getAttribute("members");
} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
			<h1>MEMBER LIST</h1> 
		<table>
			<tr>
				<td class = "td1">아이디</td>
				<td class = "td2">이름</td>
				<td class = "td3">이메일</td>
				<td class = "td4">생년월일</td>
				<td class = "td5">전화번호</td>
				<td class = "td6">성별</td>
				<td class = "td7">주소</td>
				<td class = "td8">가입일</td>
				<td class = "td9">비밀번호변경일</td>
				<td class = "td10">메일수신</td>
				<td class = "td11">메세지수신</td>
			</tr>
			<%if(members.size()==0){ %>
			<tr>
				<td colspan="11" style= "text-align: center">회원이 존재하지 않습니다.</td>
			</tr>
			<% } else{
				for(int a = 0; a<members.size();a++){		
			%>
			<tr>
				<td class = "td1"><%=members.get(a).getId()%></td>
				<td class = "td2"><%=members.get(a).getName()%></td>
				<td class = "td3"><%=members.get(a).getEmail()%></td>
				<td class = "td4"><%=members.get(a).getBirth()%></td>
				<td class = "td5"><%=members.get(a).getPhone()%></td>
				<td class = "td6"><%=members.get(a).getGender()%></td> 
				<td class = "td7"><%=members.get(a).getAddr()%></td> 
				<td class = "td8"><%=members.get(a).getDate()%></td> 
				<td class = "td9"><%=members.get(a).getPassdate()%></td> 
				<td class = "td10"><%=members.get(a).getMailrecv()%></td> 
				<td class = "td11"><%=members.get(a).getSmsrecv()%></td> 
			</tr>
			<%} %>

			<%} %>
		</table> 
</body>
</html>