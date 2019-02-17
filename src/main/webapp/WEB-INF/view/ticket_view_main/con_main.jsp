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