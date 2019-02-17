<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    body {
        font-family: "Nanum Gothic", sans-serif;
    }

    #register_container {
        width: 100%;
        
/*         background-color: lightblue; */
        text-align: center;
    }

    #register_content {
        display: inline-block;
        width: 80%;
        height: 100%;
/*         background-color: lightgreen; */
        box-sizing: border-box;
    }

    #content_header {
        width: 100%;
        height: 100px;
/*         background-color: lightcoral; */
        text-align: left;
        box-sizing: border-box;
        padding: 30px;
        font-size: 30px;
    }

    #form_box {
        width: 100%;
/*         background-color: aquamarine; */
        text-align: center;
        margin-bottom:50px;
        box-sizing:border-box;
    }

    table {
        width: 100%;
    }

    tr,
    td {
        border: 1px solid black;
    }
</style>
<script>
function conHallSearch(){
	var url="/tibak/conhall/popuplist";
	window.name="parentForm";
	window.open(url, "childForm","toolbar=no, location=no,status=no,menubar=no, scrollbars=no,resizable=no,width=600, height=500");
	 
}
</script>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
    <!-- 요기까지 헤더 -->

    <div id="register_container">
        <div id="register_content">
            <div id="content_header">
                <div>상품등록</div>

            </div>
            <div id="form_box">
            <form action="/tibak/ticket/register" method="post" enctype="multipart/form-data">
                <table>
                	<tr>
                		<td>공연번호</td>
                		<td><%=request.getParameter("conNum") %><input type="hidden" name="num" value="<%=request.getParameter("conNum")%>"></td>
                    <tr>
                        <td>상품명</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>상품이미지</td>
                        <td><input type="file" name="img"></td>
                    </tr>
              	    <tr>
                        <td>상품설명</td>
                        <td><input type="file" name="content"></td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td><input type="text" name="price"></td>
                    </tr>
                     <tr>
                        <td>공연장</td>
                        <td><input type="button" onclick="conHallSearch();" value="공연장조회"><input type="text" name="conhallNum" id="conhallNum"></td>
                    </tr>
                    <tr>
                        <td>연락처</td>
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td>예매안내</td>
                        <td><input type="text" name="reserveInform"></td>
                    </tr>
                   <tr>
                        <td>이용안내</td>
                        <td><input type="text" name="useInform"></td>
                    </tr>
                   <tr>
                        <td>최대예매수제한</td>
                        <td><input type="text" name="reserveBan"></td>
                    </tr>
                      <tr>
                        <td>공연시간</td>
                        <td><input type="text" name="adTime">~<input type="text" name="exTime"></td>
                    </tr>
              		<tr>
                        <td>공연기간</td>
                        <td><input type="date" name="startConTerm">~<input type="date" name="endConTerm"></td>
                    </tr>
        			<tr>
                        <td>공연날짜</td>
                        <td><input type="date" name="conDate"></td>
                    </tr>
              		<tr>
                        <td>판매기간</td>
                        <td><input type="date" name="startSaleTerm">~<input type="date" name="endSaleTerm"></td>
                    </tr>
                    <tr>
                        <td>관람나이제한</td>
                        <td><input type="text" name="ageBan"></td>
                    </tr>
	                <tr>
                        <td>관람시간</td>
                        <td><%=request.getParameter("viewTime") %><input type="hidden" name="viewTime"  value="<%=request.getParameter("viewTime")%>"> </td>
                    </tr> 
                    <tr>
                        <td>테마</td>
                        <td><select name="genre">
  							  <option value=" ">테마선택</option>
  							  <option value="내한공연">내한공연</option>
 							  <option value="아이돌">아이돌</option>
  							  <option value="홍대/소극장">홍대/소극장</option>
  							  <option value="효 콘서트">효 콘서트</option>
  							  <option value="페스티벌/콜라보">페스티벌/콜라보</option>
							</select>
						</td>
                    </tr>
                    <tr>   
                    <td colspan="2"><input type="submit" value="등록"></td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    </div>



    <!--푸터-->
<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>

</html></body>
</html>