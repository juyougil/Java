package com.employee.prj;

import org.springframework.web.multipart.MultipartFile;

public interface EmployeeService {
	
	// [게시판 글 입력 후 입력 적용 행의 개수] 리턴하는 메소드 선언
	int insertEmployee(EmployeeDTO employeeDTO,MultipartFile multi ) throws Exception;
	
	
	
	// [1개 게시판 글] 리턴하는 메소드 선언
	EmployeeDTO getEmployee(int emp_no);
	
	// [1개 게시판] 수정 실행하고 수정 적용행의 개수를 리턴하는 메소드 선언
	int updateEmployee(EmployeeDTO employeeDTO,MultipartFile multi) throws Exception;

	// [1개 게시판] 삭제 후 삭제 적용행의 개수를 리턴하는 메소드 선언
	int deleteEmployee(EmployeeDTO employeeDTO);
	
	
	
}
