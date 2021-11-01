//매게변수로 들어온 데이터가 비어있거나 공백으로 구성되어 있으면 true 를 리턴
//아니면 false 를 리턴하는 함수 선언
function isEmpty(str){// str: 검사할 문자열이 저장되는 매개변수
/*try{
	var flag = false;
	 if(str.split(" ").join("")==""){
		flag = true;
	}
	return flag;
	//flag가 아니라 flag에 들어있는 데이터를 리턴 결국 true 또는 false를 리턴한다고 보면 된다.
	}catch(e){
		alert("isEmpty 함수 호출 시 예외 발생" + e.message);
		return false;
	}*/	
	// 통제가 쉽고 가독성이 좋으니 아래처럼 사용
	var flag = false;

	//try 구문 선언. try 구문 안에는 예외발생 가능성이 있는 코드가 삽입됨
	try{ 
		// 매개변수로 들어온 문자가 길이가 없거나 공백으로 이루어져 있으면
		// flag 변수에 true 저장하기
		if(str.split(" ").join("")==""){
		flag = true;
	}
	return flag;
	//flag가 아니라 flag에 들어있는 데이터를 리턴 결국 true 또는 false를 리턴한다고 보면 된다.

	// catch 구문선언. catch 구문에서 예외발생 시 실행할 코드가 삽입됨
	// catch 구문의 매개변수 e 에는 예외를 관리하는 객체의 메모리 위치 주소값이 들어온다.
	// catch (~){~} 구문은 try 구문 에서 예외발생 시  호출하는 일종의 함수와 비슷하다.
	}catch(e){
		alert("isEmpty 함수 호출 시 예외 발생" + e.message);
		flag = false;
	}
	// flag 변수안의 데이터를 리턴하기
	return flag;
}





// 이메일 체크 함수 선언
// 매개변수로 들어온 이메일 문자가 이메일 문자 패턴에 맞으면 true 리턴
// 틀리면 false 리턴하기
function isValidEmail(email){// email: 검사할 문자열, 즉 이메일 문자열이 저장되는 매개변수
	var flag = false
	try{
		// 이메일 문자의 패턴을 관리하는 RegExp 객체 생성하기
		// RegExp 객체의 test 메소드를 호출하여 매개변수로 들어온 문자의
		// 이메일 문자 패턴에 맞는지 여부를 구해 flag 변수에 저장하기
		var regExp = RegExp(/^(([0-9a-zA-Z_-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$)/);
		flag = regExp.test(email);
	}
	catch(e){
		alert("isValidEmail 함수 호출 시 예외 발생" + e.message);
		flag =false;
	}
	// flag 변수인의 데이터를 리턴하기
	return flag;
}






function isValidEmail1(email){// email: 검사할 문자열, 즉 이메일 문자열이 저장되는 매개변수
	var flag = true;
	var regExp = RegExp(/^([0-9a-zA-Z_-]+@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$)/);
	if(regExp.test(email)==false){
		flag = false;
	}
	return flag;
}	

// 문자열의 패턴 체크 함수 선언.
// 매개변수로 들어온 RegExp 객체와 검사 문자열을 이용하여
// 검사 문자열이 RegExp 객체가 관리하는 문자 패턴에 맞으면 true 리턴하기.
// 틀리면 false 리턴하기.
function isValidPattern(regExpObj, targetStr){
	var flag = false;
	try{
		//regExpObj: RegExp 객체의 메모리 위치 주소값이 저장되는 매개변수
		//targetStr: 패턴을 검사할 문자열이 저장되는 매개변수
		flag = regExpObj.test(targetStr);
	}
	catch(e){
		alert("isValidPattern 함수 호출 시 예외 발생" + e.message);
		flag =false;
	}
	return flag;
}


// checkbox 또는 radio 의 체크 개수구해서 리턴하는 함수선언
function getCheckCnt(arrObj){ // Array 객체. Array 객체 안의 배열 변수안에는
							// Radio 객체 또는 배열 변수안에는 Radio 객체 또는 checkbox 객체의 메위주가 들어 있다.
							
	// Radio 또는 checkbox의 체크 개수가 저장되는 변수 checkedCnt 선언하고 0저장.. 
	var checkedCnt = 0;
	try{
	// len 변수 선언하고 매개변수로 들어온  Array객체의 배열변수 개수를 구해 저장하기
	var len = arrObj.length;

	// len 변수안에 undefined 면, 즉 매개변수로 Array 객체가 안들어오고 다른 객체 즉 Checkbox 객체 또는 Radio 객체가
	// 들어오면 존재하지 않는 length 라는 속성변수에는 undefined 가 들어있다.
	// Radio 객체 또는 Checkbox 객체의 메모리 위치 주소 상상도를 살펴봐야 한다.
	if(len==undefined){
		if(arrObj.checked==false){
			return 0;
		}else{
			return 1;
		}
	}
	
	// 반복문 선언. 반복문은 0 ~ len변수안의 숫자 미만 만큼 반복
	// 반복문을 돌려서 Array 객체의 배열변수 안에 저장된  Radio 객체 또는 checkbox 객체에 접근하기 위함.
	for(var i=0; i<len; i++){
		// 만약 i 번째 배열변수 안의 Radio 객체 또는 checkbox 객체의 속성변수 checked 에 true 가 저장되어 있으면
		// checkedCnt 변수 안에 숫자를 1 업데이트하기
		// 즉 i 번째 Radio 또는 checkbox 입력양식에 체크가 되어 있으면 checkedCnt 변수 안의 숫자를 1업데이트 하기
		if(arrObj[i].checked){
			checkedCnt++;
		}
	}
	// checkedCnt 변수 안의 데이터 리턴하기. 즉 Radio 또는  checkbox 입력양식에 체크 개수 리턴하기
	return checkedCnt;
}catch(e){
	alert("getCheckedCnt 함수 호출 시 에러가 발생"+ e.message)
	checkedCnt =0;
}
// checkedCnt 변수 데이터 리턴하기 즉 radio checkbox 입력양식에 체크될 수 리턴
return checkedCnt;
}


//현재 시각의 요일을 리턴하는 함수 선언

function getTodayWeek(){
	// today 변수 선언. 현재 날짜를 관리하는 Date 객체 생성
	var today = new Date();
	// weekNo 변수 선언. Date 객체의 getDay 메소드를 호출하여 현재 요일 번호를 얻어 weekNo 변수에 저장하기
	var weekNo = today.getDay();
	// week 변수 선언. "일요일" 저장하기.
	var week = "일요일"
	// 요일 번호에 따라 week 변수에 오늘 요일 문자 저장하기
	if(weekNo==1){
		week = "월요일"
	}else if(weekNo==2){
		week = "화요일"
	}else if(weekNo==3){
		week = "수요일"
	}else if(weekNo==4){
		week = "목요일"
	}else if(weekNo==5){
		week = "금요일"
	}else if(weekNo==6){
		week = "토요일"
	}else if(weekNo==0){
		week = "일요일"
	}
	// 오늘 요일 문자 리턴하기
	return week;
}
/* 위 코드와 같음
function getTodayweek(){
	return ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"][new Date().getDay()]
}*/

 // 현재 시각의 년-월-일(요일) 을 문자로 리턴하는 함수 선언
 function getTodayYMDW(){
	 // today 변수 선언. 현재 날짜를 관리하는 Date 객체 생성. Date 객체의 메위주를 today변수에 저장
	 var today = new Date();
	 var year = today.getFullYear();

	 var month = today.getMonth()+1;
	 if(month<10){
		 month ="0"+month;
	 }

	 var date = today.getDate();
	 if(date<10){
		date ="0"+date;
	}

	 var week = getTodayWeek().replace("요일","")

	 // 현재 시각의 년-월-일(요일)을 문자로 리턴하기.
	 return year + " - " + month + " - " + date + " (" + week + ")";
 }



 // 메개변수로 들어온 날짜문자가 오늘날짜와 동일하면 true를 리턴
function isToday(dateStr){
try{
	// 변수 arr 선언. dateStr 매개변수 안의 날짜문자를 - 기준으로 분해하여 Array 객체 안에 담기
	var arr = dateStr.split("-");
	
	// Array 객체 안의 배열변수 안의 데이터 꺼내어 year, month, date 변수에 저장하기
	var year = arr[0];
	var month = arr[1];
	var date = arr[2];
	
	/* String 객체의 trim 메소드 호출로 앞뒤 공백 제거
	year = year.trim();
	month = month.trim();
	date = date.trim();*/
	
	//deleteBlank 메소드 호출로 앞뒤 공백 제거
	year = deleteBlank(year);
	month = deleteBlank(month);
	date = deleteBlank(date);
	
	// parseInt 라는 내장 함수를 호출하여
	// year, month, date 변수 안의 숫자문자를 정수 숫자로 바꾸기
	year = parseInt(year,10)
	month = parseInt(month,10)
	date = parseInt(date,10)
	
	
	// 변수 today 선언. 오늘 날짜를 관리하는 Date 객체 생성하고 메위주를 today에 저장하기
	// Date 객체의 getFullYear 메소드 호출로 년도를 얻어 변수 today_year에 저장하기.
	// Date 객체의 getMonth 메소드 호출로 월을 얻어 변수 today_month에 저장하기.
	// Date 객체의 getDate 메소드 호출로 일을 얻어 변수 today_date에 저장하기.
	var today = new Date();
	var today_year = today.getFullYear();
	var today_month = (today.getMonth()+1);
	var today_date = today.getDate();
	
	
	// 매개변수로 들어온 년월일 이 오늘 날짜의 년월일과 동일하면 true 리턴하기
	// 아니면 false 리턴하기
	return year==today_year && month==today_month && date==today_date;
	}
	catch(e){
		alert("isToday 함수 에서 에러발생!")
		return false;
	}
}
	/*
	<참고>자수에서 JSON은 자바의 HashMap 객체와 흡사하다.
	HashMap map +new HashMap();
	map.put("s_no", "1");
	map.put("s_name","오세황");
	map.put("jumin_num", "001225-3234321");
	*/
	
	
	// 매개변수로 들어온 문자에서 모든 공백을 제거하고 난후의 문자 리턴하기.
function deleteBlank(str){
	try{
	var str = str.split(" ").join("");
	return str;
	}
	catch(e){
		alert("deleteBlank 함수에서 에러발생!")
		return str;
	}
}
	// 매개변수로 들어온 문자에서 모든 공백을 제거하고 난후의 문자 리턴하기.
function deleteBlank(str){
try{
	// 공백 제거한 문자 저장할 변수 result 선언
	var result ="";
	// 빈복문 돌리면서 매개변수로 들어온 물자열 중 한개씩 접근해서 
	// 공백이 아닌 문자만 result 변수에 누적시키기
	for(var i = 0; i<str.length; i++){
		// 만약 i 변째 문자가 공백이 아니면 i 번째 문자를 result 변수에 누적시키기
		if(str.charAt(i)!=" "){
			result = result + str.charAt(i)
		}
	}
	// 변수 result 안의 데이터 리턴하기
	return result;
	}
	catch(e){
		alert("deleteBlank 함수에서 에러발생!");
		return str;
	}
}


function get_dDay(dateStr){
try{
	// 변수 arr 선언. dateStr 매개변수 안의 날짜문자를 - 기준으로 분해하여 Array 객체 안에 담기
	var arr = dateStr.split("-");
	
	// Array 객체 안의 배열변수 안의 데이터 꺼내어 year, month, date 변수에 저장하기
	var year = arr[0];
	var month = arr[1];
	var date = arr[2];

	//deleteBlank 메소드 호출로 앞뒤 공백 제거
	year = deleteBlank(year);
	month = deleteBlank(month);
	date = deleteBlank(date);
	
	// parseInt 라는 내장 함수를 호출하여
	// year, month, date 변수 안의 숫자문자를 정수 숫자로 바꾸기
	year = parseInt(year,10)
	month = parseInt(month,10)
	date = parseInt(date,10)
	
	//오늘 날짜를 관리하는 Date 객체 생성하고 변수 today에 저장하기
	var today = new Date();
	// 임의의 날짜를 관리하는 Date 객체 생성하고 변수 xDay 에 저장하기
	//월은 0부터 시작하기 때문에 -1
	var xDay = new Date(year,month-1,date);
	//getTime으로 두 날짜에 차이를 구하고 Math.ceil로 소수점 올림
	var dDay = Math.ceil((xDay.getTime() - today.getTime())/(1000*60*60*24));

	//dDay에 저장된 데이터 리턴
	return dDay;
	}
	catch(e){
		alert("get_dDay 함수 호출 시 에러가 발생"+ e.message)
		return -1;
	}
}
	
	
// 매개변수로 들어온 한글 이름이 한글이면서 2~20자 사이면면 true 아니면 false 리턴하는 함수 선언
function isHangeulName(HangeulName){
	return isValidPattern(/^[가-힣]{2,20}$/, HangeulName);

}


function isMem_id(Mem_id){
	return isValidPattern(/^[a-z][a-z0-9_]{4,9}$/, Mem_id);

}

function isPwd(Pwd){
	return isValidPattern(/^[a-z0-9_]{5,8}$/, Pwd);

}