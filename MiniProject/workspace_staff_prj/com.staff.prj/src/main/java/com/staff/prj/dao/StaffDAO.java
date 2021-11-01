package com.staff.prj.dao;

import java.util.List;
import java.util.Map;

import com.staff.prj.dto.StaffDTO;
import com.staff.prj.dto.StaffSearchDTO;

public interface StaffDAO {
	public List<Map<String,String>> getStaffList(StaffSearchDTO staffSearchDTO );
	
	public List<Map<String,String>> getSkillList();
	
	public List<Map<String,String>> getReligionList();
	
	public List<Map<String,String>> getSchoolList();
	
	public String getMin_Year();
	public String getMax_Year();
	
	public int getStaffListAllCnt(StaffSearchDTO staffSearchDTO);
	
	public int getInputStaffCnt(StaffDTO staffDTO);
	
	public int getInputStaffSkillCnt(StaffDTO staffDTO);
	
	
	
	public int getUpdateStaffSkillCnt(StaffDTO staffDTO);
	
	
	
	
	public StaffDTO getStaff(int staff_no);
	
	public List<Map<String,String>> getStaffSkill(int staff_no);
	
	public int getStaffCnt(StaffDTO staffDTO);
	
	
	public int getStaffSkillCnt(StaffDTO staffDTO);
	
	
	
	public int getDeleteStaffSkillCnt(StaffDTO staffDTO);
	
	
	public int getUpdateStaffCnt(StaffDTO staffDTO);
	
	
	public int getDeleteStaffCnt(StaffDTO staffDTO);
	
	
	
	public String getSYSDATE();
	
	public int getJumin_no(StaffDTO staffDTO);
	
	
}
