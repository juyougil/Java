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
<title>직원 상세 화면</title>
<script>
	$(document).ready(function(){	
		})
		
	function goMgrContent(mgr_emp_no){
		$("[name='employeeMgrContentForm'] [name='mgr_emp_no']").val(mgr_emp_no)
		var mgr_emp_no = $("[name='employeeMgrContentForm'] [name='mgr_emp_no']").val();
		
		if(mgr_emp_no.split(" ").join("")!=""){

		if(confirm("정말 이동하시겠습니까?")){document.employeeContentForm.submit();}
		}

		
		if(mgr_emp_no.split(" ").join("")==""){
		alert("직속상관이 존재하지 않습니다.");
			return;
		}
	}
</script>
</head>
<body>
	<center>

	<b>[직원 상세 화면]</b>
		<c:if test="${!empty requestScope.employeeDTO}">
		<form name = "employeeContentForm">
		
		
		<!--  <input type="hidden" name="b_no" value="<%//=b_no%>"> -->
		<input type="hidden" name="emp_no" value="${requestScope.employeeDTO.mgr_emp_no}">

			<table border=1 cellpadding="5" >
					<c:if test="${!empty requestScope.employeeDTO.pic }">
						<tr><td colspan="2"><img src="/resources/img/${requestScope.employeeDTO.pic}" width="100%"></tr>
					</c:if>	
				<tr>

					<th bgcolor="lightgray">직원번호</th>
					<td>${requestScope.employeeDTO.emp_no}</td></tr>
				<tr>	
					<th bgcolor="lightgray">직원명</th>
					<td>${requestScope.employeeDTO.emp_name}</td></tr>
				<tr>
					<th bgcolor="lightgray">직급</th>
					<td>${requestScope.employeeDTO.jikup}</td></tr>
				<tr>
					<th bgcolor="lightgray">소속부서명</th>
					<td><c:if test="${requestScope.employeeDTO.dep_no==10}">총무부</c:if>
					<c:if test="${requestScope.employeeDTO.dep_no==20}">영업부</c:if>
					<c:if test="${requestScope.employeeDTO.dep_no==30}">전산부</c:if>
					<c:if test="${requestScope.employeeDTO.dep_no==40}">자재부</c:if></td>	</tr>
				<tr>
					<th bgcolor="lightgray">입사일</th>
					<td>${requestScope.employeeDTO.hire_date}</td></tr>
				<tr>
					<th bgcolor="lightgray">연봉</th>
					<td>${requestScope.employeeDTO.salary}</td></tr>
				<tr>
					<th bgcolor="lightgray">주민번호</th>
					<td>${requestScope.employeeDTO.jumin_num}</td></tr>
				<tr>
					<th bgcolor="lightgray">휴대번호</th>
					<td>${requestScope.employeeDTO.phone_num}</td></tr>
				<tr>
					<th bgcolor="lightgray" >직속상관번호</th>
					<td colspan=3>${requestScope.employeeDTO.mgr_emp_no}</td>
				</tr>	
			</table>
			<input type="button" value="직속상관상세보기" onClick="goMgrContent(${requestScope.employeeDTO.mgr_emp_no});">
			<input type="button" value="목록보기" onClick="location.replace('/employeeList.do');">
			
		</form>
		</c:if>
		<form name="employeeMgrContentForm" method="post" action="/employeeContentForm.do">
			<input type="hidden" name="mgr_emp_no" value="">
	</form>
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