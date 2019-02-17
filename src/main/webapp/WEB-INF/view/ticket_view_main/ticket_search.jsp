<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <div class="contents">
  <div class="rdo_box">
            <div class="subject_box">
                <ul>
                    <li class="subject">
                        <strong>테마별</strong>
                        <ul>
                            <li><input type="radio" value="all" name="theme">전체</li>
                            <li><input type="radio" value="내한공연" name="theme">내한공연</li>
                            <li><input type="radio" value="아이돌" name="theme">아이돌</li>
                            <li><input type="radio" value="홍대/소극장" name="theme">홍대/소극장</li>
                            <li><input type="radio" value="효 콘서트" name="theme">효 콘서트</li>
                            <li><input type="radio" value="홍대/소극장" name="theme">페스티벌/콜라보</li>
                        </ul>
                    </li>
                    <li class="subject">
                        <strong>지역별</strong>
                        <ul>
                            <li><input type="radio" value="all" name="area">전체</li>
                            <li><input type="radio" value="seoul" name="area">서울</li>
                            <li><input type="radio" value="kyungki" name="area">경기/인천</li>
                            <li><input type="radio" value="daejeon" name="area">대전/충청/강원</li>
                            <li><input type="radio" value="busan" name="area">부산/대구/경상</li>
                            <li><input type="radio" value="kwangju" name="area">광주/전라/제주</li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="btn">
                <a href=""><button type="button" class="button">조회</button></a>
            </div>
        </div>

    <div style="font-size:30px; padding: 50px 0px 0px 80px; box-sizing:border-box;">공연</div>
        <div class="list">
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
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html>