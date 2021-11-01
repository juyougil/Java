<!-- **************************************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- **************************************************************************** -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.employee.prj.EmployeeDTO"%>

<!-- JSP 기술의 한 종류인 [Include Directive]를 이용하여
commom.jsp 파일 내의 소스를 삽입하기 -->
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원정보 수정/삭제화면</title>
<script>
	$(document).ready(function(){
		//writer subject email content pwd
		//$(".writer").val("사오정");
		//$(".subject").val("불닭볶음면");
		//$(".email").val("abc@naver.com");
		//$(".content").val("매워");
		//$(".pwd").val("1234");
		if(${requestScope.employeeDTO.jikup!='사장'}){
		$(".jikup").change(function(){
			if(${requestScope.presidentCnt}>=1 && $(".jikup").val()=="사장"){
				alert("사장직급은 한명한 존재 가능합니다.");
				$(".jikup").val("${requestScope.employeeDTO.jikup}");
			}
			})
		}


		

		
		})
		
		
	// [게시판 등록 화면]에 입력된 데이터의 유효성 체크를 자스로 하지 않고 선언
	// 비동기 방식으로 서버에 "boardRegProc.do" 로 접속하는 함수 선언
	function checkEmployeeUpDelForm(upDel){
		// 매개변수로 들어온 upDel 에 "del" 이 저장되어있으면
		// 즉, 삭제 버튼을 눌렀으면 각 입력앙식의 유효성 체크하고 수정 여부 물어보기
		if(upDel=='up'){
			//$(".xxx").remove()
			//$("body").append("<div class=xxx>불타는 금요일</div>")
			if(confirm("정말 수정하시겠습니까?")==false){return;}
			$("[name=upDel]").val("up");
		}
		else if(upDel=='del'){
			if(confirm("정말 삭제하시겠습니까?")==false){return;}
			$("[name=upDel]").val("del");


			if(${requestScope.employeecustomerCnt}>=1 && ${requestScope.mgrCnt}>=1){
				if(confirm("담당고객과 직속후임이 있어 삭제가 불가능합니다. 담당고객과 직속후임 관계를 해제하고 삭제하시겠습니까?")==false){return;}
					$("[name=customerRemove]").val("yes");
					$("[name=mgrEmpNORemove]").val("yes");
			}

			
			if(${requestScope.employeecustomerCnt}>=1 && ${requestScope.mgrCnt}==0){
				if(confirm("담당하고있는 고객이 있어 삭제가 불가능합니다. 담당고객 관계를 해제하고 삭제하시겠습니까?")==false){return;}
					$("[name=customerRemove]").val("yes");
			}

			
			if(${requestScope.mgrCnt}>=1 && ${requestScope.employeecustomerCnt}==0){
				if(confirm("직속후임이 있어 삭제가 불가능합니다. 직속후임 관계를 해제하고 삭제하시겠습니까?")==false){return;}
				$("[name=mgrEmpNORemove]").val("yes");
					
			}
		}

		
		// form 태그에 파일업로드 전송 관련 설정하기
		document.employeeUpDelForm.enctype="multipart/form-data";

		
		// 현재 화면에서 페이지 이동 없이\
		// 서버쪽 "/boardUpDelProc.do 로 접속해서 수정 또는 삭제하기
		$.ajax({
			// 서버 쪽 호출 URL 주소 지정
			url : "/employeeUpDelProc.do"

			// form 태그 안의 입력양식 데이터 즉, 파라미터값을 보내는 방법 지정
			,type : "post"


			,processData:false
			,contentType:false
			// 웹서버로 보낼 파라미터명과 파라미터명값을 지정
			,data:new FormData($("[name=employeeUpDelForm]").get(0))
			// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명함수의 매개변수에는 서버가 보내온 html 소스가 문자열로 들어온다.
			// 즉 응답메시지 안의 html 소스가 문자열로써 익명함수의 매개변수로 들어온다.
			// 응답 메시지 안의 html 소스는 boardUpDelProc.jsp 의 실행 결과물이다.
			,success : function(responseHtml){
				var msg = $(responseHtml).filter(".msg").text();
				var employeeUpDelCnt = $(responseHtml).filter(".employeeUpDelCnt").text();
	
				if(upDel=="up"){
					msg=$.trim(msg);
					if(msg!=""){
						alert(msg);
						return;
					}
				if(employeeUpDelCnt==-1){
					alert("담당고객 데이터가 삭제 되었습니다.")
				}
				else if(employeeUpDelCnt==-2){
					alert("담당고객 해제에 실패하였습니다.")
				}
				else if(employeeUpDelCnt==1){
					alert("수정이 완료되었습니다.")
					location.replace('/employeeList.do');
				}
				else{
					alert("서버에 에러가 발생하였습니다. 관리자에게 문의해주세요.")

				}
				}
				else if(upDel=="del"){
				if(employeeUpDelCnt==1){
					alert("삭제 성공.");
					location.replace('/employeeList.do');
				}
				else if(employeeUpDelCnt==-1){
					alert("담당고객 데이터가 삭제 되었습니다.")
					
				}
				else if(employeeUpDelCnt==-2){
					alert("담당고객 해제에 실패하였습니다.")
				}
				
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

	<b>[글 수정 화면]</b>
		<!-- [게시판 글쓰기] 화면을 출력하는 form 태그 선언 -->
		<c:if test="${!empty requestScope.employeeDTO}">
		<form name = "employeeUpDelForm">
		
		<input type="hidden" name="customerRemove" >
		<input type="hidden" name="mgrEmpNORemove" >
		<!--  <input type="hidden" name="b_no" value="<%//=b_no%>"> -->
		<input type="hidden" name="emp_no" value="${requestScope.employeeDTO.emp_no}">
		
		<input type="hidden" name="upDel">
			<table border=1 cellpadding="5" class="tbcss2">

				<tr>
					<th bgcolor="lightgray">직원명</th>
					<td>
						<!--  <input type="text" size="40" name="subject" class="subject" maxlength=30 value="<%//=subject%>"> -->
						<input type="text" size="40" name="emp_name" class="emp_name" maxlength=30 value="${requestScope.employeeDTO.emp_name}">
					</td>
				</tr>				
				<tr>
					<th bgcolor="lightgray">직급</th>
					<td>
						<select name="jikup" class="jikup">
							<option value="">
						<c:forEach var="jikupList" items="${requestScope.jikupList}" varStatus="loopTagStatus">
							<option value="${jikupList.jikup}" <c:if test="${requestScope.employeeDTO.jikup==jikupList.jikup}">selected</c:if>>${jikupList.jikup}</option>
						</c:forEach>
						</select>
					</td>
				</tr>	
				<tr>
					<th bgcolor="lightgray">소속부서명</th>
					<td>
						<select name="dep_no" class="dep_no">
						<option value="">
						<c:forEach var="dept" items="${requestScope.deptList}" varStatus="loopTagStatus">
							<option value="${dept.dep_no}" <c:if test="${requestScope.employeeDTO.dep_no==dept.dep_no}">selected</c:if>>${dept.dep_name}</option>
						</c:forEach>
						</select>
					</td>	
					
				<tr>
					<th bgcolor="lightgray">연봉</th>
					<td>
						<!--  <textarea name="content" rows="13" cols="40" class="content" maxlength=300 ><%//=content%></textarea> -->
						<input type="text" name="salary" class="salary" size="40" value="${requestScope.employeeDTO.salary}">
					</td>
				</tr>		
				<tr>
					<th bgcolor="lightgray">입사일</th>
					<td>
						<!--  <textarea name="content" rows="13" cols="40" class="content" maxlength=300 ><%//=content%></textarea> -->
						<input type="text" name="hire_date" class="hire_date" size="40" value="${requestScope.employeeDTO.hire_date}">
					</td>
				</tr>

					<tr>
					<th bgcolor="lightgray">주민번호</th>
					<td>
						<!--  <textarea name="content" rows="13" cols="40" class="content" maxlength=300 ><%//=content%></textarea> -->
						<input type="text" name="jumin_num" class="jumin_num" size="40" value="${requestScope.employeeDTO.jumin_num}">
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">휴대번호</th>
					<td>
						<!--  <textarea name="content" rows="13" cols="40" class="content" maxlength=300 ><%//=content%></textarea> -->
						<input type="text" name="phone_num" class="phone_num" size="40" value="${requestScope.employeeDTO.phone_num}">
					</td>
				</tr>
				<tr>
					<th bgcolor="lightgray">직속상관번호</th>
					<td>
						<!--  <textarea name="content" rows="13" cols="40" class="content" maxlength=300 ><%//=content%></textarea> -->
						<input type="text" name="mgr_emp_no" class="mgr_emp_no" size="40" value="${requestScope.employeeDTO.mgr_emp_no}">
					</td>
				<tr>
					<th  bgcolor="lightgray">이미지</th>
					<td>
						<input type="file" name="img" class="img">
						<c:if test="${!empty requestScope.employeeDTO.pic}">
						<div style=:height:3pt></div>
						<img src="/resources/img/${requestScope.employeeDTO.pic}" width="10%"><br>
						<div style=:height:3pt></div>
						<input type="checkbox" name="is_del" class="is_del" value="id_del">이미지 삭제
						</c:if>
					
				</tr>				
			</table>
			<input type="button" value="수정" onClick="checkEmployeeUpDelForm('up');">&nbsp;
			<input type="button" value="삭제"  onClick="checkEmployeeUpDelForm('del');">&nbsp;
			<input type="button" value="목록보기" onClick="location.replace('/employeeList.do');">
			
		</form>
		</c:if>
	<%
/*
	}else{
	out.print("<script>alert('삭제된 글입니다.'); location.replace('/boardList.do'); </script>");
	}
*/
	%>
	<c:if test="${empty requestScope.employeeDTO }">
		<script>alert('삭제된 글입니다'); location.replace('/employeeList.do');</script>
	</c:if>
	</center>
</body>
</html>