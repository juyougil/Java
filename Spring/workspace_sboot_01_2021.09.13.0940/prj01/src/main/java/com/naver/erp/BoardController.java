package com.naver.erp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

// URL 주소로 접속하면 호출되는 메소드를 소유한 [컨트롤러 클래스] 선언
// @Controller 를 붙임으로써 [컨트롤러 클래스] 임을 지정한다
@Controller
@RequestMapping(value="/naver")
public class BoardController {
	
	// 속성변수 boardService 선언하고 [BoardService 인테페이스]를 구현한 클래스를 찾아 객체 생성해 객체의 메위주를 저장.
		// @Autowired 역할 -> 속성변수에 붙은 자료형이 [인터페이스]를 구현한 [클래스]를 객체화하여 객체의 메위주를 저장한다.
		// [인터페이스]를 구현한 [클래스]가 1개가 아니면 에러가 발생한다.
		// 단 @Autowired(required=false) 로 선언하면 [인터페이스]를 구현한 [클래스]가 0개 이어도 에러없이 null 이 저장된다.
	@Autowired
	private BoardService boardService;
	
	// 속성변수 boardService 선언하고 [BoardService 인테페이스]를 구현한 클래스를 찾아 객체 생성해 객체의 메위주를 저장.
		// @Autowired 역할 -> 속성변수에 붙은 자료형이 [인터페이스]를 구현한 [클래스]를 객체화하여 객체의 메위주를 저장한다.
		// [인터페이스]를 구현한 [클래스]가 1개가 아니면 에러가 발생한다.
		// 단 @Autowired(required=false) 로 선언하면 [인터페이스]를 구현한 [클래스]가 0개 이어도 에러없이 null 이 저장된다.	
		@Autowired
	private BoardDAO boardDAO;
	
		
		
	// 속성변수 path 선언하고 Info 인터페이스의 속성변수 naverPath 안의 데이터를 저장하기
	// Info 인터페이스의 속성변수 naverPath 안에는 "naver/" 가 저장되어있다.
	private String path = Info.naverPath;
/*	
	// @RequestMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드 선언
	// @ModelAttribute 가 붙은 메소드는 @RequestMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드 이다.
	@ModelAttribute	
	public void checkLogin(HttpSession session) throws Exception {
		// 로그인 성공 여부 확인하기
		// HttpSession 객체 저장된 로그인 아이디를 꺼내기
		String login_id = (String)session.getAttribute("login_id");
		// 만약 login_id 변수안에 null 이 저장되어 있으면
		// 즉 만약 로그인에 성공한 적이 없으면
		if(login_id==null){
			// 코딩으로 예외를 발생시키기
			// 예외를 관리하는 Exception 객체를 생성함으로써 예외가 발생했음을 자바에게 알린다.
			throw new Exception();
		}
	}
		
	// 현재 이 [컨트롤러 클래스] 내의 메소드에서
	// 예외 발생하면 호출되는 메소드 선언하기
	// @ExceptionHandler(Exception.class)를 붙여야한다.
	// @ExceptionHandler(Exception.class) 어노테이션이 붙은 메소드는
	// 리턴되는 문자열은 호출 JSP 페이지명이다.
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "logout.jsp";
	}
		
*/	
		
	// @RequestMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드 선언
	// @ModelAttribute 가 붙은 메소드는 @RequestMapping 이 붙은 메소드가 호출되기 전에 호출되는 메소드 이다.
	// @ModelAttribute("키값명")이 붙은 메소드가 리턴하는 데이터는
	// 스프링이 HttpServletRequest 객체에 setAttribute("키값명",리턴데이터) 메소드 호출하므로
	// @RequestMapping(~)이 붙은 메소드 호출 후에 이동하는 JSP 페이지에서 ${requestScope.키값명}으로 꺼낼 수 있다.
	@ModelAttribute("totCnt")
	public int getTotCnt(BoardSearchDTO boardSearchDTO) {
		int totCnt = this.boardDAO.getBoardListAllCnt(boardSearchDTO);;
		return totCnt;
		
	}
		
		
		
		
		
		
	// 가상주소 /boardList.do 로 접근하면 호출되는 메소드 선언
		// @RequestMapping 내부에, method="@RequestMethod.POST 가 없으므로
		// 가상주소 /boardList.do로 접근 시 get 또는 post 방식 접근 모두 허용한다.
	@RequestMapping(value="/boardList.do")
	public ModelAndView getBoardList1(
			// 파라미터값을 저장하고 있는 BoardSearchDTO 객체를 받아오는 매개변수 선언
			// 파라미터명과 동일한 이름을 가진 속성변수에 파라미터값이 저장된다.
			BoardSearchDTO boardSearchDTO
			// HttpSession 객체의 메위주를 저장하는 매개변수 session 선언하기
			//,HttpSession session
	) {
		/*
		// 로그인 성공 여부 확인하기
		// HttpSession 객체 저장된 로그인 아이디를 꺼내기
		String login_id = (String)session.getAttribute("login_id");
		// 만약 login_id 변수안에 null 이 저장되어 있으면
		// 즉 만약 로그인에 성공한 적이 없으면
		if(login_id==null){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("logout.jsp");
			return mav;
		}
		*/
		
		//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
		//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
		// 아래 로직은 검색화면 구현 시 공식과도 같은 로직이므로 복사해서 쓴다.
		// 애로 로직을 복사해서 사용시 boardSearchDTO 객체 이름만 바꾸며된다.
		//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM		
		//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
		// 검색 조건에 맞는 [게시판 목록의 총개수] 얻기
		int boardListAllCnt = this.boardDAO.getBoardListAllCnt(boardSearchDTO);
		
		
		// 마지막 페이지 번호 구하기
		// 현 화면에 보여줄 최소 페이지 번호 구하기
		// 현 화면에 보여줄 최대 페이지 번호 구하기
		// boardSearchDTO 객체에 저장된 [선택 페이지 번호] 구하기
		// boardSearchDTO 객체에 저장된 [한 화면에 보여줄 행의 개수] 구하기
		// [한 화면에 보여줄 페이지 번호의 개수] 구하기
		int last_pageNo=0;
		int min_pageNo=0;
		int max_pageNo=0;
		int selectPageNo = boardSearchDTO.getSelectPageNo();
		int rowCntPerPage = boardSearchDTO.getRowCntPerPage();
		int pageNoCntPerPage=10;
		
		// 만약 검색된 결과물의 개수가 0보다 크면, 즉 검색 결과물이 있으면
		if(boardListAllCnt>0) {
			// 마지막 페이지 번호 구하기
			last_pageNo = boardListAllCnt/rowCntPerPage;
				if(boardListAllCnt%rowCntPerPage>0){last_pageNo++;}
			// 만약 선택한 페이지 번호가 마지막 페이지 번호보다 크면	
			if(selectPageNo>last_pageNo) {
				// selectPageNo 변수에 1 저장하기
				selectPageNo=1;
				// BoardSearchDTO 객체의 selectPageNo 속성 변수에 1저장하기
				boardSearchDTO.setSelectPageNo(selectPageNo);
			}
			
			// 한 화면에 보일 최소 페이지 번호구하기
			// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최소 페이지 번호]를 계산해서 저장하기
			min_pageNo = (selectPageNo-1)/pageNoCntPerPage * pageNoCntPerPage + 1;
			
			// 한 화면에 보일 최대 페이지 번호 구하기
			// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최대 페이지 번호]를 계산해서 저장하기
			max_pageNo = min_pageNo + pageNoCntPerPage -1;
			if(max_pageNo>last_pageNo){max_pageNo = last_pageNo;}
		}
		
		

		// 오라클 board 테이블 안의 데이터를 검색해와 자바 객체에 저장하기. 
		// 즉 검색 조건에 맞는 [게시판 목록] 얻기
		List<Map<String,String>> boardList = this.boardDAO.getBoardList(boardSearchDTO);
		
		System.out.println(boardListAllCnt);
		
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName(path+"boardList.jsp");
		// [ModelAndView 객체]에 [게시판 목록 검색 결과]를 저장하기
		// [ModelAndView 객체]에 [게시판 목록의 총개수]를 저장하기
		
		// [ModelAndView 객체]에 [마지막 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최소 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최대 페이지 번호]를 저장하기
		
		// [ModelAndView 객체]에 [선택한 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [한 화면에 보여줄 행의 개수]를 저장하기
		// [ModelAndView 객체]에 [한 화면에 보여줄 페이지 번호의 개수]를 저장하기
		mav.addObject("boardList",boardList );
		mav.addObject("boardListAllCnt",boardListAllCnt );
		
		
		mav.addObject("last_pageNo",last_pageNo ); 	// JSP 페이지에서 페이징 번호 출려 시 사용할 데이터
		mav.addObject("min_pageNo",min_pageNo );	// JSP 페이지에서 페이징 번호 출려 시 사용할 데이터
		mav.addObject("max_pageNo",max_pageNo);		// JSP 페이지에서 페이징 번호 출려 시 사용할 데이터
		
		mav.addObject("selectPageNo",selectPageNo);
		mav.addObject("rowCntPerPage",rowCntPerPage);
		mav.addObject("pageNoCntPerPage",pageNoCntPerPage);
		

		
		
		// [ModelAndView 객체] 리턴하기
		return mav;
		
	}
	
	// MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	// 위 getBoardList 메소드를 심플하게 줄인 메소드
	public ModelAndView getBoardList2(
			// 파라미터값을 저장하고 있는 BoardSearchDTO 객체를 받아오는 매개변수 선언
			BoardSearchDTO boardSearchDTO
			// HttpSession 객체의 메위주를 저장하는 매개변수 session 선언하기
			//,HttpSession session
	) {
		/*
		// 로그인 성공 여부 확인하기
		// HttpSession 객체 저장된 로그인 아이디를 꺼내기
		String login_id = (String)session.getAttribute("login_id");
		// 만약 login_id 변수안에 null 이 저장되어 있으면
		// 즉 만약 로그인에 성공한 적이 없으면
		if(login_id==null){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("logout.jsp");
			return mav;
		}
		*/
		
		
		// 검색 조건에 맞는 [게시판 목록의 총개수] 얻기
		int boardListAllCnt = this.boardDAO.getBoardListAllCnt(boardSearchDTO);
		
		
		// 페이징 처리 관련 번호가 저장된 HashMap<String,Integer> 객체 구하기
		Map<String,Integer> map = Util.getPagingNos(boardListAllCnt, boardSearchDTO.getSelectPageNo(), boardSearchDTO.getRowCntPerPage(), 10);
		
		//HashMap<String,Integer> 객체에 저장된 보정된 선택 페이지 번호를
		// BoardSearchDTO 객체에 setSelectPageNo 메소드 호출로 덮어씌우기
		boardSearchDTO.setSelectPageNo(map.get("selectPageNo"));
		
		

		// 오라클 board 테이블 안의 데이터를 검색해와 자바 객체에 저장하기. 
		// 즉 검색 조건에 맞는 [게시판 목록] 얻기
		// 즉 검색 결과물 얻기
		List<Map<String,String>> boardList = this.boardDAO.getBoardList(boardSearchDTO);
		
		
		
		
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName(path+"boardList.jsp");
		// [ModelAndView 객체]에 [게시판 목록 검색 결과]를 저장하기
		// [ModelAndView 객체]에 [게시판 목록의 총개수]를 저장하기
		// [ModelAndView 객체]에 [페이징 처리 관련 번호가 저장된 HashMap<String,Integer> 객체 저장하기
		mav.addObject("boardList",boardList );
		mav.addObject("boardListAllCnt",boardListAllCnt );
		mav.addObject("pagingNos",map );
		

		
		
		
		
		// [ModelAndView 객체] 리턴하기
		return mav;
	}
	
	
	
	
	
	// 가상주소 /boardRegForm.do 로 접근하면 호출되는 메소드 선언
	@RequestMapping(value="/boardRegForm.do")
	public ModelAndView goBoardRegForm(
			// 파라미터명이 b_no 인 파라미터값을 받아오는 매개변수 b_no 선언하기
			@RequestParam(value="b_no"		// 파라미터명 설정
			, required=false				// 파라미터명, 값이 안들어와도 용서한다는 의미
			, defaultValue="0")				// 파라미터값 없으면 파라미터값을 0으로 하겠음
			int b_no	
		
		) {
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName(path+"boardRegForm.jsp");
		// [ModelAndView 객체] 리턴하기
		return mav;
	}
	
	
	
	
	// 가상주소 /boardRegProc.do 로 접근하면 호출되는 메소드 선언
	// 메소드 앞에 @RequestMapping(~,~,produces="application/json;charset=UTF-8") 하고
	// @ResponseBody 가 붙으면 리턴하는 데이터가 클라이언트에게 전송된다.
	// 원래 방법은 ModelAndView 객체를 리턴하면 JSP 를 호출하고 그 JSP 페이지의 실행결과인 HTML 문서가 응답메시지에 저장되어 전송되지만
	// @RequestMapping(~) 와 @ResponseBody 가 붙으면 리턴하는 데이터가 JSON 형태로 응답메시지에 저장되어 전송된다.
	@RequestMapping(
			value="/boardRegProc.do"
			,method=RequestMethod.POST
			,produces="application/json;charset=UTF-8"
			
	)
	@ResponseBody
	public Map<String,String> insertBoard(
			// 파라미터값을 저장할 [BoardDTO 객체]를 매개변수 선언
			// ***************************************************
			// [파라미터명]과 [BoardDTO 객체]의 [속성변수명]이 같으면
			// setter 메소드가 작동되어 [파라미터값]이 [속성변수]에 저장된다.
			// [속성변수명]에 대응하는 [파라미터명]이 없으면 setter 메소드가 작동되지 않는다.
			// [속성변수명]에 대응하는 [파라미터명]이 있는데 [파라미터값]이 없으면
			// [속성변수]의 자료형에 관계없이 무조건 null 값이 저장된다.
			// 이때 [속성변수]의 자료형이 기본형일 경우 null 값이 저장될 수 없어 에러가 발생한다.
			// 이런 에러를 피하려면 파라미터값이 기본형이거나 속성변수의 자료형을 String으로 해야한다.
			// 이런 에러가 발생하면 메소드안의 실행구문은 하나도 실행되지 않음에 주의한다.
			// 매개변수로 들어온 [DTO 객체]는 이 메소드가 끝난 후 호출되는 JSP 페이지로 그대로 이동한다.
			// 즉, HttpServletRequest 객체에 boardDTO 라는 키값명으로 저장된다.	
			BoardDTO boardDTO
			// <input type=file name=img> 입력양식의 파일이 저장된 MultipartFile 객체 저장 매개변수 선언
			// <주의> 업로드된 파일이 없어도 MultipartFile 객체는 생성되어 들어온다.
			,@RequestParam("img") MultipartFile multi
			// ***************************************************
			// Error 객체를 관리하는 BindingResult 객체가 저장되어 들어오는 매개변수 bindingResult 선언
			// 매개변수에 BindingResult 객체가 있으면 내부에서 유효성 체크 코드가 나온다.
			// ***************************************************
			,BindingResult bindingResult
	) {
		
		//******************************************
		// 업로드한 파일의 크기와 확장자 체크하기
		//******************************************
		// 만약에 업로드된 파일이 있으면 
		if(multi.isEmpty()==false) {
			
			
			// 만약에 업로드된 파일의 크기가 1000000 byte(=1000kb) 보다 크면
			if(multi.getSize()>1000000) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("boardRegCnt","0");
				map.put("msg","업로드 파일이 1000kb 보다 크면 안됩니다.");
				return map;
			}
			// 만약에 업로드된 파일의 확장자가 이미지 확장자가 아니면
			String fileName = multi.getOriginalFilename();
			fileName = fileName.toLowerCase();
			if(fileName.endsWith(".jpg")==false && fileName.endsWith(".png")==false && fileName.endsWith(".gif")==false) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("boardRegCnt","0");
				map.put("msg","이미지 파일이 아닙니다.");
				return map;
			}
		}
		
		// 게시판 등록 성공 여부가 저장된 변수 선언. 1이 저장되면 성공했다는 의미
		int boardRegCnt =0;
		// 유효성 체크 에러 메시지 저장할 변수 msg 선언
		String msg = "";
		try {			
			//***************************************************************
			//check_BoardDTO 메소드 호출하여 [유효성 체크]하고 경고문자 얻기
			//***************************************************************
			// check_BoardDTO 메소드를 호출하여 유효성 체크하고 에러 메시지 문자 얻기
			msg = check_BoardDTO(boardDTO,bindingResult);
			

			// 만약 msg 안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과했으면
			if(msg.equals("")) {
				// [BoardServiceImpl 객체]의 insertBoard 메소드 호출로
				// 게시판 글 입력하고 [게시판 입력 적용행의 개수] 얻기
				// 파일업로드에 트랜젝션을 걸기위해 미개변수로 multi 넘기기
				boardRegCnt = this.boardService.insertBoard(boardDTO,multi);

			}

		}catch(Exception ex) {
			boardRegCnt = -1;
			msg = "서버에서 문제 발생! 서버 관리자에게 문의 바람";
		}
		
		 
		// HashMap<String,String> 객체 생성하기
		Map<String,String> map = new HashMap<String,String>();
		
		// HashMap<String,String> 객체에 게시판 입력성공행의 개수 저장하기
		map.put("boardRegCnt", boardRegCnt+"");
		
		// HashMap<String,String> 객체에 유효성 체크 시 메세지 저장하기
		map.put("msg", msg);
		
		//HashMap<String,String> 객체 리턴하기
		return map;
	}
	
	// 게시판 입력 또는 수정 시 게시판 입력글의 입력양식의 유효성을 검사하고
	// 문제가 있으면 경고 문자를 리턴하는 메소드 선언.
	public String check_BoardDTO(BoardDTO boardDTO ,BindingResult bindingResult) {
		String checkMsg="";
		// BoardDTO 객체에 저장된 데이터의 유효성 체크할 BoardValidator 객체 생성하기
		// BoardValidator 객체의 validate 메소드 호출하여 유효성 체크 실행하기
		BoardValidator boardValidator = new BoardValidator();
		boardValidator.validate(
				boardDTO			// 유효성 체크할 DTO 객체
				,bindingResult		// 유효성 체크 결과를 관리하는 BindingResult 객체
		);
		// 만약 BindingResult 객체의 hasErrors() 메소드 호출하여 true 값을 얻으면
		if(bindingResult.hasErrors()) {
			// 변수 checkMsg 에 BoardValidator 객체에 저장된 경고문구 얻어 저장하기
			checkMsg = bindingResult.getFieldError().getCode();
		}
		
		
		return checkMsg;
		
		
	}
	
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		// /boardContentForm.do 접속 시 호출되는 메소드 선언
		//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		@RequestMapping( value="/boardContentForm.do" )

		public ModelAndView goBoardContentForm( 
				@RequestParam(value="b_no") int b_no	
		){

			//*******************************************
			// [BoardServiceImpl 객체]의 getBoard 메소드 호출로 [1개의 게시판 글]을 BoardDTO 객체에 담아오기
			//*******************************************
			BoardDTO boardDTO = this.boardService.getBoard(b_no);
			
			

			//*******************************************
			// [ModelAndView 객체] 생성하기
			// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
			//*******************************************
			ModelAndView mav = new ModelAndView( );
			mav.setViewName(path+"boardContentForm.jsp");
			mav.addObject("boardDTO", boardDTO);

			//*******************************************
			// [ModelAndView 객체] 리턴하기
			//*******************************************
			return mav;
		}
		
		

		// boardUpDelForm.do 접속 시 호출되는 메소드 선언
		@RequestMapping(value="/boardUpDelForm.do")
		
		// "b_no" 라는 파라미터명의 파라미터값이 저장되는 매개변수 b_no 선언
		// 수정 또는 삭제할 게시판 고유 번호가 들어오는 매개변수 선언
		public ModelAndView goBoardUpDelForm(
				@RequestParam(value="b_no") int b_no	
		) {
			//boardDAOImpl 객체의 getBoard 메소드 호출로
			// 1개의 게시판글을 BoardDTO 객체에 담아서 가져오기
			BoardDTO boardDTO = this.boardDAO.getBoard(b_no);
			// [ModelAndView 객체] 생성하기
			// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
			// [ModelAndView 객체]에 [게시판 목록 검색 결과]를 저장하기
			ModelAndView mav = new ModelAndView();
			mav.setViewName(path+"boardUpDelForm.jsp");
			mav.addObject("boardDTO",boardDTO);
			return mav;
			
		}
		
		
		
		// 가상주소 /boardUpDelProc.do 로 접근하면 호출되는 메소드 선언
		// 메소드 앞에 @RequestMapping(~,~,produces="application/json;charset=UTF-8") 하고
		// @ResponseBody 가 붙으면 리턴하는 데이터가 클라이언트에게 전송된다.
		// 원래 방법은 ModelAndView 객체를 리턴하면 JSP 를 호출하고 그 JSP 페이지의 실행결과인 HTML 문서가 응답메시지에 저장되어 전송되지만
		// @RequestMapping(~) 와 @ResponseBody 가 붙으면 리턴하는 데이터가 JSON 형태로 응답메시지에 저장되어 전송된다.
		@RequestMapping(
				value="/boardUpDelProc.do"
				,method=RequestMethod.POST
				,produces="application/json;charset=UTF-8"
				
		)
		@ResponseBody
		public Map<String,String> boardUpDelProc(
				//파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
				BoardDTO boardDTO							
				// "upDel"이라는 파라미터명의 파라미터값이 저장된 매개변수 upDel선언
				// 수정 또는 삭제 여부를 저장하는 매개변수 upDel선언
				,@RequestParam(value="upDel") String upDel	
				
				// <input type=file name=img> 입력양식의 파일이 저장된 MultipartFile 객체 저장 매개변수 선언
				// <주의> 업로드된 파일이 없어도 MultipartFile 객체는 생성되어 들어온다.
				,@RequestParam("img") MultipartFile multi
				// ***************************************************
				// 유효성 검사 결과를 관리하는 BindingResult 객체가 저장되어 들어오는 
				// 매개변수 bindingResult 선언
				// ***************************************************
				,BindingResult bindingResult
		) throws Exception{
			//******************************************
			// 업로드한 파일의 크기와 확장자 체크하기
			//******************************************
			// 만약에 업로드된 파일이 있으면 
			if(multi.isEmpty()==false) {
				
				
				// 만약에 업로드된 파일의 크기가 1000000 byte(=1000kb) 보다 크면
				if(multi.getSize()>1000000) {
					Map<String,String> map = new HashMap<String,String>();
					map.put("boardUpDelCnt","0");
					map.put("msg","업로드 파일이 1000kb 보다 크면 안됩니다.");
					return map;
				}
				// 만약에 업로드된 파일의 확장자가 이미지 확장자가 아니면
				String fileName = multi.getOriginalFilename();
				fileName = fileName.toLowerCase();
				if(fileName.endsWith(".jpg")==false && fileName.endsWith(".png")==false && fileName.endsWith(".gif")==false) {
					Map<String,String> map = new HashMap<String,String>();
					map.put("boardUpDelCnt","0");
					map.put("msg","이미지 파일이 아닙니다.");
					return map;
				}
			}
			
			// 수정 또는 삭제 행의 적용 개수 저장할 변수 선언
			int boardUpDelCnt=0;
			// 유효성 체크 에러 메시지 저장할 변수 msg 선언
			String msg = "";
			// 만약 게시판 삭제 모드이면
			if(upDel.equals("del")) {
				// 삭제 실행하고 삭제 적용행의 개수얻기
				boardUpDelCnt = this.boardService.deleteBoard(boardDTO);
				
			}
			// 만약 게시판 수정 모드이면 수정 실행하고 수정 적용행의 개수얻기
			else if(upDel.equals("up")) {
				//***************************************************************
				//check_BoardDTO 메소드 호출하여 [유효성 체크]하고 경고문자 얻기
				//***************************************************************
				// check_BoardDTO 메소드를 호출하여 유효성 체크하고 에러 메시지 문자 얻기
				msg = check_BoardDTO(boardDTO,bindingResult);
				
				
				// 만약 msg 안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과했으면
				if(msg.equals("")) {
					// boardServiceImpl 객체의 updateBoard 라는 메소드 호출로
					// 게시판 수정 실행하고 수정 적용행의 개수 얻기
					boardUpDelCnt = this.boardService.updateBoard(boardDTO, multi);
					
					
				}
				
				// 만약 msg 안에 ""가 저장되어 있지 않으면, 즉 유효성 체크를 통과 못했으면
				else {
				}		
				
			}
			
			
			//*******************************************
			// HashMap<String,String> 객체 생성하기
			// HashMap<String,String> 객체에 게시판 수정.삭제 성공행의 개수 저장하기
			// HashMap<String,String> 객체에 유효성 체크 시 메시지 저장하기
			// HashMap<String,String> 객체 리턴하기
			//*******************************************

			Map<String,String> map = new HashMap<String,String>();
			map.put("boardUpDelCnt", boardUpDelCnt+"");
			map.put("msg", msg);
			return map;
		}
		
		
}
