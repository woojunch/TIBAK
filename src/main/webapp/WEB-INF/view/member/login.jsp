<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>로그인</title>
</head>
<style>
html, body, p {
	margin: 0;
	padding: 0;
}

#login_header {
	width: 100%;
	height: 230px;
	/* background-color:red; */
	text-align: center;
	padding-top: 100px;
}

#login_logo {
	width: 300px;
	margin: 0 auto;
}

#login_container {
	width: 100%;
	height: 800px;
	/* background-color:pink; */
	text-align: center;
	margin: 0 auto;
}

#login_content {
	display: inline-block;
	/* background-color:green; */
	width: 400px;
	padding: 0px;
}

input {
	width: 100%;
	height: 50px;
	border-radius: 5px;
	border: 1px solid rgb(204, 198, 198);
}

#login_menu {
	width: 100%;
	height: 60px;
	text-align: center;
}

ul li {
	float: right;
	list-style: none;
	font-size: 12px;
	margin-left: 3px;
}

#login_button {
	font-size: 20px;
	background-color: white;
	border: 1px solid green;
	color: green;
}
</style>

<body>
	<div id="login_header">
		<img src="./img/tb.png" id="login_logo">
	</div>
	<form method="post">
		<div id="login_container">
			<div id="login_content">
				<input type="text" name="id" placeholder="    아이디" /><br> <input
					type="password" name="password" placeholder="    비밀번호" /><br>
				<div id="login_menu">
					<ul>
						<li>회원가입</li>
						<li>|</li>
						<li>비밀번호 찾기</li>
						<li>|</li>
						<li>아이디 찾기</li>
					</ul>
				</div>
				<input type="submit" id="login_button" value="로그인">
			</div>
		</div>
	</form>
</body>
</html>