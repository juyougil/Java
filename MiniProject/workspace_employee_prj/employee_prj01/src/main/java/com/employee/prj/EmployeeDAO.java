package com.employee.prj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

	// [게시판 글 입력 후 적용 행의 개수 리턴하는 메소드 선언]
	int insertEmployee(EmployeeDTO employeeDTO);
	
	// [검색한 게시판 목록] 리턴하는 메소드 선언
	public List<Map<String,String>> getEmployeeList(EmployeeSearchDTO employeeSearchDTO);
	
	// [1개의 게시판 정보]를 리턴하는 메소드 선언
	EmployeeDTO getEmployee(int e_no);
	
	
	
	//수정할 게시판의 존재 개수를 리턴하는 메소드 선언
	int getEmployeeCnt(EmployeeDTO employeeDTO);
	
	
	// 게시판 수정 명령한 후 수정 적용행의 개수를 리턴하는 메소드 선언
	int updateEmployee(EmployeeDTO employeeDTO);
	

	
	
	// [삭제할 게시판의 명령한 후 삭제 적용행의 개수]를 얻는 메소드 선언
	int deleteEmployee(EmployeeDTO employeeDTO);
	
	
	// [검색한 게시판 목록 총개수] 리턴하는 메소드 선언
	int getEmployeeListAllCnt(EmployeeSearchDTO employeeSearchDTO);
	
	
	// 사장직급존재여부
	int getpresidentCnt();
	
	
	int getEmployeeCustomerCnt(int e_no);
	
	int getMgrEmpCnt(int e_no);
	
	int getupdateCustomerCnt(EmployeeDTO employeeDTO);
	
	int getupdateMgrEmpNoCnt(EmployeeDTO employeeDTO);
	

	List<Map<String,String>> getjikupList();
	List<Map<String,String>> getdeptList();
	
	String getPic(EmployeeDTO employeeDTO);
}
