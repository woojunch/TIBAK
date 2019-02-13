<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, Model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<ConHallDTO> list=(List<ConHallDTO>)request.getAttribute("conHallList"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
tr,td{
	border:1px solid black;
}
</style>
<script>
function conHallSelect(num){
	opener.document.getElementById("conhallNum").value=num;
	window.close();
	
}
</script>
<body>
공연장선택
      <table>
                    <tr>
                        <td>공연장번호</td>
                        <td>공연장이름</td>
                        <td>좌석수</td>
                        <td>주소</td>
                        <td>좌석행</td>
                        <td>좌석열</td>
                    </tr>
                   <%for(int i=0;i<list.size();i++){ %>
                     <tr>
                        <td><a href="#" onclick="conHallSelect('<%=list.get(i).getNum()%>');"><%=list.get(i).getNum()%></a></td>
                        <td><%=list.get(i).getName()%></td>
                        <td><%=list.get(i).getCapacity()%></td>
                        <td><%=list.get(i).getAddr() %>
                        <td><%=list.get(i).getRow()%></td>
                        <td><%=list.get(i).getColumn()%></td>
                    </tr>
					<%} %> 
                </table>
</body>
</html>