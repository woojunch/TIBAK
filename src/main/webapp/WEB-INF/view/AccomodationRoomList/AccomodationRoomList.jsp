<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Model.AccomodationRegisterDTO,java.util.*"%>
<% List <AccomodationRegisterDTO>accomodationRegisterList = (List)request.getAttribute("list"); %>
<link href="./CSS/AccomodationRoomList.css" rel="stylesheet" type="text/css">
<!doctype html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>ticket main</title>
   <script src="./JS/AccomodationDetail.js"></script>
</head>

<body>
  
  <div id="mainheader">
    <ul>
     <li onclick="play()">검색 ˇ</li>
     <li onclick="play()">지역 ˇ</li> 
     <li onclick="play()">가격 ˇ</li> 
     <li onclick="play()">예약상태 ˇ</li>    
    </ul>  
  </div>
  <div id="kingContent">
  <div id="registeRoom">
    
     <form  action="roomlistsearch" name="frm" method="post">
	
		<h2>숙소 검색하기</h2><br><br>
<script type="text/javascript">



</script>
		
		<div>
			<span>숙소 지역</span>

			<select name="area">
						<option>서울</option>
			            <option>경기</option>
			            <option>인천</option>
			            <option>강원</option>
			            <option>제주</option>
			            <option>대전</option>
			            <option>세종</option>
			            <option>충북</option>
			            <option>충남</option>
			            <option>부산</option>
			            <option>울산</option>
			            <option>경남</option>
			            <option>대구</option>
			            <option>경북</option>
			            <option>광주</option>
			            <option>전남</option>
			            <option>전북</option>
			              
				
			</select>
			
		</div>
		
		<div>
			<span>객실 종류</span>

			<select name="aProKind">
				<option>Deluxe</option>
				<option>Twin</option>
				<option>Suite</option>
				<option>Royal Suite</option>
				
			</select>
			
		</div>
		
		<div>
		<span>대실 가격</span>
		<input type="txet" name="aProPrice"style= width:100px; height:50px >원 ~ <input type="txet" name="aProPriceM"  style= width:100px; height:50px><br><br>
		<span>숙박 가격</span>
		<input type="txet" name=aProPrices style= width:100px; height:50px>원 ~ <input type="txet" name=aProPricesM  style= width:100px; height:50px>
		</div>
		
		<div>
		<span>조식 여부</span>
		<select name="aProMeal">
				<option>포함</option>
				<option>불포함</option>
			</select>
		
		</div>
		<div>
		<p>객실 인원</p>	
		<span>1명</span> ~ 
			
		<span><select name="proReserveBan">
			
				<%for(int a=01; a<=10; a++){ %>
				<option><%=a %></option>시
				<%} %>
			</select>명</span></div>
		
		
		
		<br>
		
		<div id="submit"><input type="submit" value="등록하기"></div>

</form>
     </div>
  
  <div id="mainscontent">
  <% if(accomodationRegisterList !=null){ %>
    
     <%for(int i=0; i<accomodationRegisterList.size(); i++){ %>
     
     <%  AccomodationRegisterDTO  accomodationRegisterDTO =accomodationRegisterList.get(i);%>
     <% String imgList[]=accomodationRegisterDTO.getFile().split("-");%>
    <div class="maincontent">
       
        <div id="masaka"><img src="./Accomodation/upfile1/<%=imgList[0]%>"></div>
       <div class="explain"><strong><%=accomodationRegisterDTO.getbFacilityName()%>(<%=accomodationRegisterDTO.getAproKind() %>)</strong></div>
       <div class="explain">기준 (2명)(최대 <%=accomodationRegisterDTO.getProReserveBan()%>명)</div>
       <div class="explain">조식: <%=accomodationRegisterDTO.getAproMeal()%> </div>
       <div class="explain"><%=accomodationRegisterDTO.getProAdTime() %> 입실 ~ <%=accomodationRegisterDTO.getProExTime() %> 퇴실</div>
       <div class="explain">대실 <span class="plz">예약특가</span><span><%=accomodationRegisterDTO.getProPrice()%></span></div>
       <div class="explain">숙박 <span class="plz">예약특가</span><span><%=accomodationRegisterDTO.getProPrices() %></span></div>
     
       <div class="explain" id="special">주소<h5><%=accomodationRegisterDTO.getbFaciltityAddr() %></h5></div>
       <div id="last">예약하기</div>
    </div> 
  <%} %>
 
  <%} %>
    </div>
    </div>
</body>

</html>