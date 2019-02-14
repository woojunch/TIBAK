<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->

    <link href="../CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_footer.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_con.css" rel="stylesheet" type="text/css">
    <style></style>
    <script>
    </script>
</head>

<body>
    <div class="wrap_header">
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
                <div id="main_logo"><a href=""><img src="../img/tb.png" width="100%" height="100%"></a></div>

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
                <li><a href="#">홈</a></li>
                <li><a href="#">공연</a></li>
                <li><a href="#">장르 / 지역</a></li>
                <li><a href="#">오픈 예정</a></li>
                <li><a href="#">마이페이지</a></li>
            </ul>
        </div>
    </div>

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
                        <span class="all_con_img"><img src="../img/con1.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                        <span class="all_con_loc">공연장</span>
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="../img/con2.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                        <span class="all_con_loc">공연장</span>
                    </a>
                </li>
                <li class="">
                    <a href="">
                        <span class="all_con_img"><img src="../img/con3.jpg" alt="" width="200px" height="250px"></span>
                        <strong class="all_con_tit">공연명</strong>
                        <span class="all_con_day">공연날짜</span>
                        <span class="all_con_loc">공연장</span>
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