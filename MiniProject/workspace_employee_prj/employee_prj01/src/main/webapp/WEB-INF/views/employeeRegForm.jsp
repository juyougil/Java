<!-- **************************************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- **************************************************************************** -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여
commom.jsp 파일 내의 소스를 삽입하기 -->
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원정보등록화면</title>
<script>
	$(document).ready(function(){
		$(".jikup").change(function(){
			if(${requestScope.presidentCnt}>=1 && $(".jikup").val()=="사장"){
				alert("사장직급은 한명한 존재 가능합니다.");
				$(".jikup").val("");

			}


			})
		})
		
		
	// [게시판 등록 화면]에 입력된 데이터의 유효성 체크를 자스로 하지 않고 선언
	// 비동기 방식으로 서버에 "boardRegProc.do" 로 접속하는 함수 선언
	function checkEmployeeRegForm(){
		// "정말 등록 하시겠습니까?" 라고 물어보기
		if(confirm("정말 등록 하시겠습니까?")== false){
			return ;
			}


		// form 태그에 파일업로드 전송 관련 설정하기
		document.employeeRegForm.enctype="multipart/form-data";
		//alert($("[name=boardRegForm]").serialize());
		//return;
		// 현재 화면에서 페이지 이동 없이(=비동기 방식으로)
		// 서버쪽 boardRegProc.do 로 접속하여 게시판 글쓰기를 하고
		// 글쓰기 성공 여부를 알려주기
		$.ajax({

			// 서버 쪽 호출 URL 주소 지정
			url : "/employeeRegProc.do"
			// form 태그 안의 입력양식 데이터 즉, 파라미터값을 보내는 방법 지정
			,type : "post"

			,processData:false
			,contentType:false
			,data:new FormData($("[name=employeeRegForm]").get(0))


			
			,success : function(responseHtml){
				// 매개변수로 들어온 html 소스에서  class="boardRegCnt"가진 태그가 끌어안고 있는 숫자 꺼내기
				// 게시판 글 입력 성공 행의 개수 꺼내기
				// 꺼낸 개수의 앞뒤 공백 제거하기
				var employeeRegCnt = $(responseHtml).filter(".employeeRegCnt").text();
				idCnt=$.trim(employeeRegCnt);
				employeeRegCnt = parseInt(employeeRegCnt,10);

				var msg = $(responseHtml).filter(".msg").text();
				idCnt=$.trim(msg);

				if(msg!=null && msg.length>0){
					alert(msg);
					return;
				}
				
				// 게시판 글 입력 성공행의 개수가 1이면, 즉 입력이 성공했으면
				if(employeeRegCnt==1){
					alert("직원 등록 성공");
					location.replace('/employeeList.do');
				}
				// 그렇지 않으면, 즉 입력이 실패했으면
				else{
					alert("직원 등록 실패");
				}
				
			}
			// 서버의 응답을 못 받았을 경우 실행할 익명함수 설정
			,error : function(){
				alert("서버 접속 실패");
			}


		});




		
		}
</script>
</head>
<body>
	<center>
		<!-- [게시판 글쓰기] 화면을 출력하는 form 태그 선언 -->
		<form name = "employeeRegForm" >
			<table border=1 cellpadding="5" class="tbcss2">


				<caption>직원등록</caption>
				<tr>
					<th bgcolor="lightgray">이 름</th>
					<td>
						<input type="text" size="15" name="emp_name" class="emp_name" maxlength=10>
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">소속부서</th>
					<td>
						<select name="dep_no" class="dep_no">
						<option value="">
						<c:forEach var="dept" items="${requestScope.deptList}" varStatus="loopTagStatus">
							<option value="${dept.dep_no}">${dept.dep_name}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">직급</th>
					<td>
						<select name="jikup" class="jikup">
							<option value="">
						<c:forEach var="jikupList" items="${requestScope.jikupList}" varStatus="loopTagStatus">
							<option value="${jikupList.jikup}">${jikupList.jikup}</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">연봉</th>
					<td>
						<input type="text" size="15" name="salary" class="salary" maxlength=8>
					</td>
				</tr>				
				<tr>
					<th bgcolor="lightgray">주민번호</th>
					<td>
						<input type="text" size="15" name="jumin_num" class="jumin_num" maxlength=13>
					</td>
				</tr>				
				<tr>
					<th bgcolor="lightgray">휴대전화번호</th>
					<td>
						<input type="text" size="15" name="phone_num" class="phone_num" maxlength=15>
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">직속상관번호</th>
					<td>
						<input type="text" size="15" name="mgr_emp_no" class="mgr_emp_no" maxlength=4>
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">사진</th>
					<td>
						<input type="file" name="img" class="img">
					</td>
				</tr>					
			</table>
			<input type="button" value="저장" onClick="checkEmployeeRegForm();">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.replace('/employeeList.do');">

		</form>
	</center>
</body>
</html>