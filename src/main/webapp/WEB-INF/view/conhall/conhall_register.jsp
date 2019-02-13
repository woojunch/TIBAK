<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연장등록</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->
    <link href="../CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_footer.css" rel="stylesheet" type="text/css">
</head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
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
                <div>공연장등록</div>

            </div>
            <div id="form_box">
            <form action="/tibak/conhall/register" method="post" enctype="multipart/form-data">
                <table>
                	<tr>
                     	<td>공연장이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>좌석수</td>
                        <td><input type="text" name="capacity"></td>
                    </tr>
                    <tr>
                        <td>공연장주소</td>
                        <td><input type="text" id="sample6_postcode" name="zipcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" name="addr" placeholder="주소"><br>
<input type="text" id="sample6_detailAddress" name="detailAddr" placeholder="상세주소">
<input type="text" id="sample6_extraAddress" name="reference" placeholder="참고항목"></td>
                    </tr>
                    <tr>
                        <td>좌석행</td>
                        <td><input type="text" name="row"></td>
                    </tr>
                    <tr>
                        <td>좌석열</td>
                        <td><input type="text" name="column"></td>
                    </tr>
                    <tr>
                    	<td colspan="2"><input type="submit"></td>
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