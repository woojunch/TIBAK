<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->

    <link href="../CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_footer.css" rel="stylesheet" type="text/css">
</head>
<style>
#container{
    width:100%;
    height:1200px;
    background-color: aquamarine;
    text-align:center;
}
#content{
    display:inline-block;
    width:80%;
    height:100%;
    background-color:lightblue;
    text-align:center;
}
#content_header{
    width:100%;
    height:100px;
    background-color:lightcoral;
    padding:30px;
    box-sizing:border-box;
    text-align:left;
    font-size:30px;

}
#table_box{
    display:inline-block;
    width:80%;
    height:800px;
    background-color:lightgreen;
}
table{
    width:100%;
}
tr, td{
    border:1px solid black;
}
</style>

<body>

    <div id="header">
        <div id="header_menu">
            <ul>
                <li><a href="#">이용안내</a></li>
                <li><a href="#">고객센터</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="#">로그인</a></li>
            </ul>
        </div>
        <div id="header_content">
            <div id="main_logo"><a href=""><img src="./img/tb.png" width="100%" height="100%"></a></div>

            <div id="main_search">
                <fieldset>
                    <input type="text" style="width:400px; height:35px;">
                    <button type="button" id="btn_search"><img src="./img/btn_search_icon.png" alt="" width="20px"
                            height="20px"></button>
                </fieldset>
            </div>
            <div id="event_banner">
                <a href=""><img src="./img/event.png" alt="" width="200px" height="70px"></a>
            </div>

        </div>
    </div>
    <div id="menu">
        <div id="menu_content">
            <ul id="menu_nav">
                <li><a href="#">메뉴1</a></li>
                <li><a href="#">메뉴2</a></li>
                <li><a href="#">메뉴3</a></li>
                <li><a href="#">메뉴4</a></li>
                <li><a href="#">메뉴5</a></li>
                <li><a href="#">메뉴6</a></li>
                <li><a href="#">메뉴7</a></li>
            </ul>
        </div>
    </div>

    <!-- 요기까지 헤더 -->
    <div id="container">
        <div id="content">
            <div id="content_header">공연리스트</div>
            <div id="table_box">
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
                        <td>${conHallList.num }</td>
                        <td>사진</td>
                        <td>${conHallList.name }</td>
                        <td>${conHallList.capacity }</td>
                        <td>${conHallList.row}</td>
                        <td>${conHallList.column}</td>
                    </tr>
</c:forEach>
                </table>

            </div>
        </div>
    </div>

    <!--푸터-->
    <div class="footer">
        <div class="wrap_footer">
            <div class="foot_link">
                <div class="l_box">
                    <a href="">제휴</a>
                    <a href="">사이트</a>
                </div>
                <div class="r_box">
                    <a href="">예매가이드</a>
                    <a href="">티켓판매제휴</a>
                    <a href="">예매문의..</a>
                </div>
            </div>
            <div class="foot_bot">
                <ul class="foot_com">
                    <li><a href="">회사소개,,</a></li>
                    <li><a href="">이용약관,,?</a></li>
                    <li><a href="">이런거</a></li>
                    <li><a href="">넣어야되나</a></li>
                    <li><a href="">일단 만들어봄</a></li>
                </ul>
            </div>
            <div class="com_info">
                <span>회사이름</span>
                <span>회사주소</span>
                <span>회사대표</span>
                <span>사업자등록번호</span>
                <span>고객센터(평일주말,,,-ㅅ-</span>
            </div>
        </div>
    </div>
</body>
</html>