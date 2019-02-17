<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Model.*"%> 
<% List<TicketOrderDTO> orderList = (List<TicketOrderDTO>)request.getAttribute("orderList"); %>
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
    body{
    font-family: "Nanum Gothic", sans-serif;
}
#mypage_container{
    width:100%;
    /* background-color:indianred; */
    text-align:center;
}
#mypage_content{
    display:inline-block;
    width:80%;
    height:100%;
    /* background-color:greenyellow; */
}
#mypage_content_header{
    width:100%;
    height:100px;
    /* background-color:lightblue; */
}
#mypage{
    font-size:30px;
    float:left;
    padding:30px;
}
#mypage_menu{
    width:100%;
    /* background-color:ivory; */
    height:20px;
}
.mypage_menubar{
    float:left;
    width:50%;
    height:100%;
     background-color:rgb(231, 223, 223);  
    padding:20px 0px 20px 0px;
    font-size:20px;
}
#reserve_header{
    width:100%;
    /* background-color:lightcoral; */
    height:200px;
}
#reserve_menu_detail{
    float:right;
    width:50%;
    height:30px;
    /* background-color:lightgreen; */
}
.reserve_detail_menu{
    float:right;
    width:33.3%;
    height:100%;
     background-color:lightgoldenrodyellow; 
    font-size:20px;
}
#purchase_history{
    font-size:30px;
    float:left;
    padding-left:30px;
    margin-top:70px;
}
.concert_info{
    text-align:left;
    
}
.concert_img{
    float:left;
    margin-right:20px;
    margin:30px;
    width:100px;
}
.concert_subject{
    font-size:20px;
    padding:30px;
}
table{
    width:100%;
    border-collapse: collapse;
}

tr, td{
    /* border:1px solid black; */
    margin:0px;
    height:40px;
    border-bottom:1px solid rgb(165, 161, 161); 
}

</style>

<body>
   <jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <div id="mypage_container">
        <div id="mypage_content">
            <div id="mypage_content_header">
                <div id="mypage">마이페이지</div>
            </div>
            <div id="mypage_menu">
                <div class="mypage_menubar"><a href="#">기본정보관리</a></div>
                <div class="mypage_menubar" style="font-weight:bolder;"><a href="#">구매내역</a></div>
            </div>
            <div id="reserve_menu_detail">
                <div class="reserve_detail_menu">패키지</div>
                <div class="reserve_detail_menu">숙박</div>
                <div class="reserve_detail_menu" style="font-weight:bolder;">공연</div>
            </div>
            <div id="reserve_header">
                <div id="purchase_history">공연상품 구매내역</div>
            </div>
            <table>
                <tr>
                    <td style="width:12%;">예매일</td>
                    <td>공연정보</td>
                    <td style="width:20%;">예매정보</td>
                    <td style="width:10%;">상태</td>
                </tr>
                <%for(int i=0;i<orderList.size();i++){ %>
                <tr>
                    <td><%=orderList.get(i).getcDate().substring(0,11) %></td>
                    <td class="concert_info">
                        <img src="../upfile/<%=orderList.get(i).getImg() %>" class="concert_img">
                        <div class="concert_subject"><%=orderList.get(i).getConName() %></div>
                        <div><%=orderList.get(i).getConTerm() %></div>
                    </td>
                    <td>
                        <table>
                            <tr>
                                <td>주문번호</td>
                                <td><%=orderList.get(i).getoNum() %></td>
                            </tr>
                            <tr>
                                <td>관람일</td>
                                <td><%=orderList.get(i).getConDate() %></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <p>예매완료</p><button onclick="location.href='/tibak/order/orderDetail?oNum=<%=orderList.get(i).getoNum()%>'">예매상세 ></button>
                    </td>
                </tr>
                <%} %>
            </table>
        </div>
    </div>

    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html>