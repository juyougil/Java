<!-- **************************************************************************** -->
<!-- JSP 기술의 한 종류인 [Page Directive]를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- **************************************************************************** -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML 이고, 이 문서 안의 데이터는 UTF-8 방식으로 인코딩한다 라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩 한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다. -->
<!-- 모든 JSP 페이지 상단에 무조건 아래 설정이 들어간다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.naver.erp.Info"%>

<script>
$(document).ready(function(){
	$("body").prepend(
		"<center><div><span style='cursor:pointer' "
					+ "onclick='location.replace(\"/${requestScope.naverPath}logout.do\");'>[로그아웃]</span></div></center>"
	);
	$("body").attr("bgColor","${requestScope.bodycolor}")
});

// table 태그 내부의 배경색 바꾸는 함수 선언
function changeBgColor(){
	setTrBgcolor("tbcss0","#54BD54","#6DD66D","#82F9B7","#14A0A0");
				//태이블 태그의 클래스값
				// 헤드tr의 배경색
				// 헤드tr이후의 홀수 tr 배경색
				// 헤드tr이후의 짝수 tr 배경색
				// 마우스오버 했을때 배경색
	

	}	
</script>










































