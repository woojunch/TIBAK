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
/*         background-color: lightblue; */
        text-align: center;
        box-sizing:border-box;
        margin-bottom:50px;
    }

    #register_content {
        display: inline-block;
        width: 80%;
        height: 100%;
/*         background-color: lightgreen; */
        box-sizing: border-box;
    }

    #content_header {
        width: 100%;
        height: 100px;
/*         background-color: lightcoral; */
        text-align: left;
        box-sizing: border-box;
        padding: 30px;
        font-size: 30px;
    }

    #form_box {
        width: 100%;
/*         background-color: aquamarine; */
        text-align: center;
    }

    table {
        width: 100%;
    }

    tr,
    td {
        border: 1px solid black;
    }
</style>
<body>
   <jsp:include page="/WEB-INF/view/header.jsp" />
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
                    	<td colspan="2"><input type="submit" value="등록하기"></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </div>
    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html></body>
</html>