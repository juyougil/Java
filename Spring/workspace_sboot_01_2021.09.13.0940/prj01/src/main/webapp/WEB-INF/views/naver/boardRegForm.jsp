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
<title>로그인화면</title>
<script>
// body 태그를 모두 읽어들인 이후 실행할 자스 코딩 설정하기
	$(document).ready(function(){
		//writer subject email content pwd
		//$(".writer").val("사오정");
		//$(".subject").val("불닭볶음면");
		//$(".email").val("abc@naver.com");
		//$(".content").val("매워");
		//$(".pwd").val("1234");
		})
		
		
	// [게시판 등록 화면]에 입력된 데이터의 유효성 체크를 자스로 하지 않고 선언
	// 비동기 방식으로 서버에 "boardRegProc.do" 로 접속하는 함수 선언
	function checkBoardRegForm(){
		// "정말 등록 하시겠습니까?" 라고 물어보기
		if(confirm("정말 등록 하시겠습니까?")== false){
			return ;
			}

		
		// form 태그에 파일업로드 전송 관련 설정하기
		document.boardRegForm.enctype="multipart/form-data";
		
		
		
		//alert($("[name=boardRegForm]").serialize());
		//return;
		// 현재 화면에서 페이지 이동 없이(=비동기 방식으로)
		// 서버쪽 boardRegProc.do 로 접속하여 게시판 글쓰기를 하고
		// 글쓰기 성공 여부를 알려주기
		$.ajax({
			// 서버 쪽 호출 URL 주소 지정
			url : "/${requestScope.naverPath}boardRegProc.do"


				
			// form 태그 안의 입력양식 데이터 즉, 파라미터값을 보내는 방법 지정
			,type : "post"




			// 중요~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
			// serialize만 쓰면 문자열만 전달하지만 아래처럼하면 파일의 문자열과 파일도 같이 전송된다. 즉, 파일업로드를 위한 설정
				
			//-----------------------------------
			// 서버로 보내는 데이터에 파일이 있으므로
			// 전송하는 파라미터명, 파라미터값을 serialize를 하여 Query String으로 변경하지 않케 설정하기.
			// 서버로 보내는 데이터에 파일이 없으면  processData: false 을 생략한다.
			//-----------------------------------
			,processData:false
			//-----------------------------------
			// 서버로 보내는 데이터에 파일이 있으므로
			// 현재 form 태그에 설정된 enctype 속성값을 Content-Type 으로 사용하도록 설정하기.
			// 이게 없으면 현재 form 태그에 설정된 enctype 속성값과 관계없이 무조건 enctype 이 application/x-www-form-urlencoded 로 설정된다.
			// 서버로 보내는 데이터에 파일이 없으면  ,contentType: false  을 생략한다.
			//-----------------------------------
			,contentType:false


			
			//-------
			// form 데이터 통째로 보내기
			// 서버로 보내는 데이터  설정하기.
			// 서버로 보내는 데이터에 파일이 있으므로 FormData 객체 설정.
			//-------
			,data:new FormData($("[name=boardRegForm]").get(0)) //eq사용x 무조건 get( )사용 커마부분

			
			
			// 파일업로드가 필요없다면 아래처럼
			//,data: $("[name=boardRegForm]").serialize()


			
			
			
			// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정.
			// 익명함수의 매개변수에는 서버가 보내온 Map<String,String> 를 JSON 객체로 바꿔 들어온다.
			,success : function(json){
				// 매개변수로 들어온 JSON 객체에서 게시판 입력 성공행의 개수 꺼내서 지역변수 boardRegCnt 에 저장하기
				// 매개변수로 들어온 JSON 객체에서 유효성 체크 결과 문자열을 꺼내서 지역변수 boardRegCnt 에 저장하기
				var boardRegCnt = json.boardRegCnt;

				var msg = json.msg;

				// 만약 유효성 체크 결과 문자열이 있으면 경고하고 함수 중단하기
				if(msg!=null && msg.length>0){
					alert(msg);
					return;
				}
				
				// 게시판 글 입력 성공행의 개수가 1이면, 즉 입력이 성공했으면
				if(boardRegCnt==1){
<%-- 			<% if(request.getParameter("b_no")==null){%>
						alert("새끌쓰기 성공");
					<%}else{%>
						alert("댓글쓰기 성공");
					<%}%> 										--%>
					<c:if test="${empty param.b_no}">
						alert("새글쓰기 성공")
					</c:if>
					<c:if test="${!empty param.b_no}">
						alert("댓글쓰기 성공")
					</c:if>
					location.replace("/${requestScope.naverPath}boardList.do");
				}
				// 그렇지 않으면, 즉 입력이 실패했으면
				else{
<%-- 				<% if(request.getParameter("b_no")==null){%>
					alert("새끌쓰기 실패");
					<%}else{%>
					alert("댓글쓰기 실패");
					<%}%> 										--%>
					<c:if test="${empty param.b_no}">
						alert("새글쓰기 실패")
					</c:if>
					<c:if test="${!empty param.b_no}">
						alert("댓글쓰기 실패")
					</c:if>
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
		<form name = "boardRegForm" method="post" action="/${requestScope.naverPath}boardRegProc.do" enctype="multipart/form-data">
			<table border=1 cellpadding="5" class="tbcss2" cellpadding="${requestScope.cellpadding}">
<%-- 			
			<%if(request.getParameter("b_no")==null){%>
			<caption>새글쓰기</caption>
			<%}else{%><caption>댓글쓰기</caption>
			<%}%> 
--%>		
			<c:choose>
				<c:when test="${empty param.b_no}">
					<caption>새글쓰기</caption>
				</c:when>
				<c:otherwise>
					<caption>댓글쓰기</caption>
				</c:otherwise>
			</c:choose>
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">이 름</th>
					<td>
						<input type="text" size="10" name="writer" class="writer" maxlength=10>
					</td>
				</tr>
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">제 목</th>
					<td>
						<input type="text" size="40" name="subject" class="subject" maxlength=30>
					</td>
				</tr>				
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">이메일</th>
					<td>
						<input type="text" size="40" name="email" class="email" maxlength=30>
					</td>
				</tr>				
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">내 용</th>
					<td>
						<textarea name="content" rows="13" cols="40" class="content" maxlength=300></textarea>
					</td>
				</tr>
				
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">이미지</th>
					<td>
						<input type="file" name="img" class="img">
					</td>
				</tr>			
				
				
				<tr>
					<th bgcolor="${requestScope.thBgcolor}">비밀번호</th>
					<td>
						<input type="password" size="8" name="pwd" class="pwd" maxlength=4>
					</td>
				</tr>				
			</table>
			<input type="button" value="저장" onClick="checkBoardRegForm();">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.replace('/${requestScope.naverPath}boardList.do');"><br>
			<!-- 만약 파라미터명 b_no 의 파라미터값이 null 이면 name="b_no"를 가진 hidden 태그의 value에 0입력하기. -->
			<!-- 만약 파라미터명 b_no 의 파라미터값이 null 이 아니면 name="b_no"를 가진 hidden 태그의 value에 파라미터값 입력하기. -->
<%-- 			
			<%if(request.getParameter("b_no")==null){%>
			<input type="hidden" name="b_no" value="0">
			<%}else{%><input type="hidden" name="b_no" value="<%=request.getParameter("b_no")%>">
			<%}%>
--%>		[게시판 총개수 : 총 ${requestScope.totCnt}개]
			<div>${sessionScope.msg}</div>
			<c:if test="${empty param.b_no}">
				<input type="hidden" name="b_no" value="0">
			</c:if>
			<c:if test="${!empty param.b_no}">
				<input type="hidden" name="b_no" value="${param.b_no}">
			</c:if>
		</form>
	</center>
</body>
</html>