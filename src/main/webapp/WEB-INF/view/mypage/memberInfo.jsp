<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="Command.MemberJoin" %>
<%
MemberJoin info = null;
if(session.getAttribute("lnfo")!=null){
	info = (MemberJoin) session.getAttribute("info");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>회원정보관리</title>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic"
	rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<script type="text/javascript"> 
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
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
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
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
	$(function(){
		$("#join_success").click(function(){
			if(confirm("수정을 완료하시겠습니까?")){
				
			} else{
				event.preventDefault();
			}
		})
	})
</script>
<style>
html, body {
	margin: 0 auto;
	padding: 0;
	text-align: center;
	font-family: "Nanum Gothic", sans-serif;
	background-color: rgba(252, 252, 252, 0.829);
}

p {
	font-size: 30px;
}

#logo_box {
	width: 100%;
	height: 150px;
	padding-top: 30px;
}

#join_logo {
	width: 250px;
}

#join_auth {
	display: inline-block;
	/* background-color: pink; */
	width: 400px;
	height: 1100px;
	border: 1px solid rgb(204, 198, 198);
	text-align: center;
	padding: 20px 50px 50px 50px;
	background-color: white;
}

table {
	width: 100%;
}

tr, td {
	text-align: left;
	/* border:1px solid black;  */
	padding: 7px 0px 7px 0px;
}

th {
	padding: 0px 20px 0px 0px;
}

.textbox {
	width: 300px;
	height: 50px;
	border-radius: 10px;
	border: 1px solid rgb(204, 198, 198);
}

.gender_radio {
	width: 40px;
	height: 22px;
}

#re_send {
	border-radius: 20px;
	border: 1px solid rgb(204, 198, 198);
	background-color: white;
	font-size: 15px;
	color: rgb(138, 133, 133);
}

#join_success {
	width: 250px;
	height: 70px;
	background-color: rgb(51, 192, 51);
	font-size: 20px;
	color: white;
	border: 0px;
}

.checkbox {
	width: 20px;
	height: 20px;
	float: right;
}

.phone_text {
	width: 88px;
	height: 50px;
	border-radius: 10px;
	border: 1px solid rgb(204, 198, 198);
}
</style>

<body>
	<div id="logo_box">
		<img src="./img/tb.png" id="join_logo">
	</div>
	<form action="" method="post">
		<div id="join_auth">
			<p>회원정보관리</p>
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="textbox" value="<%=info.getId() %>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="password"  class="textbox" value="<%=info.getPasswd()%>"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="text" name="passwd_identify"  class="textbox" value="<%=info.getPasswd_identify()%>"></td>
				</tr> 
				<tr>
					<th>연락처</th>
					<td><select id="select" name="start_num" class="phone_text">
							<option value="010" selected="selected">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
							<option value="0139">0139</option>
					</select> <span>&nbsp-</span> <input type="text"  name="phone_second" class="phone_text"
						value="<%=info.getPhone_second()%>"> - <input type="text" name="phone_third"  class="phone_text"
						value="<%=info.getPhone_third()%>"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="button" onclick="sample6_execDaumPostcode()"
						value="우편번호 찾기"><br> <input type="text"
						class="textbox" id="sample6_address" name="sample6_address" value="<%=info.getSample6_address() %>"
						placeholder="   주소"><br> <input type="text"
						class="textbox" id="sample6_detailAddress" name="sample6_detailAddress" 
						value="<%=info.getSample6_detailAddress() %>" placeholder="   상세주소"></td>
				</tr>
				<tr>
					<th colspan="2">
						<p></p>이벤트메일링수신동의여부<input type="checkbox" name="mailrecv" class="checkbox">
					</th>
				</tr>
				<tr>
					<th colspan="2">이벤트문자메시지수신동의여부<input type="checkbox" name="smsrecv" 
						class="checkbox"></th>
				</tr>
			</table>
			<p></p>
			<p>
				<input type="submit" id="join_success" value="수정완료">
			</p>
	</form>
</body>

</html>