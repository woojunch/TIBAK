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
    width:100%;
/*     background-color: aquamarine; */
    text-align:center;
    box-sizing:border-box;
    margin-bottom:50px;
}
#content{
    display:inline-block;
    width:100%;
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
    width:80%;
    height:800px;
/*     background-color:lightgreen; */
}
table{
    width:100%;
}
tr, td{
    border:1px solid black;
}
</style>

<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <div id="container">
        <div id="content">
            <div id="table_box">
                        <div id="content_header">공연장리스트</div>
                <table>
                    <tr>
                        <td>공연장번호</td>
                        <td>공연장이름</td>
                        <td>최대수용인원</td>
                        <td>지역</td>
                        <td>주소</td>
                        <td>좌석행</td>
                        <td>좌석열</td>
                    </tr>
<c:forEach items="${conHallList }" var="conHallList">
                    <tr>
                        <td>${conHallList.num }</td>
                        <td>${conHallList.name }</td>
                        <td>${conHallList.capacity }</td>
                        <td>${conHallList.area }</td>
                        <td>${conHallList.addr }</td>
                        <td>${conHallList.row}</td>
                        <td>${conHallList.column}</td>
                    </tr>
</c:forEach>
<tr>
<td colspan="7"><button onclick="location.href='/tibak/concert/list'">공연상품 등록하기</button></td>
</tr>

                </table>

            </div>
        </div>
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>