var su=1;
var su1=1
var nam = document.getElementById("mKindList");

//////////////////////////////////////메인해더/////////////////////////////////////////////// 

function play(){

	var nam = document.getElementById("mKindList");
	nam.style="display:inline";
    

	if(su%2==0){
		nam.style="display:none";

	}
	su++;
}
function play1(){

	nams = document.getElementById("mKindList1");

	nams.style="display:inline";

	if(su1%2==0){
		nams.style="display:none";}

	su1++;
}
function insert(i){

	var local= document.getElementById("local");
	local.innerHTML=i.innerHTML;
	nams = document.getElementById("mKindList1");
	nams.style="display:none";
	su1++;
   return local.innerHTML;
}

function insert1(i){

	var local= document.getElementById("room");

	room.innerHTML=i.innerHTML;
	nam = document.getElementById("mKindList");
	nam.style="display:none"
		su++;
	return room.innerHTML;
}

//////////////////////////////////////슬라이드/////////////////////////////////////////////// 

function slide(id, dir, n)
{
	var o = document.getElementById(id);

	for(var i=0; i<n; i++)
	{
		if(dir == 'left')
		{
			o.appendChild(o.firstChild);
		}
		else if(dir == 'right')
		{
			o.insertBefore(o.lastChild, o.firstChild);
		}
	}
}
