<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
</head>
<style>
    html, body{
    margin:0 auto;
    padding:0;
    text-align:center;
    font-family: "Nanum Gothic", sans-serif;
    background-color: rgba(252, 252, 252, 0.829);
}
#logo_box{
    width:100%;
    /* background-color: green;  */
    height:150px;
    padding-top:30px;
}
#join_logo{
    width:250px;
}
#join_auth{
    display: inline-block;
    background-color: white;
    width:400px;
    height:1100px;
    border:1px solid rgb(204, 198, 198);
    text-align:center;
    padding: 20px 50px 50px 50px;
}
p{
    font-size:30px;
}
table{
    width:100%;
}
tr, td{
    text-align:left;
    /* border:1px solid black;  */
    padding:7px 0px 7px 0px;
}
th{
    padding:0px 20px 0px 0px;
}
.textbox{
    width:300px;
    height:50px;
    border-radius:10px;
    border:1px solid rgb(204, 198, 198);
}
.checkbox{
    width:20px;
    height:20px;
    float:right;
}
.auth_email{
    width:49%;
    height:50px;
    background-color:rgb(51, 192, 51);
    font-size:20px;
    color:white;
    border:0px;
}
</style>

<body>
    <div id="logo_box">
        <img src="./img/tb.png" id="join_logo">
    </div>
    <div id="join_auth">
            <p>회원가입</p>
        <form>
        <table>
            <tr>
                <th colspan="2">
                <p></p>
                </th>
            </tr>
            <tr>
                <th colspan="2">
                    입력한 이메일로 인증 후 회원가입 됩니다.
                    <p></p>
                </th>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" id="email" class="textbox"></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" id="name" class="textbox"></td>
            </tr>
            <tr>
                <th colspan="2">
                    <p></p>
                </th>
            </tr>
            <tr>
                <th colspan="2">
                    <p></p>
                </th>
            </tr>
            <tr>
                <th colspan="2">
                    <p></p>
                </th>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" class="auth_email" id="join_success" value="일반회원">
                    <input type="submit" class="auth_email" id="join_success" value="사업자회원">
                </th>
            </tr>

        </table>
    </form>
    </div>
</body>

</html>