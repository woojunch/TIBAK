<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<% AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->

    <link href="./CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="./CSS/t_footer.css" rel="stylesheet" type="text/css">
    <link href="./CSS/t_con.css" rel="stylesheet" type="text/css">
    <style></style>
    <script>
    </script>
</head>

<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <div class="wrap_contents">

        <div class="rec_con">
                <h2 class="h1tit">공연</h2>
            <div id="tit">
                <h1>추천공연이나 결합상품</h1>
            </div>
            <ul class="con_list">
                <li id="con_box">
                    <a href="">
                        <div class="con_img">
                            <img src="../img/baek.jpg" alt="" width="250px" height="350px">
                        </div>
                        <div class="con_info">
                            <span class="con_i">
                                <span class="con_tit">콘서트 명</span>
                                <span class="con_txt">콘서트 한줄설명</span>
                            </span>
                        </div>
                    </a>
                </li>
                <li id="con_box">
                    <a href="">
                        <div class="con_img">

                            <img src="../img/baek.jpg" alt="" width="250px" height="350px">

                        </div>
                        <div class="con_info">
                            <span class="con_i">
                                <span class="con_tit">콘서트 명</span>
                                <span class="con_txt">콘서트 한줄설명</span>
                            </span>
                        </div>
                    </a>
                </li>

                <li id="con_box">
                    <a href="">
                        <div class="con_img">

                            <img src="../img/baek.jpg" alt="" width="250px" height="350px">

                        </div>
                        <div class="con_info">
                            <span class="con_i">
                                <span class="con_tit">콘서트 명</span>
                                <span class="con_txt">콘서트 한줄설명</span>
                            </span>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="all_con">
            <div id="tit">
                <h1>전체공연</h1>
            </div>
            <ul class="all_con_list">
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="upfile/${proImg }" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">${name }</strong>
                        <span class="all_con_day">${conDate }</span>
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="../img/con2.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="../img/con3.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="../img/con4.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                        <span class="all_con_loc">공연장</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <!--푸터-->
    <jsp:include page="/WEB-INF/view/footer.jsp" />

</body>

</html>