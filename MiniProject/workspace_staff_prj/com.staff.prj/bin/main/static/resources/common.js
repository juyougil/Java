function setTrBgcolor( tableClassV , headBgcolor, oddTrBgcolor, evenTrBgcolor, mouceOverBgcolor ){

	try{
	var tableObj = $("."+tableClassV);
	var firstTrObj = tableObj.find("tr:eq(0)");
		//var firstTrObj = tableObj.find("tr:first");
		//var firstTrObj = tableObj.find("tr").first();
	var oddTrObj = firstTrObj.siblings("tr").filter(":even")
	var evenTrObj = firstTrObj.siblings("tr").filter(":odd")
	
	firstTrObj.attr("bgColor", headBgcolor);
	oddTrObj.attr("bgColor", oddTrBgcolor);
	evenTrObj.attr("bgColor", evenTrBgcolor);
	
	
	firstTrObj.find("td,th").css("color", "#000000");
	oddTrObj.find("td,th").css("color", "#000000");
	evenTrObj.find("td,th").css("color", "#000000");
	
	
	
	
	
	
	
	oddTrObj.hover(
		function(){
			$(this).attr("bgColor",mouceOverBgcolor);
		
		}
		,function(){
			$(this).attr("bgColor",oddTrBgcolor);
		
		
		})
	evenTrObj.hover(
		function(){
			$(this).attr("bgColor",mouceOverBgcolor);
		
		}
		,function(){
			$(this).attr("bgColor",evenTrBgcolor);
		
		
		})
	}
	catch(e){
		alert("setTrBgcolor 함수 호출 시 예외발생!"+ e.message);
	}
	
	
}

function setThBgcolor( tableClassV , ThBgcolor ){

	try{
	var tableObj = $("."+tableClassV);

	var allThObj = tableObj.find("th");
	
	
	
	
	allThObj.attr("bgColor", ThBgcolor);

	

	}
	catch(e){
		alert("setTrBgcolor 함수 호출 시 예외발생!"+ e.message);
	}
	
	
}




// 입사시험!!!!!!!!!!
//------------------------------------------------------------------
// 1차원 Array 객체에 저장된 데이터 중에 랜덤하게 하나에 데이터를 복사해서 리턴하는 함수
//------------------------------------------------------------------
function getRandomData(arr){
	// Array 객체에 배열변수의 개수 // 데이터의 개수xxxxxxxx
	var arr_Cnt = arr.length ;
	// 랜덤한 인덱스번호 구하기
	var random_index = Math.floor(Math.random()*arr_Cnt);
	// 랜덤한 인덱스턴호에 해당하는 배일변수의 데이터 리턴하기
	var randomData = arr[random_index];
	return randomData;

}

function getRandomData_with_del(arr){
	// Array 객체에 배열변수의 개수 // 데이터의 개수xxxxxxxx
	var arr_Cnt = arr.length ;
	// 랜덤한 인덱스번호 구하기
	var random_index = Math.floor(Math.random()*arr_Cnt);
	// 랜덤한 인덱스턴호에 해당하는 배일변수의 데이터 리턴하기
	var randomData = arr[random_index];
	arr.splice(random_index,1);
	return randomData;

}




//------------------------------------------------------------------
// 1차원 Array 객체에 저장된 데이터 중에 랜덤하게 원하는 개수의 데이터를 복사해서 또 다른 Array 객체에 담아 리턴하는 함수
//------------------------------------------------------------------
function getRandomDataArr(arr,cnt){
	if(arr==null && arr.length==0){
		alert("배일변수에 개수가 없습니다.");
		return null;
	}
	if(arr.length<cnt){
		alert("배일변수에 개수보다 랜덤하게 뽑을 개수가 큽니다.");
		return null;
	}
	var randomDateArr =[];
	var arr2 = arr.slice(0);
	for(var i=1; i<=cnt; i++){
		randomDateArr.push(getRandomData_with_del(arr2))
	}
	return randomDateArr;

	
	
/*	무한반복문 사용
	문자가 아닌 중복된 인덱스번호를 제거할것
	var randomDataArr = [];
	var tmpArr = [];
	while (true){
		var randomData = getRandomData(arr);
		var tmp_cnt =0;
		for(var i =0; i<tmpArr.length; i++){
			if(randomData==tmpArr[i]){
				tmp_cnt++;
				break;
			}
			
		}
		if(tmp_cnt>0){
			continue;
		}
		randomDataArr.push(randomData);
		tmpArr.push(randomData);
		if(randomDataArr.length==cnt){
			break;
		}
	}
	return tmpArr;
*/

}
// 중복안되게하려면 무한반복문
// 배열을 복사해서 뽑았을때 복사한 배열에서 제거

//------------------------------------------------------------------
// 1차원 Array 객체에 저장된 데이터 중에 랜덤하게
// min_cnt~max_cnt 사이 개수 하나 골라서 그 개수 만큼 데이터를 복사해서 또 다른 Array 객체에 담아 리턴하는 함수
//------------------------------------------------------------------
function getRandomDataArr2(arr,min_cnt,max_cnt){
	if(arr==null && arr.length==0){
		alert("배일변수에 개수가 없습니다.");
		return null;
	}
	if(arr.length<min_cnt){
		alert("배일변수에 개수보다 랜덤하게 뽑을 개수가 큽니다.");
		return null;
	}
	if(arr.length<max_cnt){
		alert("뽑을 범위에 문제가 있습니다.");
		return null;
	}
	var randomCntArr = [];
	for(var i =min_cnt; i<=max_cnt; i++){
		randomCntArr.push(i);
	}
	var randomCnt = getRandomData(randomCntArr);
	var arr2 = arr.slice(0);
	return getRandomDataArr(arr2,randomCnt);

}
//$.unique
// goldenSaying 변수안에 저장된 Array 객체 안의 배열변수의 개수 얻기
// 이 개수가 명언의 개수이다.
// var goldenSaying_Cnt = goldenSaying.length 

// 0~ 명언개수-1 미만의 무작위 인덱스 번호 얻기
// 이 인덱스번호는 무작위 배열변수를 선택할 때 사용한다.
// var random_index = Math.floor(Math.random()*goldenSaying_Cnt);

// 무작위 인덱스 번호에 해당하는 배열변수를 리턴하기
// return goldenSaying[random_index];
