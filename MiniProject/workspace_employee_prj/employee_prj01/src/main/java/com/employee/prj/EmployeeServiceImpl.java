package com.employee.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
//[서비스 클래스]인 [BoardSeviceImpl 클래스] 선언
	// [서비스 클래스]에는 @Service @Transactional를 붙인다.
	// MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	// @Service 		=> [서비스 클래스] 임을 지정하고 bean 태그로 자동 등록된다
	// @Transactional	=> [서비스 클래스]의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	// 속성변수 boardDAO 선언하고, [BoardDAO 인테페이스]를 구현한 클래스를 객체화해서 저장한다.
		// @Autowired 역할 -> 속성변수에 붙은 자료형인 [인터페이스]를 구현한 [클래스]를 객체화하여 저장한다.
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	String uploadDir = Info.board_pic_dir;
	// [1개 게시판 글 입력 후 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	public int insertEmployee(EmployeeDTO employeeDTO,MultipartFile multi) throws Exception {
		
		// 사용자 정의 FileUpLoad 객체 성성하기
		FileUpLoad fileUpLoad = new FileUpLoad(multi);
		
		// 업로드한 파일의 새로운 이름 정하기
		// BoardDTO 객체에 새로운 파일명 저장하기
		employeeDTO.setPic(fileUpLoad.getNewFileName());
		

		// BoardDAOImpl 객체의 insertBoard 메소드 호출하여 게시판 글 입력 후 입력 적용 행의 개수 얻기
		int employeeRegCnt = this.employeeDAO.insertEmployee(employeeDTO);
		
		// 파일 업로드하기
		fileUpLoad.uploadFile(uploadDir);

		// 1개 게시판 글 입력 적용 행의 개수 리턴하기
		System.out.println("EmployeeServiceImpl 성공");
		return employeeRegCnt;
	}
	


	// [1개 게시판 글] 리턴하는 메소드 선언
	public EmployeeDTO getEmployee(int emp_no) {
		
		
		// BoardDAOImpl 객체의 getBoard 메소드를 호출하여
		// [1개 게시판 글]을 얻는다.
		EmployeeDTO employeeDTO = this.employeeDAO.getEmployee(emp_no);
		// [1개 게시판 글]이 저장된 BoardDTO 객체 리턴하기
		return employeeDTO;
	}



	// [1개 게시판] 수정 실행하고 수정 적용행의 개수를 리턴하는 메소드 선언
	public int updateEmployee(EmployeeDTO employeeDTO,MultipartFile multi) throws Exception {
		// [BoardDAOImpl 객체]의 getBoardCnt메소드를 호출하여
		// 수정할 게시판의 존재 개수를 얻는다.
		int employeeCnt = this.employeeDAO.getEmployeeCnt(employeeDTO);
		if(employeeCnt==0) {return -1;}
		
		// 사용자 정의 FileUpLoad 객체 생성하기
		FileUpLoad fileUpLoad = new FileUpLoad(multi);
		
		// 업로드한 파일의 새로운 이름 구하기
		String newFileName = null;
		
		// 삭제 체크 여부 구하기
		String is_del = employeeDTO.getIs_del();
		
		// 만약에 삭제가 체크되어 있지 않으면
		// 업로드한 파일의 새로운 이름 구하기
		// BoardDTO 객체에 새로운 파일명 저장하기
		newFileName = fileUpLoad.getNewFileName(is_del==null);
		employeeDTO.setPic(newFileName);
		
		
		// DB연동 부분
		//////////////////////////////////////////////////////
		// board 테이블에 있는 기존 이미지 이름 가져오기
		String pic = this.employeeDAO.getPic(employeeDTO);
		// [BoardDAOImpl 객체]의 updateBoard 메소드를 호출하여
		// 게시판 수정 명령한 후 수정 적용행의 개수를 얻는다.
		int updateCnt = this.employeeDAO.updateEmployee(employeeDTO);
		// 삭제가 체크 안되있으면
		if(is_del==null) {
			// 기존 이미지 파일 삭제하기
				// 기존 이미지 파일 삭제하기
				// board 테이블에 이미지 이름이 있으면 파일 삭제하기
				fileUpLoad.delete(uploadDir+ pic,multi!=null && multi.isEmpty()==false && pic!=null && pic.length()>0);		
				// 파일 업로드하기
				fileUpLoad.uploadFile(uploadDir);
				
		}
		// 삭제가 체크 되있으면
		else {
			
				fileUpLoad.delete(uploadDir+ pic,pic!=null && pic.length()>0);
			
		}
		return updateCnt;
	}


	// [1개 게시판] 삭제 후 삭제 적용행의 개수를 리턴하는 메소드 선언
	public int deleteEmployee(EmployeeDTO employeeDTO) {
		
		// [BoardDAOImpl 객체]의 getBoardCnt메소드를 호출하여
		// 삭제할 게시판의 존재 개수를 얻는다.
		int employeeCnt = this.employeeDAO.getEmployeeCnt(employeeDTO);
		if(employeeCnt==0) {return -1;}

	
		
		if(employeeDTO.getCustomerRemove().length()>0) {
			int updateCustomerCnt = this.employeeDAO.getupdateCustomerCnt(employeeDTO);
			System.out.println("getupdateCustomerCnt 성공");
			if(updateCustomerCnt==0) {return -2;}
			
		}

		if(employeeDTO.getMgrEmpNORemove().length()>0) {
			int updateMgrEmpNoCnt = this.employeeDAO.getupdateMgrEmpNoCnt(employeeDTO);
			System.out.println("getupdateMgrEmpNoCnt 성공");
			if(updateMgrEmpNoCnt==0) {return -3;}
		}	
		

		// [BoardDAOImpl 객체]의 deleteBoard메소드를 호출하여
		// [게시판 삭제 명령한 후 삭제 적용행의 개수]를 얻는다.
		int deleteCnt = this.employeeDAO.deleteEmployee(employeeDTO);
		System.out.print("deleteCnt 성공");
		return deleteCnt;
	}





}
