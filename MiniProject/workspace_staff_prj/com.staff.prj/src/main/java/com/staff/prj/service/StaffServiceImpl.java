package com.staff.prj.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.staff.prj.dao.StaffDAO;
import com.staff.prj.dto.StaffDTO;
//[서비스 클래스]인 [BoardSeviceImpl 클래스] 선언
	// [서비스 클래스]에는 @Service @Transactional를 붙인다.
	// MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
	// @Service 		=> [서비스 클래스] 임을 지정하고 bean 태그로 자동 등록된다
	// @Transactional	=> [서비스 클래스]의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDAO staffDAO;


	public int inputStaff(StaffDTO staffDTO) {
		
		int jumin_noCnt = this.staffDAO.getJumin_no(staffDTO);
		if(jumin_noCnt==1) {
			return -1;
		}

		int inputStaffCnt = this.staffDAO.getInputStaffCnt(staffDTO);

		
		if(staffDTO.getSkill_code()!=null) {
			int inputStaffSkillCnt = this.staffDAO.getInputStaffSkillCnt(staffDTO);

		}

		System.out.println(inputStaffCnt);
		return inputStaffCnt;
	}


	public int deleteStaff(StaffDTO staffDTO) {
		
		int staffCnt = this.staffDAO.getStaffCnt(staffDTO);
		if(staffCnt==0) {
			return -1;
		}
		
		int staffSkillCnt = this.staffDAO.getStaffSkillCnt(staffDTO);
		
		if(staffSkillCnt>0) {
			
			int deleteStaffSkillCnt = this.staffDAO.getDeleteStaffSkillCnt(staffDTO);
			
		}
		
		int deleteStaffCnt = this.staffDAO.getDeleteStaffCnt(staffDTO);
		if(deleteStaffCnt==0) {
			return -1;
		}

		return deleteStaffCnt;
	}



	public int updateStaff(StaffDTO staffDTO) {
		
		
		
		
		int staffCnt = this.staffDAO.getStaffCnt(staffDTO);
		if(staffCnt==0) {
			return -1;
		}
		
		
		
		int jumin_noCnt = this.staffDAO.getJumin_no(staffDTO);
		if(jumin_noCnt==1) {
			return -2;
		}
		
		
		int staffSkillCnt = this.staffDAO.getStaffSkillCnt(staffDTO);
		if(staffSkillCnt>0) {
			
			int deleteStaffSkillCnt = this.staffDAO.getDeleteStaffSkillCnt(staffDTO);
		}
		
		int updateStaffCnt = this.staffDAO.getUpdateStaffCnt(staffDTO);
		if(updateStaffCnt==0) {
			return - 1;
		}
		

		if(staffDTO.getSkill_code()!=null) {
			int updateStaffSkillCnt = this.staffDAO.getUpdateStaffSkillCnt(staffDTO);
			if(updateStaffSkillCnt==0) {
				return - 1;
			}
		}		
		
		return updateStaffCnt;
	}

}
