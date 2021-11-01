<!-- **************************************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- **************************************************************************** -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- 현재 JSP 페이지에서 사용할 클래스 수입하기 -->
<%@ page import="java.util.Map,java.util.List" %>

<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여
commom.jsp 파일 내의 소스를 삽입하기 -->
<%@include file="common.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원리스트</title>
<script>
	//body 태그 안의 내용을 모두 읽어들인 이후 실행할 자스 코드 설정하기
	$(document).ready(function(){
		
		var min_year = $(".min_year").val();
		var min_month = $(".min_month").val();
		var max_year = $(".max_year").val();
		var max_month = $(".max_month").val();
		min_year= parseInt(min_year,10);
		min_month= parseInt(min_month,10);
		max_year= parseInt(max_year,10);
		max_month = parseInt(max_month,10);
		
		
		
		
		
		$(".min_month").change(function(){
			if($(".min_year").val().split(" ").join("")==""){
				alert("최소년도를 선택하십시오");
				$(".min_month").find(":first").prop("selected",true);
				return;
			}
		})
		$(".max_month").change(function(){
			if($(".max_year").val().split(" ").join("")==""){
				alert("최대년도를 선택하십시오");
				$(".max_month").find(":first").prop("selected",true);
				return;
			}
			if(parseInt($(".max_year").val(),10)==parseInt($(".min_year").val(),10)){
				if(parseInt($(".max_month").val(),10)<parseInt($(".min_month").val(),10)){
					alert("최소날짜가 최대날짜보다 큽니다");
					$(".max_month").find(":first").prop("selected",true);
					return;	
				}
			}
		});
		

		$(".max_year").change(function(){
			if(parseInt($(".max_year").val(),10)<parseInt($(".min_year").val(),10)){
				alert("최소년도가 최대년도보다 큽니다");
				$(".max_year").find(":first").prop("selected",true);
				return;
			}
			if($(".max_year").val().split(" ").join("")==""){
				$(".max_month").find(":first").prop("selected",true);
				return;
			}
			
		})


		$(".min_year").change(function(){
			if($(".min_year").val().split(" ").join("")==""){
				$(".min_month").find(":first").prop("selected",true);
				return;
			}
			
		})


















		
		
		
		
		});


	
	function goEmployeeContentForm(emp_no){
		$("[name='employeeContentForm'] [name='emp_no']").val(emp_no)
		document.employeeContentForm.submit();
		}
	
	



	// 페이지 번호를 클릭하면 호출되는 함수 선언
	function search_with_changePageNo(selectPageNo){
		// class=selectPageNo 를 가진 입력양식에 클릭한(=선택한 페이지 번호를 value 값으로 삽입하기
		// 서버에 보내기 위해
		$(".selectPageNo").val(selectPageNo);
		// search 함수 호출하기
		search();
	
		}

	
	// [게시판 글쓰기 화면]으로 이동하는 함수 선언
	function goEmployeeRegForm(){
		// Location 객체의 replace 메소드 호출로 [새글쓰기 화면]으로 이동하기
		// 이 이동방법은 form 태그를 이용한 접속 방법이 아니므로
		// 파라미터값을 가지고 가려면 URL 주소 뒤 부분에 ?파명=파값 를 붙여야만 한다.
		// 즉 get 방식으로 웹서버 접속하는 방법이다.
		location.replace("/employeeRegForm.do");
		}

	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	// 게시판 수정/삭제 화면으로 이동하는 함수 선언
	//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	function goEmployeeUpDelForm(emp_no){
		// name="boardUpDelForm" 을 가진 form 태그의  action 값을 URL로 서버에 접속하라.
		$("[name='employeeUpDelForm'] [name='emp_no']").val(emp_no)
		document.employeeUpDelForm.submit();
	}
	




	// [검색] 버튼 클릭하면 호출되는 함수선언
	// 키워드에 입력한 데이터를 가진 [게시판 목록]을 검색해서 그 결과를 보여주는 함수 선언
	function search(){
			// 입력한 키워드 얻어오기
			var keyword1 = $(".keyword1").val();
			// 만약 키워드가 비어있거나 공백으로 되어 있으면 ""로 대체하기
			if(keyword=null || keyword1.split(" ").join("")==""){
					keyword1 = "";
				}

			
			// 입력한 키워드의 앞뒤 공백제거하고 다시 입력양식에 넣어주기
			$(".keyword1").val($.trim(keyword1));
			
			

			var min_year = $(".min_year").val();
			var min_month = $(".min_month").val();
			var max_year = $(".max_year").val();
			var max_month = $(".max_month").val();
			var min_ym = min_year+min_month;
			var max_ym = max_year+max_month;
			
			if(min_year.split(" ").join("")!=""){	
				if(min_month.split(" ").join("")==""){
					$(".min_month").find("[value=01]").prop("selected",true);
					
					
				}
			}
			if(max_year.split(" ").join("")!=""){	
				if(max_month.split(" ").join("")==""){
					$(".max_month").find("[value=12]").prop("selected",true);
					
					
				}			
				
			}

			
			// 비동기 방식으로 웹서버에 접속하여 키워드를 만족하는
			// 검색 결과물을 응답받아 현 화면에 반영하기
			searchExe();
		}


	// [모든 검색] 버튼 클릭하면 호출되는 함수선언
	function searchAll(){
		// 키워드 입력 양식에 "" 넣어주기
		$(".keyword1").val("");

		// class=day 를 가진 입력 양식의 체크 풀기
		// 체크박스 체크 모두 해제하기!!
		$(".checkjikup").prop("checked",false);
		// 비동기 방식으로 웹서버에 접속하는 searchExe() 함수 호출하기
		
		$(".min_year").val("");
		$(".min_month").val("");
		$(".max_year").val("");
		$(".max_month").val("");
		searchExe();
		}



	// 비동기 방식으로 웹서버에 접속하는 searchExe()함수 선언하기
	function searchExe(){
		// 현재 화면에서 페이지 이동 없이(=비동기 방식으로)
		// 서버쪽 /boardList.do 로 접속하여
		// 검색 결과물을 응답받아 현 화면에 반영하기
		$.ajax({

			
			//서버 쪽 호출 URL 주소 지정
			url : "/employeeList.do"
				
				
			// form 태그 안의 입력양식 데이터 즉, 파라미터 값을 보내는 방법 지정
			,type : "post"

				
			// 서버로 보낼 파라미터명과 파라미터값을 설정
			,data : $("[name=employeeListForm]").serialize()
			
			
			
			// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명함수의 매개변수에는 서버가 보내온 html 소스가 문자열로 들어온다.
			// 즉 응답메시지 안의 html 소스가 문자열로써 익명함수의 매개변수로 들어온다.
			// 응답 메시지 안의 html 소스는 boardRegProc.jsp 의 실행 결과물이다.			
			,success : function(responseHtml){
				
				// 매개변수 responsHtml 로 들어온 검색 결과물 html 소스문자열에서
				// class=searchResult 를 가진 태그 내부의 [검색 결과물 html 소스]를
				// 아래 현 화면의 html 소스중에 class=searchResult 를 가진 태그 내부에 덮어씌우기
				$(".searchResult").html($(responseHtml).find(".searchResult").html());

				// 매개변수 responsHtml 로 들어온 검색 결과물 html 소스문자열에서
				// class=boardListAllCnt 를 가진 태그 내부의 [총개수 물자열]을 얻어서
				// 아래 현 화면의 html 소스중에 class=boardListAllCnt 를 가진 태그 내부에 덮어씌우기
				$(".employeeListAllCnt").text($(responseHtml).find(".employeeListAllCnt").text());

				// 매개변수 responsHtml 로 들어온 검색 결과물 html 소스문자열에서
				// class=pageNo 를 가진 태그 내부의 [결과물 hmtl]을 얻어서
				// 아래 현 화면의 html 소스중에 class=pageNo 를 가진 태그 내부에 덮어씌우기				
				$(".pageNo").html($(responseHtml).find(".pageNo").html());
				
				}
			// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정
			,error : function(){
				alert("서버 접속 실패");
				}
			});
			
		


		}

	



</script>
</head> 

<!-- body 태그 선언하기 -->
<!-- body 태그에 keydown 이벤트를 걸면 
특정 태그에 가는 포커스 상관없이 무조건 화면에서 키보드 누르면 자스 코드를 실행할수 있다. -->
<body onKeydown="if(event.keyCode==13){search();}"><center>
	<!-- [자바 변수 선언하고 검색 화면 구현에 필요한 데이터 꺼내서 저장하기 -->
	<!-- 검색결과물, 검색된 총 개수, 페이지번호에 관련된 데이터이다. -->
	


	<!-- [게시판 검색 조건 입력 양식] 내포한 form 태그 선언 -->
	<form name="employeeListForm" method="post" onSubmit="return false;">
	
		<!-- 키워드 데이터 저장할 입력양식 선언 -->
		[키워드] : <input type="text" name="keyword1" class="keyword1"><br>
		직급검색
		<input type="checkbox" name="checkjikup" class="checkjikup" value="사장">사장
		<input type="checkbox" name="checkjikup" class="checkjikup" value="부장">부장
		<input type="checkbox" name="checkjikup" class="checkjikup" value="과장">과장
		<input type="checkbox" name="checkjikup" class="checkjikup" value="대리">대리
		<input type="checkbox" name="checkjikup" class="checkjikup" value="주임">주임
		<input type="checkbox" name="checkjikup" class="checkjikup" value="사원">사원<br>
		
		
		<!-- 아래의 2개의 태그는 페이징 처리 관련 데이터이다. 이 2개의 데이터가 없으면 페이징 처리가 불가능하다 -->
		<!-- 선택한 클릭한 페이지 번호를 저장할 hidden 입력양식 선언 -->
		<input type="hidden" name = "selectPageNo" class="selectPageNo" value="1">
		입사일 검색
		<select name=min_year class="min_year"  >
			<option value="" >-선택-
			<option value="1980" >1980</option>
			<option value="1981">1981</option>
			<option value="1982">1982</option>
			<option value="1983">1983</option>
			<option value="1984">1984</option>
			<option value="1986">1986</option>
			<option value="1987">1987</option>
			<option value="1988">1988</option>
			<option value="1989">1989</option>
			<option value="1990">1990</option>
			<option value="1991">1991</option>
			<option value="1992">1992</option>
			<option value="1993">1993</option>
			<option value="1994">1994</option>
			<option value="1995">1995</option>
			<option value="1996">1996</option>
			<option value="1997">1997</option>
			
		</select>년
		<select name="min_month" class="min_month">
			<option value="" >-선택-
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
		</select>월~
		<select name=max_year class="max_year">
			<option value="" >-선택-
			<option value="1980" >1980</option>
			<option value="1981">1981</option>
			<option value="1982">1982</option>
			<option value="1983">1983</option>
			<option value="1984">1984</option>
			<option value="1986">1986</option>
			<option value="1987">1987</option>
			<option value="1988">1988</option>
			<option value="1989">1989</option>
			<option value="1990">1990</option>
			<option value="1991">1991</option>
			<option value="1992">1992</option>
			<option value="1993">1993</option>
			<option value="1994">1994</option>
			<option value="1995">1995</option>
			<option value="1996">1996</option>
			<option value="1997">1997</option>
		</select>년
		<select name="max_month" class="max_month" >
			<option value="" >-선택-
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
		</select>월<br>
		
		
		
		
		
		
		
		<!-- 한 화면에 보여줄 검색 결과물 행의 개수 관련 입력양식 선언 -->
		<select name="rowCntPerPage" class="rowCntPerPage" onChange="search();">
			<option value="5" selected>5
			<option value="10">10
			<option value="15">15
			<option value="20">20
			<option value="25">25
			<option value="30">30
		</select> 행보기<br>
		
		<input type="button" value="검색" class="boardSearch" onClick="search();">&nbsp;
		<input type="button" value="모두검색" class="boardSearchAll" onClick="searchAll();">&nbsp;
	</form>
	
	
	<a href="javascript:goEmployeeRegForm();">[직원추가]</a>
	
	<div style="height:10px"></div>
	
	
		<div class="employeeListAllCnt">총 ${requestScope.employeeListAllCnt}명</div>
		
			

		<div class="searchResult">
		<table border=1 class="tbcss0" cellpadding="3">
			<tr bgcolor="gray"><th>NO</th><th>직원번호</th><th>이름</th><th>직급</th><th>입사일</th><th>소속부서명</th><th>상세보기</th><th>수정/삭제</th></tr>


			<c:forEach var="board" items="${requestScope.employeeList}" varStatus="loopTagStatus">
				<c:if test="${requestScope.employeeList!=null}">
					<tr bgcolor="${loopTagStatus.index%2==0?'white':'lightgray' }">
						<td>${requestScope.selectPageNo*requestScope.rowCntPerPage-requestScope.rowCntPerPage+1+loopTagStatus.index}</td>
						<td>${board.emp_no }
						<td>${board.emp_name }
						<td>${board.jikup}
						<td>${board.hire_date}
						<td>${board.dep_name}
						<td><input type="button" value="상세보기" onClick='goEmployeeContentForm(${board.emp_no});'>
						<td><input type="button" value="수정/삭제" onClick="goEmployeeUpDelForm(${board.emp_no});">
				</c:if>
			</c:forEach>				
				<c:if test="${requestScope.employeeListAllCnt==0}">
					<tr>
						<td colspan=10 align="center">검색결과가 없습니다.</td>
				</c:if>
		</table>
		</div>
		
		<div style="height:10px"></div>
		
		
		
		<!-- 페이지 번호 출력 -->
		<div class="pageNo">
		
			<c:if test="${requestScope.employeeListAllCnt>0}">
					<!-- 선택한 페이지 번호가 1보다 크면 [처음], [이전] 글씨 보이기. 단 클릭하면 함수호출하도록 이벤트 걸기 -->
					<c:if test="${requestScope.selectPageNo>1}">
						<span style='cursor:pointer'; onClick='search_with_changePageNo(1)'>[처음]</span>
						<span style='cursor:pointer'; onClick='search_with_changePageNo(${requestScope.selectPageNo}-1);'>[이전]</span>
						&nbsp;&nbsp;
					</c:if>
					<!-- 선택한 페이지 번호가 1이하이면 [처음], [이전] 문자 표현하기. 함수호출 X-->
					<c:if test="${requestScope.selectPageNo<=1}">
						<span>[처음]</span>
						<span>[이전]</span>
						&nbsp;&nbsp;
					</c:if>
					
					
					
					
			
					
					<c:forEach var="no" begin="${requestScope.min_pageNo}" end="${requestScope.max_pageNo}" step="1">
						<!-- 만약 출력되는 페이지번호와 선택한 페이지 번호가 일치하면 그냥 번호만 표현하기 -->
						<c:if test="${no==requestScope.selectPageNo}">
							<span>${no}</span>
						</c:if>
						<!-- 만약 출력되는 페이지번호와 선택한 페이지 번호가 일치하지 않으면 클릭하면 함수호출하도록 클릭 이벤트 걸기 -->
						<c:if test="${no!=requestScope.selectPageNo}">
							<span style='cursor:pointer'; onClick='search_with_changePageNo(${no});'>[${no}]</span>
						</c:if>
					
					</c:forEach>

					
					
					
					
					<!-- 선택한 페이지 번호가 마지막 페이지 번호보다 작으면 [다음], [마지막] 문자 표현하기. 단 클릭하면 함수호출하도록 이벤트 걸기 -->
					<c:if test="${requestScope.selectPageNo<requestScope.last_pageNo}">
						&nbsp;&nbsp;
						<span style='cursor:pointer'; onClick='search_with_changePageNo(${requestScope.selectPageNo}+1);'>[다음]</span>
						<span style='cursor:pointer'; onClick='search_with_changePageNo(${requestScope.last_pageNo});'>[마지막]</span>
					</c:if>
					<!-- 선택한 페이지 번호가 마지막 페이지 번호가 크거나 같으면 [다음], [마지막] 문자 표현하기. 함수호출 X-->
					<c:if test="${requestScope.selectPageNo>=requestScope.last_pageNo}">
						&nbsp;&nbsp;
						<span>[다음]</span>
						<span>[마지막]</span>
					</c:if>
			</c:if>
		</div>
		
		<!-- div 태그를 이용하여 위아래 컨텐츠의 사이 여백 주기 -->
		<div style="height:10px"></div>
		
		
	
<!-- [직원 수정/삭제]화면으로 이동하는 form 태그 선언 -->
	<form name="employeeUpDelForm" method="post" action="/employeeUpDelForm.do">
			<input type="hidden" name="emp_no">
	</form>
	<form name="employeeContentForm" method="post" action="/employeeContentForm.do">
			<input type="hidden" name="emp_no">
	</form>
		
	</center>
</body>
</html>


<!-- 
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
공식 => [페이지 당 보여줄 행의 개수], [선택페이지번호], [총개수]로
        검색 결과물의 [시작행 번호]과 검색 결과물의 [끝행 번호]를 구하는 공식
		단 변수는 아래와 같다.
------------------------------------------------------------------
			totCnt        => 검색된 총 결과물 개수
			rowCntPerPage => 페이지 당 보여줄 행의 개수
			selectPageNo  => 선택한 페이지 번호
			beginRowNo    => 검색된 총 결과물에서 가져올 범위의 시작행
			endRowNo      => 검색된 총 결과물에서 가져올 범위의 끝행
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
if( totCnt>0){
	int endRowNo = selectPageNo * rowCntPerPage;
	int beginRowNo = endRowNo - rowCntPerPage + 1;
	if( endRowNo>totCnt ){
		endRowNo = totCnt;
	}
}
---------------------------------
if( totCnt>0){
	int beginRowNo = selectPageNo * rowCntPerPage - rowCntPerPage + 1;
	int endRowNo = beginRowNo + rowCntPerPage -1;
	if( endRowNo>totCnt ){
		endRowNo = totCnt;
	}
}




mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
공식 => [총개수], [페이지 당 보여줄 행의 개수],[선택된페이지번호]
        [한 화면에 보여지는 페이지 번호 개수]로

        [현재 화면에 보여지는 페이지 번호의 최소 번호]과 
        [현재 화면에 보여지는 페이지 번호의 최대 번호]를 구하는 공식
		단 변수는 아래와 같다.
------------------------------------------------------------------
			totCnt            => 검색된 총 결과물 개수
			rowCntPerPage => 페이지 당 보여줄 행의 개수
			selectPageNo      => 선택한 페이지 번호
			pageNoCntPerPage  => 페이지 당 보여줄 페이지 번호의 개수
			last_pageNo		=> 마지막 페이지 번호
			min_pageNo  => 현재 화면에 보여지는 페이지 번호의 최소 페이지 번호
			max_pageNo  => 현재 화면에 보여지는 페이지 번호의 최대 페이지 번호
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
if(totCnt>0){
int last_pageNo = totCnt/rowCntPerPage;
	if(totCnt%rowCntPerPage>0){last_pageNo++;}
	
	
int min_pageNo = (selectPageNo-1)/pageNoCntPerPage * pageNoCntPerPage + 1;
int max_pageNo = min_pageNo + pageNoCntPerPage -1;
	if(max_pageNo>last_pageNo){max_pageNo = last_pageNo;}
}


 -->	