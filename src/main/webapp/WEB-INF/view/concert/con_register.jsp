<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공연등록</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
    <!--폰트(nav) 변경 -->
    <link href="../CSS/t_header.css" rel="stylesheet" type="text/css">
    <link href="../CSS/t_footer.css" rel="stylesheet" type="text/css">
</head>
<style>
    body {
        font-family: "Nanum Gothic", sans-serif;
    }

    #register_container {
        width: 100%;
        height: 1800px;
/*         background-color: lightblue; */
        text-align: center;
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
                <div>공연등록</div>

            </div>
            <div id="form_box">
            <form action="/tibak/concert/register" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>공연명</td>
                        <td><input type="text" class="input" name="name"></td>
                    </tr>
					<tr>
						<td>상영시간</td>
						<td><input type="text" class="input" name="showTime"></td>
					</tr>
					<tr>
						<td>기획사명</td>
						<td><input type="text" class="input" name="managementInform"></td>
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
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html></body>
</html>