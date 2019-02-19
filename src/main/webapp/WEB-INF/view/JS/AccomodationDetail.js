var su=1;
var su1=1
var d;
var oTbl;

//////////////////////////////////////메인해더/////////////////////////////////////////////// 

function play(){
	var nam = document.getElementById("registeRoom");

	
       nam.style="display:inline";


	if(su%2==0){
		nam.style="display:none";

	}
	su++;
}





//Row 추가
function insRow() {
  oTbl = document.getElementById("addTable");
  var oRow = oTbl.insertRow();
  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = oRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=file name=boardFile style=width:350px; height:20px;> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}
//Row 삭제
function removeRow() {
  oTbl.deleteRow(oTbl.clickedRowIndex);
}

