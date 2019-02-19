<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="Model.AccomodationDTO,java.util.*"%>

<%
	List <AccomodationDTO>accomodationList = (List)request.getAttribute("list"); 
	%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>lodgment main</title>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Nanum+Gothic"
	rel="stylesheet">


<link href="../CSS/l_footer.css" rel="stylesheet" type="text/css">
<link href="../CSS/l_header.css" rel="stylesheet" type="text/css">
<link href="../CSS/l_main.css" rel="stylesheet" type="text/css">
<!--폰트(nav) 변경 -->

<script src="./JS/main.js">

    </script>
</head>
<body>
	<div id="header">
		<div id="header_menu">
			<ul>
				<li><a href="#">이용안내</a></li>
				<li><a href="#">고객센터</a></li>
				<li><a href="#">회원가입</a></li>
				<li><a href="#">로그인</a></li>
			</ul>
		</div>
		<div id="header_content">
			<div id="main_logo">
				<a href=""><img src="./img/tb.png" width="100%" height="100%"></a>
			</div>

			<div id="main_search">
				<fieldset>
					<input type="text" style="width: 400px; height: 35px;">
					<button type="button" id="btn_search">
						<img src="./img/btn_search_icon.png" alt="" width="20px"
							height="20px">
					</button>
				</fieldset>
			</div>
			<div id="event_banner">
				<a href=""><img src="./img/event.png" alt="" width="200px"
					height="70px"></a>
			</div>

		</div>
	</div>
	<!-- 요기까지 헤더 -->
	<div id="serarch">
		<img src="./img\mains.png" width="101.5%" height="350px">
	</div>
	<div id="mains">
		
	
		<div id="move">
			<h2>
				티박과 함께<br data-reactid="81"> <em data-reactid="82">오늘하루 </em>
				즐겨볼까요?
			</h2>
		</div>
		<div id="plz">
			<div class="first">
				<div id="mKind" class="model">객실유형</div>
				<button style="height: 60px; width: 100%;" onclick="play()"
					id="room">
					<img src="./img/img-roomtype-1.png">스위트룸
				</button>
			</div>
			<div class="first">
				<div id="model2" class="model">지역</div>
				<input id="local" style="height: 60px; width: 100%"; type="text" vlaue="[return value from play1 function]"
					onclick="play1()">서울</button>
			</div>
			<div class="first1">
				<div id="model3" class="model">최소 가격</div>
				<input style="height: 49px; width: 100%;" type="text">
				</button>
			</div>
			<div class="first1">
				<div id="model4" class="model">최대 가격</div>
				<input style="height: 49px; width: 100%;" type="text">
				</button>
			</div>
			<div class="first2">
				<button style="height: 104px; width: 105%;">숙소검색</button>
			</div>
		</div>
	</div>
	<div id="mKindList">
		<ul>
			<li onclick="insert1(this)"><a>Deluxe</a></li>
			<li onclick="insert1(this)"><a>Twin</a></li>
			<li onclick="insert1(this)"><a>Suite</a></li>
			<li onclick="insert1(this)"><a>Royal Suite</a></li>
		</ul>
	</div>
	<div id="mKindList1">
		<ul id="list">
			<li onclick="insert(this)"><a>서울</a></li>
			<li onclick="insert(this)"><a>경기</a></li>
			<li onclick="insert(this)"><a>인천</a></li>
			<li onclick="insert(this)"><a>강원</a></li>
			<li onclick="insert(this)"><a>제주</a></li>
			<li onclick="insert(this)"><a>대전</a></li>
			<li onclick="insert(this)"><a>세종</a></li>
			<li onclick="insert(this)"><a>충북</a></li>
		</ul>
		<ul>
			<li onclick="insert(this)"><a>충남</a></li>
			<li onclick="insert(this)"><a>부산</a></li>
			<li onclick="insert(this)"><a>울산</a></li>
			<li onclick="insert(this)"><a>경남</a></li>
			<li onclick="insert(this)"><a>대구</a></li>
			<li onclick="insert(this)"><a>경북</a></li>
			<li onclick="insert(this)"><a>광주</a></li>
			<li onclick="insert(this)"><a>전남</a></li>
			<li onclick="insert(this)"><a>전북</a></li>
		</ul>
	</div>
		
	<div id="contentHeader">
		
		<div class="cHeader">
			<img src="./img/roomss.jpg">
			<div class="icon"><a href="roomlist">객실</a></div>
		</div>
		<div class="cHeader">
			<img src="./img/concerts.jpg">
			<div class="icon">공연티켓</div>
		</div>
		<div class="cHeader">
			<img src="./img/packgeee.jpg">
			<div class="icon">패키지상품</div>
		</div>
	</div>
	<div id="content">

		<div id="plzs">
			<div id="content1">
				<div id="content1Box">
					<a href="Accomodation">내 숙소 등록</a>
				</div>
			</div>

			<ul id="slideShow">

				<%if(accomodationList!=null) {%>

				<%for(int i=0; i<accomodationList.size(); i++){ %>
				<% 
           AccomodationDTO  accomodationDTO =accomodationList.get(i);%>
                  <script type="text/javascript">
		
                  
	                	</script>
				<li><div class="um">
						
						
						<img
							src="./Accomodation/upfile/<%=accomodationDTO.getOrginalFile()%>" />
						<div class="masa" style="line-height:2em">
							<a href="detail?no=<%=accomodationDTO.getbFacilityNum()%>">
							<h2><%=accomodationDTO.getbFacilityName() %></h2></a>
							<p><%=accomodationDTO.getbFacilityArea() %></p>
							<h4><%=accomodationDTO.getbFacilityInform() %></h4>
						</div>

					</div></li>
				<%} %>
				<%}else{%>
				<li><div class="um">
						<img src="./Accomodation/upfile/%>" />
						<div class="masa">
							<h3>%></h3>
						</div>
						<div class="hon">숙소보기</div>
					</div></li>


				<%} %>
			</ul>
		</div>


		<div id="controll">
			<a href="javascript:slide('slideShow', 'left', 2)">◀</a> <a
				href="javascript:slide('slideShow', 'right', 2)">▶</a>
		</div>
	</div>

	<!--푸터-->
	<div class="footer">
		<div class="wrap_footer">

			<div class="foot_bot">
				<ul class="foot_com">
					<li><a href="">회사소개,,</a></li>
					<li><a href="">이용약관,,?</a></li>
					<li><a href="">이런거</a></li>
					<li><a href="">넣어야되나</a></li>
					<li><a href="">일단 만들어봄</a></li>
				</ul>
			</div>
			<div class="com_info">
				<span>회사이름</span> <span>회사주소</span> <span>회사대표</span> <span>사업자등록번호</span>
				<span>고객센터(평일주말,,,-ㅅ-</span>
			</div>
		</div>
	</div>
</body>

</html>