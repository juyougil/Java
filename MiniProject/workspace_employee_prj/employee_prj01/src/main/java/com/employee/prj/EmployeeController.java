package com.employee.prj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private EmployeeService employeeService;

		
	@RequestMapping(value="/employeeList.do")
	public ModelAndView getEmployeeList(
			EmployeeSearchDTO employeeSearchDTO
	) {
		
		
		// 검색 조건에 맞는 [게시판 목록의 총개수] 얻기
		int employeeListAllCnt = this.employeeDAO.getEmployeeListAllCnt(employeeSearchDTO);
		
		
		int last_pageNo = 0;
		int min_pageNo = 0;
		int max_pageNo = 0;
		int selectPageNo = employeeSearchDTO.getSelectPageNo();
		int rowCntPerPage = employeeSearchDTO.getRowCntPerPage();
		int pageNoCntPerPage=10;
		
		// 만약 검색된 결과물의 개수가 0보다 크면, 즉 검색 결과물이 있으면
		if(employeeListAllCnt>0) {
			// 마지막 페이지 번호 구하기
			last_pageNo = employeeListAllCnt/rowCntPerPage;
				if(employeeListAllCnt%rowCntPerPage>0){last_pageNo++;}
			// 만약 선택한 페이지 번호가 마지막 페이지 번호보다 크면	
			if(selectPageNo>last_pageNo) {
				// selectPageNo 변수에 1 저장하기
				selectPageNo=1;
				// BoardSearchDTO 객체의 selectPageNo 속성 변수에 1저장하기
				employeeSearchDTO.setSelectPageNo(selectPageNo);
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
		List<Map<String,String>> employeeList = this.employeeDAO.getEmployeeList(employeeSearchDTO);
		
		
		
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName("employeeList.jsp");
		// [ModelAndView 객체]에 [게시판 목록 검색 결과]를 저장하기
		// [ModelAndView 객체]에 [게시판 목록의 총개수]를 저장하기
		
		// [ModelAndView 객체]에 [마지막 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최소 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [현재 화면에 보여지는 페이지 번호의 최대 페이지 번호]를 저장하기
		
		// [ModelAndView 객체]에 [선택한 페이지 번호]를 저장하기
		// [ModelAndView 객체]에 [한 화면에 보여줄 행의 개수]를 저장하기
		// [ModelAndView 객체]에 [한 화면에 보여줄 페이지 번호의 개수]를 저장하기
		mav.addObject("employeeList",employeeList );
		mav.addObject("employeeListAllCnt",employeeListAllCnt );
		
		mav.addObject("last_pageNo",last_pageNo );
		mav.addObject("min_pageNo",min_pageNo );
		mav.addObject("max_pageNo",max_pageNo );
		
		mav.addObject("selectPageNo",selectPageNo );
		mav.addObject("rowCntPerPage",rowCntPerPage );
		mav.addObject("pageNoCntPerPage",pageNoCntPerPage );
		
		
		
		
		
		// [ModelAndView 객체] 리턴하기
		return mav;
	}
	
	
	
	@RequestMapping(value="/employeeRegForm.do")
	public ModelAndView goEmployeeRegForm(
		
		) {
		// [ModelAndView 객체] 생성하기
		int presidentCnt = this.employeeDAO.getpresidentCnt();
		List<Map<String, String>> jikupList = this.employeeDAO.getjikupList();
		List<Map<String, String>> deptList = this.employeeDAO.getdeptList();
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName("employeeRegForm.jsp");
		mav.addObject("presidentCnt",presidentCnt);
		mav.addObject("jikupList",jikupList);
		mav.addObject("deptList",deptList);
		// [ModelAndView 객체] 리턴하기
		return mav;
	}
	
	
	
	
	
	// /boardRegProc.do 로 접근하면 호출되는 메소드 선언하기
	@RequestMapping(value="/employeeRegProc.do")
	public ModelAndView insertEmployee(
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
			EmployeeDTO employeeDTO
			,@RequestParam("img") MultipartFile multi
			// ***************************************************
			// Error 객체를 관리하는 BindingResult 객체가 저장되어 들어오는 매개변수 bindingResult 선언
			// ***************************************************
			,BindingResult bindingResult
	) {
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName("employeeRegProc.jsp");
		
		
		if(multi.isEmpty()==false) {
			
			
			// 만약에 업로드된 파일의 크기가 1000000 byte(=1000kb) 보다 크면
			if(multi.getSize()>1000000) {
				mav.addObject("employeeRegCnt",0);
				mav.addObject("msg","업로드 파일이 1000kb 보다 크면 안됩니다.");
				return mav;
			}
			// 만약에 업로드된 파일의 확장자가 이미지 확장자가 아니면
			String fileName = multi.getOriginalFilename();
			fileName = fileName.toLowerCase();
			if(fileName.endsWith(".jpg")==false && fileName.endsWith(".png")==false && fileName.endsWith(".gif")==false) {
				mav.addObject("employeeRegCnt",0);
				mav.addObject("msg","이미지 파일이 아닙니다.");
				return mav;
			}
		}		
		try {
			/*System.out.println(boardDTO.getB_no());
			System.out.println(boardDTO.getWriter());
			System.out.println(boardDTO.getSubject());
			System.out.println(boardDTO.getContent());
			System.out.println(boardDTO.getPwd());*/
			
			
			//***************************************************************
			//check_BoardDTO 메소드 호출하여 [유효성 체크]하고 경고문자 얻기
			//***************************************************************
			// 유효성 체크 에러 메시지 저장할 변수 msg 선언
			String msg = "";
			
			// check_BoardDTO 메소드를 호출하여 유효성 체크하고 에러 메시지 문자 얻기
			msg = check_BoardDTO(employeeDTO,bindingResult);
			
			
			// [ModelAndView 객체] 에 [유효성 체크 에러 메시지] 저장하기
			// ModelAndView 객체에 유효성 체크 시 발생한 에러 메시지 저장하기
			mav.addObject("msg",msg );
			// 만약 msg 안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과했으면
			if(msg.equals("")) {
				// [BoardServiceImpl 객체]의 insertBoard 메소드 호출로
				// 게시판 글 입력하고 [게시판 입력 적용행의 개수] 얻기
				int employeeRegCnt = this.employeeService.insertEmployee(employeeDTO,multi);
				System.out.println("boardRegCnt => " +employeeRegCnt);

				


				// [ModelAndView 객체] 에 [게시판 입력 적용행의 개수] 저장하기
				mav.addObject("employeeRegCnt",employeeRegCnt);
				System.out.println("employeeRegProc insertBoard 성공");	
			}
			// 만약 msg 안에 ""가 저장되어 있지 않으면, 즉 유효성 체크를 통과 못했으면
			else {
				mav.addObject("employeeRegCnt",0);
			}
			
		}catch(Exception ex) {
			
			mav.addObject("employeeRegCnt",-1);
			mav.addObject("msg","서버에서 문제 발생");
		}
		// 객체 리턴하기
		return mav;
	}
	
	// 게시판 입력 또는 수정 시 게시판 입력글의 입력양식의 유효성을 검사하고
	// 문제가 있으면 경고 문자를 리턴하는 메소드 선언.
	public String check_BoardDTO(EmployeeDTO employeeDTO ,BindingResult bindingResult) {
		String checkMsg="";
		// BoardDTO 객체에 저장된 데이터의 유효성 체크할 BoardValidator 객체 생성하기
		// BoardValidator 객체의 validate 메소드 호출하여 유효성 체크 실행하기
		EmployeeValidator employeeValidator = new EmployeeValidator();
		employeeValidator.validate(
				employeeDTO			// 유효성 체크할 DTO 객체
				,bindingResult		// 유효성 체크 결과를 관리하는 BindingResult 객체
		);
		// 만약 BindingResult 객체의 hasErrors() 메소드 호출하여 true 값을 얻으면
		if(bindingResult.hasErrors()) {
			// 변수 checkMsg 에 BoardValidator 객체에 저장된 경고문구 얻어 저장하기
			checkMsg = bindingResult.getFieldError().getCode();
		}
		
		
		return checkMsg;
		
		
	}	
	
	
	
	// boardUpDelForm.do 접속 시 호출되는 메소드 선언
	@RequestMapping(value="/employeeUpDelForm.do")
	
	// "b_no" 라는 파라미터명의 파라미터값이 저장되는 매개변수 b_no 선언
	// 수정 또는 삭제할 게시판 고유 번호가 들어오는 매개변수 선언
	public ModelAndView goEmployeeUpDelForm(
			@RequestParam(value="emp_no") int emp_no	
	) {
		int presidentCnt = this.employeeDAO.getpresidentCnt();
		int employeecustomerCnt = this.employeeDAO.getEmployeeCustomerCnt(emp_no);
		int mgrCnt = this.employeeDAO.getMgrEmpCnt(emp_no);
		//boardDAOImpl 객체의 getBoard 메소드 호출로
		// 1개의 게시판글을 BoardDTO 객체에 담아서 가져오기
		EmployeeDTO employeeDTO = this.employeeDAO.getEmployee(emp_no);
		
		
		
		List<Map<String, String>> jikupList = this.employeeDAO.getjikupList();
		List<Map<String, String>> deptList = this.employeeDAO.getdeptList();
		// [ModelAndView 객체] 생성하기
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		// [ModelAndView 객체]에 [게시판 목록 검색 결과]를 저장하기
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employeeUpDelForm.jsp");
		mav.addObject("employeeDTO",employeeDTO);
		mav.addObject("presidentCnt",presidentCnt);
		mav.addObject("employeecustomerCnt",employeecustomerCnt );
		mav.addObject("mgrCnt",mgrCnt );
		mav.addObject("jikupList",jikupList );
		mav.addObject("deptList",deptList );
		return mav;
		
	}	
	
	
	
	
	
	
	
	@RequestMapping(value="/employeeUpDelProc.do")
	public ModelAndView EmployeeUpDelProc(
			//파라미터값을 저장할 [BoardDTO 객체]를 매개변수로 선언
			EmployeeDTO employeeDTO							
			// "upDel"이라는 파라미터명의 파라미터값이 저장된 매개변수 upDel선언
			,@RequestParam(value="upDel") String upDel	
			,@RequestParam("img") MultipartFile multi
			// ***************************************************
			// 유효성 검사 결과를 관리하는 BindingResult 객체가 저장되어 들어오는 
			// 매개변수 bindingResult 선언
			// ***************************************************
			,BindingResult bindingResult
	) throws Exception{
		// [ModelAndView 객체] 생성하기
		ModelAndView mav = new ModelAndView();
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		mav.setViewName("employeeUpDelProc.jsp");
		
		if(multi.isEmpty()==false) {
			
			
			// 만약에 업로드된 파일의 크기가 1000000 byte(=1000kb) 보다 크면
			if(multi.getSize()>1000000) {
				mav.addObject("employeeUpDelCnt",0);
				mav.addObject("msg","업로드 파일이 1000kb 보다 크면 안됩니다.");
				return mav;
			}
			// 만약에 업로드된 파일의 확장자가 이미지 확장자가 아니면
			String fileName = multi.getOriginalFilename();
			fileName = fileName.toLowerCase();
			if(fileName.endsWith(".jpg")==false && fileName.endsWith(".png")==false && fileName.endsWith(".gif")==false) {
				mav.addObject("employeeUpDelCnt",0);
				mav.addObject("msg","이미지 파일이 아닙니다.");
				return mav;
			}
		}	
		
		// 만약 게시판 삭제 모드이면
		if(upDel.equals("del")) {
			
			
			
			
			// 삭제 실행하고 삭제 적용행의 개수얻기
			int employeeUpDelCnt = this.employeeService.deleteEmployee(employeeDTO);
			
			mav.addObject("employeeUpDelCnt",employeeUpDelCnt );
		}
		// 만약 게시판 수정 모드이면 수정 실행하고 수정 적용행의 개수얻기
		else if(upDel.equals("up")) {
			//***************************************************************
			//check_BoardDTO 메소드 호출하여 [유효성 체크]하고 경고문자 얻기
			//***************************************************************
			// 유효성 체크 에러 메시지 저장할 변수 msg 선언
			String msg = "";
			
			// check_BoardDTO 메소드를 호출하여 유효성 체크하고 에러 메시지 문자 얻기
			msg = check_BoardDTO(employeeDTO,bindingResult);
			
			// ModelAndView 객체에 유효성 체크 시 발생한 에러 메시지 저장하기
			mav.addObject("msg",msg );
			
			// 만약 msg 안에 ""가 저장되어 있으면, 즉 유효성 체크를 통과했으면
			if(msg.equals("")) {
				// boardServiceImpl 객체의 updateBoard 라는 메소드 호출로
				// 게시판 수정 실행하고 수정 적용행의 개수 얻기
				int employeeUpDelCnt = this.employeeService.updateEmployee(employeeDTO,multi);
				
				
				// [ModelAndView 객체]에 [게시판 수정 적용행의 개수] 저장하기
				mav.addObject("employeeUpDelCnt",employeeUpDelCnt );
			}
			
			// 만약 msg 안에 ""가 저장되어 있지 않으면, 즉 유효성 체크를 통과 못했으면
			else {
				mav.addObject("employeeUpDelCnt",0 );
			}		
			
		}
		// [ModelAndView 객체] 리턴하기
		return mav;
	}
	
	
	
	@RequestMapping( value="/employeeContentForm.do" )

	public ModelAndView goBoardContentForm( 
			@RequestParam(value="emp_no") int emp_no	
			,@RequestParam(value="mgr_emp_no"		
			, required=false				
			, defaultValue="0") int mgr_emp_no
	){

		EmployeeDTO employeeDTO;
		if(mgr_emp_no==0) {
			employeeDTO = this.employeeService.getEmployee(emp_no);
		}else {
			employeeDTO = this.employeeService.getEmployee(mgr_emp_no);
			
		}

		

		//*******************************************
		// [ModelAndView 객체] 생성하기
		// [ModelAndView 객체]에 [호출 JSP 페이지명]을 저장하기
		//*******************************************
		ModelAndView mav = new ModelAndView( );
		mav.setViewName("employeeContentForm.jsp");
		mav.addObject("employeeDTO", employeeDTO);

		//*******************************************
		// [ModelAndView 객체] 리턴하기
		//*******************************************
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
