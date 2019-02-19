<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Model.AccomodationDTO,java.util.*"%>
<%@page import="Model.AccomodationRegisterDTO,java.util.*"%>

<% List <AccomodationDTO>accomodationList = (List)request.getAttribute("list"); 
	%>
<% List <AccomodationRegisterDTO>accomodationRegisterList = (List)request.getAttribute("list1"); 
int count=4;	
	%>	

<link href="./CSS/AccomodationDetail.css" rel="stylesheet" type="text/css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./JS/AccomodationDetail.js"></script>
</head>

<body>
<div id="header"></div>
    <div id="main"><img src="./img/rooms1.jpg" width="100%" height="350px"></div>
    <div id="content">
       
    <% if(accomodationList !=null){ %>
     <%for(int i=0; i<accomodationList.size(); i++){ %>
     
     <%  AccomodationDTO  accomodationDTO =accomodationList.get(i);%>
    
     <div id="registeRoom">
    
     <form  action="register" name="frm" method="post" enctype="multipart/form-data" >
	
		<h2>숙박 등록</h2><br><br>
<script type="text/javascript">



</script>
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
		<input type="txet" name="aProPrice">원<br><br>
		<span>숙박 가격</span>
		<input type="txet" name=aProPrices>원
		</div>
		
		<div>
		<span>조식 여부</span>
		<select name="aProMeal">
				<option>포함</option>
				<option>불포함</option>
			</select>
		
		</div><br>
		<div>
		<p>객실 인원</p>	
		<span>1명</span> ~ 
			
		<span><select name="proReserveBan">
			
				<%for(int a=01; a<=10; a++){ %>
				<option><%=a %></option>시
				<%} %>
			</select>명</span></div>
		
		<div>
		<p>입실 퇴실 시간</p>
		
		<span><select name="proAdTime1">
				<option>AM</option>
				<option>PM</option>
			</select></span>
			
		<span><select name="proAdTime2">
			
				<%for(int a=01; a<=24; a++){ %>
				<option><%=a %></option>시
				<%} %>
			</select>시</span>
		
		<span><select name="proAdTime3">
				
				<%for(int a=1; a<=60; a++){ %>
				<option><%=a %></option>
				<%} %>
			</select>분</span> ~	 
		
			<span><select name="proExTime1">
				<option>AM</option>
				<option>PM</option>
			</select></span>
			
		
		<span><select name="proExTime2">
				<%for(int a=01; a<=24; a++){ %>
				<option><%=a %></option>시
				<%} %>
			</select>시</span>
		
		<span><select name="proExTime3">
				<%for(int a=1; a<=60; a++){ %>
				<option><%=a %></option>
				<%} %>
			</select>분</span> 	
			
		</div>
		<br>
		
	

		
		<p>사진등록</p>
		
		<img id="lastone"src="./img/sunny.jpg" width="5%" height="30px" onclick="insRow()">
		<table id="addTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0">
            <tr>
              <td></td>
              <td align="left"></td>
            </tr>
          </table>
		
		<input type="hidden" name="num" value="<%=accomodationDTO.getbFacilityNum()%>">
		<div id="submit"><input type="submit" value="등록하기"></div>

</form>
     </div>
     
     
     <div id="forehead">
            <ul>
                    <li><h2><%=accomodationDTO.getbFacilityName() %></h2></li>
                    <li><h4><%=accomodationDTO.getbFaciltityAddr()%></h4></li>
                    <li><h6>이용가능한 객실수: <%=accomodationDTO.getbFacilityRoom() %></h6></li>
                    <li><h4><span>당일예약취소가능</span><span>현장적립</span><span>최저가보상</span></h4></li>
                    <li class="special"><img src="./img/v.PNG">미리예약시 1% 적립</li>
                    <li class="special"><img src="./img/v.PNG">당일예약 건 입실 3시간 전까지 100% 환불가능</li>
                    <li class="special"><img src="./img/v.PNG">정보제공</li>
        
                </ul>
     </div>
     <%} %>
     <%} %>
     <div id="choice"> <div class="makeChoice" onclick="play()">객실 추가</div> <div class="makeChoice">후기</div></div>
    
     
     
    <% if(accomodationRegisterList !=null){ %>
     <%for(int i=0; i<accomodationRegisterList.size(); i++){ %>
     
     <%AccomodationRegisterDTO accomodationRegisterDTO=accomodationRegisterList.get(i);
     String images[]=accomodationRegisterDTO.getFile().split("-");
    
     count++;
     %> 
     

     <div class="contents"><div class="imgBox"><img id="imgs" src="./Accomodation/upfile1/<%=images[0]%>"width="100%" height="220px">
     <a  onclick="minus(<%=count%>)">◀</i> <a  onclick="plus(<%=count%>)">▶</a></div>
    
			
		
    <div id="first"><strong><%=accomodationRegisterDTO.getAproKind()%></strong><p>기준 2명(최대<%=accomodationRegisterDTO.getProReserveBan()%>명)</p>
    <p><%=accomodationRegisterDTO.getProAdTime() %> 입실 ~ <%=accomodationRegisterDTO.getProExTime() %> 퇴실</p>

    </div>
   
    <div class="pay">대실  <span class="price"><%=accomodationRegisterDTO.getProPrice()%></span>원(<b>최대 4시간</b>)</div>
    <div class="pay">숙박 <span class="price"><%=accomodationRegisterDTO.getProPrices()%></span>원(<b>조식 <%=accomodationRegisterDTO.getAproMeal()%></b>)</div>
    <div id="last">예약하기</div>
    
    </div>
    <script>
  
    var ss=0;
    function plus(a){
    	var i=a-5;
    	var list = new Array();
    	
    	<%for(int b=0; b<accomodationRegisterList.size(); b++){%>
    	
    	 list.push("<%=accomodationRegisterList.get(b).getFile()%>");
    	<%}%>
    	
    	var A="<%=accomodationRegisterDTO.getFile()%>";
    	   var b=list[i].split("-");
 
    	ss++
    	if(ss==b.length-1){
    		ss=0;}
    	
    	   document.getElementsByTagName("img")[a].src="./Accomodation/upfile1/"+b[ss];	
    }
    
    function minus(a){
    	var i=a-5;
       <% accomodationRegisterDTO=accomodationRegisterList.get(i);%>
    	
    	   var A="<%=accomodationRegisterDTO.getFile()%>";
    	   var b=A.split("-");
    	
    	--ss; 
    	if(ss<0){
    		ss=b.length-2
    	 } 
    	document.getElementsByTagName("img")[a].src="./Accomodation/upfile1/"+b[ss];
    }
   
   
     </script>
    <%} %>
  <%}else { %>
    
 
  
 <%} %>

    
    
   
 
  



</body>

</body>
</html>