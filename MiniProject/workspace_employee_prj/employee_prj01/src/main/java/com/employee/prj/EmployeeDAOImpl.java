package com.employee.prj;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// [DAO 클래스]인 [BoardDAOImpl 클래스] 선언
	//@Repository 를 붙임으로써 [DAO 클래스]임을 지정하게되고, bean 태그로 자동 등록된다.
@Repository
public class EmployeeDAOImpl implements EmployeeDAO { 
	
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	
	
	

	// [검색한 게시판 목록] 리턴하는 메소드 선언
	public List<Map<String,String>> getEmployeeList(EmployeeSearchDTO employeeSearchDTO){
		List<Map<String,String>> employeeList = this.sqlSession.selectList(
				"com.employee.prj.EmployeeDAO.getEmployeeList"	// 실행할 SQL 구문의 위치 지정
									// 실행할 SQL 구문에서 사용할 데이터 지정
				,employeeSearchDTO
		);
		
		return employeeList;
	}
	
	
	
	
	
	
	// [검색한 게시판 목록 총개수] 리턴하는 메소드 선언
	public int getEmployeeListAllCnt(EmployeeSearchDTO employeeSearchDTO) {
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 를 호출하여 [게시판의 존재 개수] 얻기
		int employeeListAllCnt = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getEmployeeListAllCnt"	// 실행할 SQL 구문의 위치 지정
				,employeeSearchDTO								// 실행할 SQL 구문에서 사용할 데이터
		);
		return employeeListAllCnt;
	}
	
	
	
	
	
	
	
	//[게시판 글 입력 후 입력 적용 행의 개수]를 리턴하는 메소드 선언
	public int insertEmployee(EmployeeDTO employeeDTO) {
		// SqlSessionTemplate 객체의 insert 메소드 호출로
		// 게시판 글 입력 SQL 구문을 실행하고 입력 성공 행의 갯수얻기
		int employeeRegCnt = sqlSession.insert(
				// 실행할 SQL 구문의 위치를 지정하기
				// 실행할 SQL 구문의 위치 문자열 패턴은 아래와 같다.
				// xml 파일 중에 "mapper태그의 namespace명.mapper태그내부의호출할 SQL 구문소유한 태그id값"
				"com.employee.prj.EmployeeDAO.insertEmployee"
				// 호출할 SQL 구문에서 사용할 데이터 저장하기
				,employeeDTO
				
				
				
				
		);
		System.out.println("BoardDAOImpl 성공");
		return employeeRegCnt;
	}
	
	
	
	
	
	// [1개 게시판 글 정보] 리턴하는 메소드 선언
	public EmployeeDTO getEmployee(int emp_no) {
		// [SqlSessionTemplate 객체]의  selectOne(~,~) 를 호출하여 [1개 게시판 글 정보] 얻기
		EmployeeDTO employeeDTO = this.sqlSession.selectOne(
				//-----------------------------------------------
				// 실행할 SQL 구문의 위치를 지정하기.
				// 실행할 SQL 구문의 위치 문자열 패턴은 아래와 같다.
				// xml 파일 중에 "mapper태그의namespace명.mapper태그내부의호출할SQL구문소유한태그id값"
				//-----------------------------------------------
				"com.employee.prj.EmployeeDAO.getEmployee"	// 실행할 SQL 구문의 위치 지정
				//-----------------------------------------------
				// 실행할 SQL구문에서 사용할 데이터 지정하기
				//-----------------------------------------------
				,emp_no								// 실행할 SQL 구문에서 사용할 데이터 지정

				
		);
		// [1개 게시판 글 정보] 리턴하기
		return employeeDTO;
	}
	





	// 삭제/수정할 게시판의 존재 개수를 리턴하는 메소드 선언
	public int getEmployeeCnt(EmployeeDTO employeeDTO) {
		
		
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 를 호출하여 [게시판의 존재 개수] 얻기
		int employeeCnt = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getEmployeeCnt"	// 실행할 SQL 구문의 위치 지정
				,employeeDTO								// 실행할 SQL 구문에서 사용할 데이터
		);
		return employeeCnt;
	}





	// 게시판 수정 후 수정 적용행의 개수를 리턴하는 메소드 선언
	public int updateEmployee(EmployeeDTO employeeDTO) {
		//-------------------------------------------------------
		// [SqlSessionTemplate 객체]의 update(~,~) 를 호출하여 [게시판 수정]하기
		//-------------------------------------------------------
		int employeeCnt = this.sqlSession.update(
				"com.employee.prj.EmployeeDAO.updateEmployee" // 실행할 SQL 구문의 위치 지정
				,employeeDTO							     // 실행할 SQL 구문에서 사용할 데이터 지정
		);
		return employeeCnt;

	}





	// 게시판 삭제 명령한 후 삭제 적용행의 개수를 리턴하는 메소드 선언
	public int deleteEmployee(EmployeeDTO employeeDTO) {
		//-------------------------------------------------------
		// [SqlSessionTemplate 객체]의 delete(~,~) 를 호출하여
		// [게시판 삭제 명령]한 후 삭제 적용행의 개수얻기
		//-------------------------------------------------------
		int deleteEmployeeCnt = this.sqlSession.delete(
				"com.employee.prj.EmployeeDAO.deleteEmployee" // 실행할 SQL 구문의 위치 지정
				,employeeDTO								// 실행할 SQL 구문에서 사용할 데이터 지정
		);
		return deleteEmployeeCnt;
	}






	public int getpresidentCnt() {
		int presidentCnt = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getpresidentCnt" // 실행할 SQL 구문의 위치 지정
		);
		return presidentCnt;
	}






	public int getEmployeeCustomerCnt(int e_no) {
		int employeeCustomerCnt = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getEmployeeCustomerCnt" // 실행할 SQL 구문의 위치 지정
				,e_no
		);
		return employeeCustomerCnt;
	}






	public int getupdateCustomerCnt(EmployeeDTO employeeDTO) {
		int updateCustomerCnt = this.sqlSession.update(
				"com.employee.prj.EmployeeDAO.getupdateCustomerCnt" // 실행할 SQL 구문의 위치 지정
				,employeeDTO
		);
		return updateCustomerCnt;
	}






	@Override
	public int getMgrEmpCnt(int e_no) {
		int mgrCnt = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getMgrCnt" // 실행할 SQL 구문의 위치 지정
				,e_no
		);
		return mgrCnt;
	}






	public int getupdateMgrEmpNoCnt(EmployeeDTO employeeDTO) {
		int updateMgrEmpNoCnt = this.sqlSession.update(
				"com.employee.prj.EmployeeDAO.getupdateMgrEmpNoCnt" // 실행할 SQL 구문의 위치 지정
				,employeeDTO
		);
		return updateMgrEmpNoCnt;
	}






	@Override
	public List<Map<String,String>> getjikupList() {
		List<Map<String,String>> jikupList = this.sqlSession.selectList(
				"com.employee.prj.EmployeeDAO.getjikupList" // 실행할 SQL 구문의 위치 지정
		);
		return jikupList;
	}






	@Override
	public List<Map<String, String>> getdeptList() {
		List<Map<String,String>> deptList = this.sqlSession.selectList(
				"com.employee.prj.EmployeeDAO.getdeptList" // 실행할 SQL 구문의 위치 지정
		);
		return deptList;
	}






	@Override
	public String getPic(EmployeeDTO employeeDTO) {
		// [SqlSessionTemplate 객체]의 selectOne(~,~) 를 호출하여 [게시판의 존재 개수] 얻기
		String pic = this.sqlSession.selectOne(
				"com.employee.prj.EmployeeDAO.getPic"	// 실행할 SQL 구문의 위치 지정
				,employeeDTO								// 실행할 SQL 구문에서 사용할 데이터
		);
		return pic;
	}





}
