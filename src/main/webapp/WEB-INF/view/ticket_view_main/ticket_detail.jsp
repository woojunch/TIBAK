<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.*"%>
<% 	AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo"); 
	TicketDTO dto = (TicketDTO)request.getAttribute("dto");
	System.out.println(dto.getProNum());
	System.out.println(dto.getName());
	System.out.println(dto.getPrice());

%>
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
<script>
function login(){
	alert("로그인 후 이용하세요");
	location.href='/tibak/login';	
}

function seatChoice(){
	var url='/tibak/seatChoice?name=<%=dto.getName()%>&proNum=<%=dto.getProNum()%>&hallNum=<%=dto.getHallNum()%>';
		window.name="parentForm";
		window.open(url, "childForm","toolbar=no, location=no,status=no,menubar=no, scrollbars=no,resizable=no,width=700, height=800");
		
}
</script>
<style>
body{
    font-family: "Nanum Gothic", sans-serif;
}
#detail_container{
    width:100%;
/*     background-color:lightblue;    */
    text-align:center;
}
#detail_content{
    display:inline-block;
    width:80%;
    height:100%;
/*     background-color:lightgreen; */ 
}
#detail_header{
    width:100%;
    height:450px;
/*     background-color:lightpink; */
    text-align:center;
    box-sizing:border-box;
    padding:30px;
    margin:30px 0px 60px 0px;
}
#detail_header_table{
    width:100%;
    height:100%;
/*     background-color:lightskyblue; */
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
.detail_time{
/* 	background-color:pink; */
	width:100%;
	text-align:left;
	box-sizing:border-box;
	margin-bottom:60px;
}
.infobox{
	border:1px solid #ccc;
	box-sizing:border-box;
	padding:20px;
	font-size:20px;
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
span{
	font-size:15px;	
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
                            <td rowspan="6" style="width:200px;"><img src="../upfile/${dto.storeImg }" style="width:190px;" id="concert_img"></td>
                            <td colspan="4" style="font-size:30px; font-weight:border;">${dto.name }</td>
                        </tr>
                        <tr>
                            <td>공연날짜</td>
                            <td>${dto.conDate }</td>
                            <td>공연장</td>
                            <td>${dto.hallName }</td>
                        </tr>
                        <tr>
                            <td>관람시간</td>
                            <td>${dto.viewTime }분</td>
                            <td>관람등급</td>
                            <td>${dto.ageBan }세 이상</td>
                        </tr>
                        <tr>
                            <td>장르</td>
                            <td>${dto.genre }</td>
                            <td colspan="2">
                            <% if(authInfo!=null){ %>
                            <button onclick="seatChoice();">예매하기</button>
                            <%} else{ %>
                            <button onclick="login();">예매하기</button>
                            <%} %>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="detail_time">
          	 <h3>공연일정</h3>
          	 <div class="infobox">
            공연기간&nbsp;&nbsp;:&nbsp;&nbsp;<span>${dto.conTerm }</span><br><br>
            공연시간&nbsp;&nbsp;:&nbsp;&nbsp;<span>${dto.adTime } ~ ${dto.exTime }</span>
            </div>
            </div>
            <div class="detail_time">
            <h3>가격</h3>
            <div class="infobox">
            ${dto.price } 원
            </div>
            </div>
            <div class="detail_time">
            <h3>작품설명</h3>
            <img src="../upfile/${dto.storeContent }">
            </div>
        
        </div>
    </div>
    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>