package com.staff.prj.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.staff.prj.dto.StaffDTO;
import com.staff.prj.dto.StaffSearchDTO;

import java.util.List;
import java.util.Map;

// [DAO 클래스]인 [BoardDAOImpl 클래스] 선언
	//@Repository 를 붙임으로써 [DAO 클래스]임을 지정하게되고, bean 태그로 자동 등록된다.
@Repository
public class StaffDAOImpl implements StaffDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Map<String, String>> getStaffList(StaffSearchDTO staffSearchDTO ) {
		List<Map<String,String>> staffList = this.sqlSession.selectList(
				"com.staff.prj.dao.StaffDAO.getStaffList"	
				,staffSearchDTO
		);
		return staffList;
	}


	public List<Map<String, String>> getSkillList() {
		List<Map<String,String>> skillList = this.sqlSession.selectList(
				"com.staff.prj.dao.StaffDAO.getSkillList"	
		);
		
		return skillList;
	}


	public List<Map<String, String>> getReligionList() {
		List<Map<String,String>> religionList = this.sqlSession.selectList(
				"com.staff.prj.dao.StaffDAO.getReligionList"	
		);
		
		return religionList;
	}


	@Override
	public List<Map<String, String>> getSchoolList() {
		List<Map<String,String>> schoolList = this.sqlSession.selectList(
				"com.staff.prj.dao.StaffDAO.getSchoolList"	
		);
		
		return schoolList;
	}


	public String getMin_Year() {
		String min_year = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getMin_Year"	
		);
		
		return min_year;
	}


	public String getMax_Year() {
		String max_year = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getMax_Year"	
		);
		
		return max_year;
	}


	public int getStaffListAllCnt(StaffSearchDTO staffSearchDTO) {
		int staffListAllCnt = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getStaffListAllCnt"	
				,staffSearchDTO
		);
		
		return staffListAllCnt;
	}



	public int getInputStaffCnt(StaffDTO staffDTO) {
		int inputStaffCnt = sqlSession.insert(
				"com.staff.prj.dao.StaffDAO.getInputStaffCnt"	
				,staffDTO
		);
		return inputStaffCnt;
	}


	@Override
	public int getInputStaffSkillCnt(StaffDTO staffDTO) {
		int inputStaffSkillCnt = sqlSession.insert(
				"com.staff.prj.dao.StaffDAO.getInputStaffSkillCnt"	
				,staffDTO
		);
		return inputStaffSkillCnt;
	}


	public StaffDTO getStaff(int staff_no) {
		StaffDTO staffDTO = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getStaff"	
				,staff_no
		);
		
		return staffDTO;
	}



	public List<Map<String, String>> getStaffSkill(int staff_no) {
		List<Map<String,String>> staffSkill = this.sqlSession.selectList(
				"com.staff.prj.dao.StaffDAO.getStaffSkill"	
				,staff_no
		);
		
		return staffSkill;
	}



	public int getStaffCnt(StaffDTO staffDTO) {
		int staffCnt = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getStaffCnt"	
				,staffDTO
		);
		
		return staffCnt;
	}


	
	public int getStaffSkillCnt(StaffDTO staffDTO) {
		int staffSkillCnt = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getStaffSkillCnt"	
				,staffDTO
		);
		
		return staffSkillCnt;
	}



	public int getDeleteStaffSkillCnt(StaffDTO staffDTO) {
		int deleteStaffSkillCnt = this.sqlSession.delete(
				"com.staff.prj.dao.StaffDAO.getDeleteStaffSkillCnt"	
				,staffDTO
		);
		
		return deleteStaffSkillCnt;
	}



	public int getDeleteStaffCnt(StaffDTO staffDTO) {
		int deleteStaffCnt = this.sqlSession.delete(
				"com.staff.prj.dao.StaffDAO.getDeleteStaffCnt"	
				,staffDTO
		);
		
		return deleteStaffCnt;
	}



	public int getUpdateStaffSkillCnt(StaffDTO staffDTO) {
		int updateStaffSkillCnt = sqlSession.insert(
				"com.staff.prj.dao.StaffDAO.getUpdateStaffSkillCnt"	
				,staffDTO
		);
		return updateStaffSkillCnt;
	}



	public int getUpdateStaffCnt(StaffDTO staffDTO) {
		int updateStaffCnt = this.sqlSession.update(
				"com.staff.prj.dao.StaffDAO.getUpdateStaffCnt"	
				,staffDTO
		);
		
		return updateStaffCnt;
	}



	public String getSYSDATE() {
		String sysdate = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getSYSDATE"	
		);
		
		return sysdate;
	}



	public int getJumin_no(StaffDTO staffDTO) {
		int jumin_noCnt = this.sqlSession.selectOne(
				"com.staff.prj.dao.StaffDAO.getJumin_no"	
				,staffDTO
		);
		
		return jumin_noCnt;
	}
	



}
