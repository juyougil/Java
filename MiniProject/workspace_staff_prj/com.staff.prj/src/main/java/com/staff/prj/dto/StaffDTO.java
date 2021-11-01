package com.staff.prj.dto;

import java.util.List;

public class StaffDTO {
	private Integer staff_no;

	private String skill_name;
	private String religion_name;
	
	private String staff_name;
	private String gender;
	private String front_jumin_no;
	private String back_jumin_no;
	private Integer religion_code;
	private List<Integer> skill_code;
	private Integer school_code;
	private String graduate_day;
	public Integer getStaff_no() {
		return staff_no;
	}
	public void setStaff_no(Integer staff_no) {
		this.staff_no = staff_no;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public String getReligion_name() {
		return religion_name;
	}
	public void setReligion_name(String religion_name) {
		this.religion_name = religion_name;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFront_jumin_no() {
		return front_jumin_no;
	}
	public void setFront_jumin_no(String front_jumin_no) {
		this.front_jumin_no = front_jumin_no;
	}
	public String getBack_jumin_no() {
		return back_jumin_no;
	}
	public void setBack_jumin_no(String back_jumin_no) {
		this.back_jumin_no = back_jumin_no;
	}
	public Integer getReligion_code() {
		return religion_code;
	}
	public void setReligion_code(Integer religion_code) {
		this.religion_code = religion_code;
	}
	public List<Integer> getSkill_code() {
		return skill_code;
	}
	public void setSkill_code(List<Integer> skill_code) {
		this.skill_code = skill_code;
	}
	public Integer getSchool_code() {
		return school_code;
	}
	public void setSchool_code(Integer school_code) {
		this.school_code = school_code;
	}
	public String getGraduate_day() {
		return graduate_day;
	}
	public void setGraduate_day(String graduate_day) {
		this.graduate_day = graduate_day;
	}
	
	
	

	
	

}
