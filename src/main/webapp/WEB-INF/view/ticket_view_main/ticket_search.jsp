<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*, Model.*"%>
<% List<TicketDTO> ticketList = (List<TicketDTO>)request.getAttribute("ticketList"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>ticket main</title>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->
    <link href="../CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_footer.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_loc.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <form action="/tibak/ticket/search" method="post">
    <div class="contents">
  <div class="rdo_box">
            <div class="subject_box">
                <ul>
                    <li class="subject">
                        <strong>테마별</strong>
                        <ul>
                            <li><input type="radio" checked="checked" value="전체" name="theme">전체</li>
                            <li><input type="radio" value="내한공연" name="theme">내한공연</li>
                            <li><input type="radio" value="아이돌" name="theme">아이돌</li>
                            <li><input type="radio" value="홍대/소극장" name="theme">홍대/소극장</li>
                            <li><input type="radio" value="효 콘서트" name="theme">효 콘서트</li>
                            <li><input type="radio" value="페스티벌/콜라보" name="theme">페스티벌/콜라보</li>
                        </ul>
                    </li>
                    <li class="subject">
                        <strong>지역별</strong><br>
                        <select style="Width:80px; height:30px; margin-top:20px;" name="area">
                        	<option value="전체">전체</option>
                        	<option value="서울">서울</option>
                        	<option value="인천">인천</option>
                        	<option value="대전">대전</option>
                        	<option value="광주">광주</option>
                        	<option value="대구">대구</option>
                        	<option value="부산">부산</option>
                        	<option value="경기">경기</option>
                        	<option value="강원">강원</option>
                        	<option value="충북">충북</option>
                        	<option value="충남">충남</option>
                        	<option value="전북">전북</option>
                        	<option value="전남">전남</option>
                        	<option value="경북">경북</option>
                        	<option value="경남">경남</option>
                        	<option value="제주">제주</option>
                        	<option value="세종">세종</option>
                        </select>
                    </li>
                </ul>
            </div>
            <div class="btn">
                <input type="submit" id="searchButton" value="조회"></form>
            </div>
        </div>

    <div style="font-size:30px; padding: 50px 0px 0px 80px; box-sizing:border-box;">공연</div> 
        <div class="list">
                <% if(ticketList.size()>0){%>
            <ul class="all_con_list">    
<c:forEach items="${ticketList }" var="ticketList">
       <c:set var="TextValue" value="${ticketList.name }"/>
                <li class="">
                 <a href="/tibak/ticket/detail?num=${ticketList.proNum}">
                        <span class="all_con_img"><img src="../upfile/${ticketList.storeImg }" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">${fn:substring(TextValue,0,13) }...</strong>
                        <span class="all_con_day">${ticketList.conDate }</span>
                        <span class="all_con_loc">${ticketList.hallName }</span>
                 </a>
                </li>
</c:forEach>

            </ul>
        </div>
        <% } else {%>
      <div style="font-size:30px; margin-bottom:500px; text-align:center;">조회정보가 없습니다.</div>
        <%} %>
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html>