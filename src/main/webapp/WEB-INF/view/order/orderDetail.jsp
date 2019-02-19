<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<% OrderDetailDTO detail = (OrderDetailDTO) request.getAttribute("detail"); %>
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
#detail_container{
    width:100%;
    height:1650px;
    /* background-color:lightblue;   */
    text-align:center;
}
#detail_content{
    display:inline-block;
    width:80%;
    height:100%;
    /* background-color:lightgreen; */
}
#detail_header{
    width:100%;
    height:450px;
    /* background-color:lightpink; */
    text-align:center;
    box-sizing:border-box;
    padding:30px;
    margin:30px 0px 60px 0px;
}
#detail_header_table{
    width:100%;
    height:100%;
    /* background-color:lightskyblue; */
    display:inline-block;
    box-sizing: border-box;
}
#detail_header_table table{
    width:100%;
    height:100%;
    border:1px solid #ccc;
    box-sizing:border-box;
    padding:30px;
}

table{
    width:100%;
    height:100%;
    border:1px solid #ccc;
    box-sizing:border-box;
}
table button{
    width:180px;
    font-size:15px;
    background-color:white;
    border:1px solid #ccc;
}
tr, td{
    /* border:1px solid black; */
    text-align:left;
    padding-left:30px;
}
#buy_info_text{
    width:100%;
    height:50px;
    /* background-color:lightskyblue; */
    text-align:left;
    font-size:30px;
}
#buy_info_box{
    width:100%;
    height:300px;
    font-size:20px;
    box-sizing:border-box;
    padding:30px;
    /* background-color:lightsalmon; */
    margin-bottom:60px;
}
.buy_info_list{
    background-color:rgb(238, 234, 234);
}
#notice_info_text{
    width:100%;
    height:50px;
    /* background-color:lightskyblue; */
    text-align:left;
    font-size:30px;
}
#notice_info_box{
    width:100%;
    height:350px;
    /* background-color:green; */
    text-align:left;
    color:gray;
    box-sizing:border-box;
    border:1px solid ccc;
    padding:30px;
}
#notice_info_content{
    background-color:rgb(238, 234, 234);
    box-sizing:border-box;
    padding:10px 0px 10px 0px;
}
#notice_info_box ul li{
    margin-bottom:10px;
    font-size:15px;
}
#list_button_box{
    width:100%;
    height:100px;
    text-align:center;
    box-sizing:border-box;
    padding:30px;
    /* background-color:lightcyan; */
}
#list_button_box button{
    width:250px;
    font-size:20px;
    background-color:white;
    border:1px solid #ccc;
    padding:10px;
}
</style>

<body>
  <jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->
    <div id="detail_container">
        <div id="detail_content">
            <div id="detail_header">
                <div id="detail_header_table">
                    <table>
                        <tr>
                            <td rowspan="6" style="width:200px;"><img src="../upfile/<%=detail.getImg() %>" id="concert_img"></td>
                            <td colspan="4" style="font-size:30px; font-weight:border;"><%=detail.getProName() %></td>
                        </tr>
                        <tr>
                            <td colspan="4"><button>관람후기 작성하기 ></button></td>

                        </tr>
                        <tr>
                            <td>예매번호</td>
                            <td><%=detail.getoNum() %></td>
                            <td>공연장</td>
                            <td><%=detail.getHallName() %></td>
                        </tr>
                        <tr>
                            <td>예매일시</td>
                            <td><%=detail.getBuyDate() %></td>
                            <td>관람일시</td>
                            <td><%=detail.getConDate() %></td>
                        </tr>
                        <tr>
                            <td>관람일시</td>
                            <td>2019.2.22 20:00</td>
                            <td>상태</td>
                            <td>예매완료</td>
                        </tr>
                        <tr>
                            <td>좌석</td>
                            <td><%=detail.getSeatNum() %></td>
                            <td>공연시간</td>
                            <td><%=detail.getShowTime() %> 분</td>
                        </tr>
                    </table>
                </div>
            </div>

            <div id="buy_info_text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;결제정보</div>
            <div id="buy_info_box">
                <table>
                    <tr>
                        <td class="buy_info_list">결제금액</td>
                        <td><%=detail.getPrice() %></td>
                    </tr>
                    <tr>
                        <td class="buy_info_list">결제방법</td>
                        <td>카드</td>
                    </tr>
                    <tr>
                        <td class="buy_info_list">카드명</td>
                        <td><%=detail.getCardName() %>/<%=detail.getCardNum().substring(0,6) %>*******</td>
                    </tr>
                </table>
            </div>
            <div id="notice_info_text">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;유의사항</div>
            <div id="notice_info_box">
                <div id="notice_info_content">
                    <ul>
                        <li>취소마감시간 이후 또는 관람일 당일 예매하신 건에 대해서는 취소/변경/환불이 불가합니다.</li>
                        <li>예매수수료는 예매 당일 밤 12시 이전까지 취소 시 환불 가능합니다.</li>
                        <li>배송이 시작된 경우 취소마감시간이전까지 멜론티켓 고객센터로 티켓을 반환해주셔야 환불이 가능하며, 도착한 일자 기준으로 취소수수료가 부과됩니다.<br>(* 단,
                            반환된 티켓의 배송료는 환불되지 않으며 일괄배송 상품의 경우 취소에 대한 자세한 문의는 고객센터로 문의해 주시기 바랍니다.)</li>
                        <li>지역 및 배송서비스 사정에 따라 배송사가 변경될 수 있으며, 배송일이 추가적으로 소요될 수 있습니다. (CJ대한통운, 우체국 외 1개 업체)</li>
                        <li>일괄배송의 경우 공연 별로 배송일자가 상이하며 지정된 배송일자 기준으로 배송이 시작됩니다.<br>(* 지정된 배송일자는 상세정보 및 예매공지사항에서 확인할 수
                            있습니다.)</li>
                        <li>예매취소 시점과 결제 시 사용하신 신용카드사의 환불 처리기준에 따라 취소금액의 환급방법과 환급일은 다소 차이가 있을 수 있습니다.</li>
                        <li>신용카드 할부결제로 구매하신 티켓 수량의 일부를 취소하실 경우, 신용카드사의 사정에 따라 혜택(무이자 할부 등)의 적용 여부가 달라질 수 있음을 유의하시기
                            바랍니다.</li>
                        <li>기타 문의사항은 이용안내를 참조하시거나 고객센터 1899-0042 혹은 1:1문의를 이용하시기 바랍니다.</li>
                    </ul>
                </div>
            </div>
            <div id="list_button_box">
                    <button onclick="location.href='/tibak/order/orderhistory'">목록으로 돌아가기</button>
                </div>
        </div>
    </div>
    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>