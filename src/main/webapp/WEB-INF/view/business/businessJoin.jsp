<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>사업자회원가입</title>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic"
	rel="stylesheet">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>

$(document).ready(function () {

 
    //아이디는 영문,숫자만 입력
    $("#id").on('keyup', function () {
        var id = $("#id").val();
        var eng = /^[A-Za-z0-9+]*$/;
        if (!eng.test(id)) {
            $("#eng_error").show();
        } else {
            $("#eng_error").hide();
        }
    });

    //아이디는 4~12자
    $("#id").on('keyup', function () {
        var id = $("#id").val();
        if (id.length < 4 || id.length > 12) {
            $("#id_error").show();
        } else {
            $("#id_error").hide();
        }
    });

    //패스워드는 8~16자
    $("#passwd").on('keyup', function () {
        var passwd = $("#passwd").val();
        if (passwd.length < 8 || passwd.length > 16) {
            $("#pw_error").show();
        } else {
            $("#pw_error").hide();
        }
    });

    //패스워드 영문숫자특수문자조합
    $("#passwd").on('blur', function () {
        var passwd2 = $("#passwd").val();
        var pattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;
        if (!pattern.test(passwd2)) {
            $("#pw_error2").show();
        } else {
            $("#pw_error2").hide();
        }
    });

    //패스워드가 일치하는지 확인

    $("#passwd_identify").on('blur', function () {
        var pw = $('#passwd').val();
        var pw_identify = $('#passwd_identify').val();
        if (pw != pw_identify) {
            $("#identify_error").show();
        } else {
            $("#identify_error").hide();
        }
    });

    //전화번호 앞자리를 4글자입력하면 뒷자리 입력으로 커서가 넘어가고 5글자이상 입력불가
    $("#phone_second").on('keyup', function () {
        var phone_second = $('#phone_second').val();
        if (phone_second.length >= 4) {
            $("#phone_third").focus();
            $("#phone_second").val($("#phone_second").val().substring(0,4));
        }
    });

    //전화번호 뒷자리 5글자 이상 입력 불가
    $("#phone_third").on('keyup', function () {
        var phone_third = $('#phone_third').val();
        if (phone_third.length >= 4) {
            $("#phone_third").val($("#phone_third").val().substring(0,4));
        }
    });
});
</script>
</head>

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
	<form method="post">
		<div id="join_auth">
			<p>사업자 회원가입</p>
			<table>
				<tr>
					<th>인증번호</th>
					<td><input type="text" class="textbox" placeholder="   인증번호"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="button" id="re_send" value="인증번호 재전송">
						<p></p></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="textbox"
						placeholder="   아이디">
						<div class="error" id="id_error">4~12글자만 입력하세요</div>
						<div class="error" id="eng_error">영어,숫자만 입력하세요</div></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="passwd" class="textbox"
						placeholder="   비밀번호">
						<div class="error" id="pw_error">8~16글자만 입력하세요</div>
						<div class="error" id="pw_error2">영문,숫자,특수문자를 조합하세요</div></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="text" name="passwd_identify" class="textbox"
						placeholder="   비밀번호확인">
						<div class="error" id="identify_error">비밀번호가 일치하지 않습니다</div></td>
				</tr>
				<tr>
					<th>사업자이름</th>
					<td><input type="text" name="name" class="textbox"
						placeholder="   사업자이름"></td>
				</tr>
				<tr>
					<th>회사명</th>
					<td><input type="text" name="com_name" class="textbox"
						placeholder="   회사명"></td>
				</tr>

				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" class="textbox"
						placeholder="   이메일"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birth" class="textbox"
						placeholder="   생년월일"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><select name="start_num" class="phone_text">
							<option value="010" selected="selected">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
							<option value="0139">0139</option>
					</select> <span>&nbsp-</span> <input type="text" name="phone_second"  class="phone_text">
						- <input type="text" name="phone_third"  class="phone_text"></td>
				</tr>
			</table>
			<p></p>
			<p>
				<input type="submit" id="join_success" value="가입 완료">
			</p>
	</form>
</body>

</html>