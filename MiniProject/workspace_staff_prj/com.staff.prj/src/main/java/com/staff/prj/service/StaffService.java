package com.staff.prj.service;

import org.springframework.web.multipart.MultipartFile;

import com.staff.prj.dto.StaffDTO;

public interface StaffService {
	
	public int inputStaff(StaffDTO staffDTO);
	
	public int deleteStaff(StaffDTO staffDTO);
	
	public int updateStaff(StaffDTO staffDTO);

}
