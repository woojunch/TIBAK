<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <div id="content_header">공연상품리스트</div>
            <div id="table_box">
                <table>
                    <tr>
                        <td>상품번호</td>
                        <td>상품이미지</td>
                        <td>공연날짜</td>
                        <td>상품명</td>
                        <td>상품올리기</td>
                    </tr>
<c:forEach items="${ticketList }" var="ticketList">
            <form action="/tibak/ticket/mainview" method="post">
                    <tr>
                        <td>${ticketList.proNum }</td><input type="hidden" name="proNum" value="${ticketList.proNum }">
                        <td><img style="width:100px" src="../upfile/${ticketList.storeImg }"></td> <input type="hidden" name="proImg" value="${ticketList.storeImg }">
                        <td>${ticketList.conDate }</td><input type="hidden" name="conDate" value="${ticketList.conDate }">
                        <td>${ticketList.name }</td><input type="hidden" name="name" value="${ticketList.name }">
                        <td><input type="submit" value="상품올리기"></td>
                    </tr>
            </form>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>