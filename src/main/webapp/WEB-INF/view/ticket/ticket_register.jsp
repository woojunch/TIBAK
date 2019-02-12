<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->
    <link href="/resources/CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="/resources/CSS/t_footer.css" rel="stylesheet" type="text/css">
</head>
<style>
    body {
        font-family: "Nanum Gothic", sans-serif;
    }

    #register_container {
        width: 100%;
        height: 1800px;
        background-color: lightblue;
        text-align: center;
    }

    #register_content {
        display: inline-block;
        width: 80%;
        height: 100%;
        background-color: lightgreen;
        box-sizing: border-box;
    }

    #content_header {
        width: 100%;
        height: 100px;
        background-color: lightcoral;
        text-align: left;
        box-sizing: border-box;
        padding: 30px;
        font-size: 30px;
    }

    #form_box {
        width: 100%;
        background-color: aquamarine;
        text-align: center;
    }

    table {
        width: 80%;
    }

    tr,
    td {
        border: 1px solid black;
    }
</style>
<script>
    function conAdd(){
        alert("dd");
    }
</script>
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

    <div id="register_container">
        <div id="register_content">
            <div id="content_header">
                <div>상품등록</div>

            </div>
            <div id="form_box">
            <form action="#" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>상품명</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>상품이미지</td>
                        <td><img src="#"></td>
                    </tr>
                    <tr>
                        <td>상품설명</td>
                        <td><textarea cols="30" rows="5"></textarea></td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>공연장소</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>상품전화번호</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>교통안내</td>
                        <td><input type="file"></td>
                    </tr>
                    <tr>
                        <td>예매안내</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>이용안내</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>최대예매수제한</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>공연기간</td>
                        <td><input type="date">~<input type="date"></td>
                    </tr>
                    <tr>
                        <td>공연기획사정보</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>관람나이제한</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>좌석배치도</td>
                        <td><input type="file"></td>
                    </tr>
                    <tr>
                        <td>장르</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr colspan="2">
                    <input type="submit">
                    </tr>
                </table>
                </form>
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

</html></body>
</html>