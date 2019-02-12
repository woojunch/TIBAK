<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Javascript Slide Example</title>

<link href="./CSS/Accomodation.css" rel="stylesheet" type="text/css">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./JS/Accomodation.js"></script>
</head>

<form method="post" enctype="multipart/form-data">
	<div id="accomodation">
		<h2>숙박 등록</h2>

		<div>
			<p>숙박시설명</p>

			<input name="bFacilityName" id="name" type="text" size="10"
				maxlength="10" value="" />
		</div>
		<div>
			<p>객실수</p>
			<select name="bFacilityRoom">
				<option>5</option>
				<option>10</option>
				<option>15</option>
				<option>20</option>
				<option>25</option>
				<option>30</option>
			</select>
		</div>

		<div class="addreses">
			<p>숙박시설 주소</p>
			<input class="address" type="text" id="sample6_postcode"
				placeholder="우편번호"> <input class="address" type="button"
				onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>

			<input class="address" type="text" id="sample6_address"
				placeholder="주소" name="address"><br> <input
				class="address" type="text" id="sample6_detailAddress"
				placeholder="상세주소" name="addressDetail">
		</div>
		<div>
			<p>숙박시설 정보</p>
			<textarea name="bFacilityImform" cols="67" rows="15"></textarea>
		</div>

		<div>
			<p>파일 첨부</p>
			<input name="boardFile" type="file" />
		</div>
		<input type="submit" value="전송">

	</div>
</form>
</body>

</html>