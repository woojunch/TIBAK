<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Model.*"%> 
<% ConHallDTO dto = (ConHallDTO)request.getAttribute("conhalldto"); 
	String proNum = (String)request.getAttribute("proNum");
	List<Integer> seatNum = (List<Integer>)request.getAttribute("seatNum");
	String name = (String)request.getParameter("name");
	String rowNum = (String)request.getParameter("rowNum");
	String columnNum = (String)request.getParameter("columnNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic" rel="stylesheet">
</head>
<script>
var rowNum=0;
var columnNum=0;
function podo(row, column){
	document.getElementById("podoall_"+row+"_"+column).style.backgroundColor="rgb(137, 69, 248)";
	if(rowNum!=0&columnNum!=0){
		document.getElementById("podoall_"+rowNum+"_"+columnNum).style.backgroundColor="#ccc";
	}
	rowNum=row;
	columnNum=column;
	location.href="/tibak/seatChoice?name=<%=name%>&proNum=<%=proNum%>&hallNum=<%=dto.getNum()%>&rowNum="+rowNum+"&columnNum="+columnNum;
}
</script>
<style>
#container{
	width:100%;
	height:100%;
	text-align:center;
	font-family: "Nanum Gothic", sans-serif;
}
.podoall{
	width:20px; 
	float:left; 
	height:20px; 
	margin:1px; 
	background-color:#ccc; 
	border:1px solid #ccc;
}
.purchasedPodoall{
	width:20px; 
	float:left; 
	height:20px; 
	margin:1px; 
	background-color:red; 
	border:1px solid red;
}
#stage{
	display:inline-block;
	width:300px;
	height:40px;
	border:1px solid black;
	text-align:center;
	box-sizing:border-box;
	margin:30px;
	padding:8px;
	font-size:20px;
}
#seatChoice{
	width:100%;
	height:100%;
	box-sizing:border-box;
	padding:10px;
	font-size:20px;
	text-align:left;
	background-color:#ccc;
	
}
.step{
	width:100%;
	height:100%;
}
#seatMap{
	display:inline-block;
}
#podoall_<%=rowNum%>_<%=columnNum%>{
	background-color:rgb(137, 69, 248);
}
#choiceButton{
	display:inline-block;
	margin:30px;
}
</style>
<body>
<div id="container">
<div id="seatChoice">
 
	<div class="step">좌석선택 : <%=name %></div>
	<% if(rowNum!=null&columnNum!=null){%>
	<%=rowNum%>행&nbsp;<%=columnNum%>열
	<%} %>
</div>
	<div id="stage">STAGE</div><br>
	<div id="seatMap">
	<%	int k=0; int a=0;%>
	<% for(int i=1;i<=dto.getRow();i++){	%>
 		<% for(int j=1;j<=dto.getColumn();j++){%>
			<% k++;
			if(seatNum.get(a)==k) { %> 
				<div class="purchasedPodoall"></div>
 				<% if(a<seatNum.size()-1){
 					a++;
 					}
 				} else{ %>
				<div class="podoall" id="podoall_<%=i%>_<%=j%>" onclick="podo(<%=i%>,<%=j%>)"></div>
				<% 
 				}
			} %>
			<br>
	<% 	}%>
	</div><br>
	<div id="choiceButton">
		<form action="/tibak/buyPage" method="post">
			<input type="hidden" name="proNum" value="<%=proNum%>">
			<input type="hidden" name="rowNum"  value="<%=rowNum%>">
			<input type="hidden" name="columnNum" value="<%=columnNum%>">
			<input type="submit" value="좌석선택완료">
		</form>
	</div>
</div>
</body>
</html>