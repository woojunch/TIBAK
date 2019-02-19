<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<% AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function loginMsg(){
	alert("로그인 후 이용하세요");
	location.href='/tibak/login';
}

</script>
<body>
    <div class="wrap_header">
        <div id="header">
            <div id="header_menu">
                <ul>
                    <li><a href="#">이용안내</a></li>
                    <li><a href="#">고객센터</a></li>
                    <li><a href="/tibak/joinChoice">회원가입</a></li>
                    <% if(authInfo!=null){ %>
                    <li><a href="/tibak/main/logout">로그아웃</a></li>
                    <li>${authInfo.id }님</li>
                    <%} else {%>
                     <li><a href="/tibak/loginChoice">로그인</a></li>
                     <%} %>
                </ul>
            </div>
            <div id="header_content">
                <div id="main_logo"><a href="/tibak/ticket/mainview"><img src="../img/tb.png" width="100%" height="100%"></a></div>

                <div id="main_search">
                    <fieldset>
                        <input type="text" style="width:400px; height:35px;">
                        <button type="button" id="btn_search"><img src="../img/btn_search_icon.png" alt="" width="20px"
                                height="20px"></button>
                    </fieldset>
                </div>
                <div id="event_banner">
                    <a href=""><img src="../img/event.png" alt="" width="200px" height="70px"></a>
                </div>

            </div>
        </div>
    </div>
    <div id="menu">
        <div id="menu_content">
            <ul id="menu_nav">
                <li><a href="/tibak/ticket/mainview">공연</a></li>
                <li><a href="/tibak/ticket/search">장르 / 지역</a></li>
                <% if(authInfo!=null){%>
                <li><a href="/tibak/order/orderhistory">마이페이지</a></li>
                <%} else {%>
                <li><a href="#" onclick="loginMsg();">마이페이지</a></li>
                <%} %>
                <li><a href="/tibak/concert/list">상품등록하기</a></li>
                <li><a href="/tibak/concert/list">주문관리</a></li>
                <li><a href="/tibak/concert/list">결제관리</a></li>
                
            </ul>
        </div>
    </div>

</body>
</html>