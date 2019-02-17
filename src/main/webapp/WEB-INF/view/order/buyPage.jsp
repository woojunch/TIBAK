<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>    
<% String proNum = (String)request.getParameter("proNum");
   String rowNum = (String)request.getParameter("rowNum");
   String columnNum = (String)request.getParameter("columnNum");
   MemberJoinDTO member= (MemberJoinDTO)request.getAttribute("memberdto");
   TicketDTO ticket= (TicketDTO)request.getAttribute("ticketdto");
   AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#container{
	width:100%;
	height:100%;
	text-align:center;
	font-family: "Nanum Gothic", sans-serif;
}
#seatChoice{
	width:100%;
	height:100%;
	box-sizing:border-box;
	padding:10px;
	font-size:20px;
	text-align:left;
	background-color:#ccc;
	
}
.message_box{
	margin-top:50px;
	padding-left:20px;
	width:100%;
	height:30px;
	text-align:left;
	box-sizing:border-box;
	font-size:20px;
}
.info_box{
	width:100%;
	border:1px solid #ccc;
	text-align:left;
	padding:20px;
	box-sizing:border-box;
}
.step{
	width:100%;
	height:100%;
}
span{
	font-size:13px;
}
.cardNum{
	width:40px;
}
</style>
<body>
<form action="/tibak/orderComplete" method="post">
<div id="container">
	<div id="seatChoice">
		<div class="step">구매/결제</div>
	</div>
	<div class="message_box">주문자정보를 입력하세요</div><br>
	<div class="info_box">
		이름: <input type="text" name="name" placeholder="<%=member.getName() %>"><br>
		연락처: <input type="text" name="phone" placeholder="<%=member.getPhone() %>"><br>
		이메일 : <input type="text" name="email" placeholder="<%=member.getEmail() %>"><br>
		<span>입력하신 이메일로 예매확인 내역을 보내드립니다.</span>
	</div>
	<div class="message_box">결제수단을 입력하세요</div><br>
	<div class="info_box">
		신용카드: <select id="card" name="card">
			<option value selected="selected">카드를 선택해주세요</option>
			<option value="신한카드">신한카드</option>
			<option value="BC카드">BC카드</option>
			<option value="삼성카드">삼성카드</option>
			<option value="현대카드">현대카드</option>
			<option value="롯데카드">롯데카드</option>
			<option value="KB국민카드">KB국민카드</option>
			<option value="NH농협카드">NH농협카드</option>
		</select>
		<select id="halbu" name="halbu">
			<option value="1" selected="selected">일시불</option>
			<option value="2">2개월</option>
			<option value="3">3개월</option>
			<option value="4">4개월</option>
			<option value="5">5개월</option>
			<option value="6">6개월</option>
			<option value="7">7개월</option>
			<option value="8">8개월</option>
			<option value="9">9개월</option>
			<option value="10">10개월</option>
			<option value="11">11개월</option>
			<option value="12">12개월</option>
		</select><br>
		카드번호: <input type="text" name="cardNum1" class="cardNum">-
		<input type="text" name="cardNum2" class="cardNum">-
		<input type="text" name="cardNum3" class="cardNum">-
		<input type="text" name="cardNum4" class="cardNum">
	</div>
	<div class="message_box">구매/결제정보</div><br>
	<div class="info_box">
		공연명: <%=ticket.getName() %><br><input type="hidden" name="conName" value="<%=ticket.getName() %>">
		공연날짜: <%=ticket.getConDate()%><br><input type="hidden" name="conDate" value="<%=ticket.getConDate() %>">
		좌석위치: <%=rowNum %>행&nbsp;<%=columnNum %>열<input type="hidden" name="seatNum" value="<%=rowNum %>행 <%=columnNum%>열"><br>
		결제금액: <%=ticket.getPrice() %><input type="hidden" name="price" value="<%=ticket.getPrice() %>">
		<input type="hidden" name="proNum" value="<%=proNum %>">
		<input type="hidden" name="id" value="<%=authInfo.getId() %>">
		<input type="hidden" name="cWay" value="카드결제">
	</div>
	<input type="button" value="< 이전" onClick="history.go(-1)"><input type="submit" value="결제하기 >">
</div>
</form>
</body>
</html>