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
    font-family: "Nanum Gothic", sans-serif;
    width:100%;
    height:1200px;
/*     background-color: aquamarine; */
    text-align:center;
}
#content{
    display:inline-block;
    width:80%;
    height:100%;
/*     background-color:lightblue; */
    text-align:center;
}
#content_header{
    width:100%;
    height:100px;
/*     background-color:lightcoral; */
    padding:30px;
    box-sizing:border-box;
    text-align:left;
    font-size:30px;

}
#table_box{
    display:inline-block;
    width:100%;
    height:800px;
/*     background-color:lightgreen; */
}
table{
    width:100%;
}
td{
    border:1px solid black;
}
</style>

<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <div id="container">
        <div id="content">
            <div id="content_header">공연리스트</div>
            <div id="table_box">
                <table>
                    <tr>
                        <td>공연번호</td>
                        <td>공연명</td>
                        <td>상영시간(분)</td>
                        <td>기획사정보</td>
                        <td>상품등록</td>
                    </tr>
<c:forEach items="${conList }" var="conList">
                    <tr>
                        <td>${conList.num }</td>
                        <td>${conList.name }</td>
                        <td>${conList.showTime }</td>
                        <td>${conList.managementInform}</td>
                        <td><button onclick="location.href='/tibak/ticket/register?conNum=${conList.num}&viewTime=${conList.showTime }'">등록</button>
                        </td>
                    </tr>
</c:forEach>
				<tr>
				<td colspan="5"><button onclick="location.href='/tibak/concert/register'">공연목록추가하기</button>
				<button onclick="location.href='/tibak/conhall/register'">공연장등록하기</button></td>
				</tr>
                </table>

            </div>
        </div>
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>