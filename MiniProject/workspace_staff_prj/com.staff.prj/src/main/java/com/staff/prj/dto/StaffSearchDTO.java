package com.staff.prj.dto;

import java.util.List;

public class StaffSearchDTO {
	private String name_keyword;
	private int selectPageNo =1;
	private int rowCntPerPage=5;
	private String min_year;
	private String min_month;
	private String max_year;
	private String max_month;

	private Integer religion_code;
	private List<Integer> school_code;
	private List<Integer> skill_code;
	private List<String> gender;
	
	private Integer staff_name_sort;
	private Integer gender_sort;
	private Integer religion_sort;
	private Integer staff_skill_sort;
	private Integer graduate_day_sort;
	public String getName_keyword() {
		return name_keyword;
	}
	public void setName_keyword(String name_keyword) {
		this.name_keyword = name_keyword;
	}
	public int getSelectPageNo() {
		return selectPageNo;
	}
	public void setSelectPageNo(int selectPageNo) {
		this.selectPageNo = selectPageNo;
	}
	public int getRowCntPerPage() {
		return rowCntPerPage;
	}
	public void setRowCntPerPage(int rowCntPerPage) {
		this.rowCntPerPage = rowCntPerPage;
	}
	public String getMin_year() {
		return min_year;
	}
	public void setMin_year(String min_year) {
		this.min_year = min_year;
	}
	public String getMin_month() {
		return min_month;
	}
	public void setMin_month(String min_month) {
		this.min_month = min_month;
	}
	public String getMax_year() {
		return max_year;
	}
	public void setMax_year(String max_year) {
		this.max_year = max_year;
	}
	public String getMax_month() {
		return max_month;
	}
	public void setMax_month(String max_month) {
		this.max_month = max_month;
	}
	public Integer getReligion_code() {
		return religion_code;
	}
	public void setReligion_code(Integer religion_code) {
		this.religion_code = religion_code;
	}
	public List<Integer> getSchool_code() {
		return school_code;
	}
	public void setSchool_code(List<Integer> school_code) {
		this.school_code = school_code;
	}
	public List<Integer> getSkill_code() {
		return skill_code;
	}
	public void setSkill_code(List<Integer> skill_code) {
		this.skill_code = skill_code;
	}
	public List<String> getGender() {
		return gender;
	}
	public void setGender(List<String> gender) {
		this.gender = gender;
	}
	public Integer getStaff_name_sort() {
		return staff_name_sort;
	}
	public void setStaff_name_sort(Integer staff_name_sort) {
		this.staff_name_sort = staff_name_sort;
	}
	public Integer getGender_sort() {
		return gender_sort;
	}
	public void setGender_sort(Integer gender_sort) {
		this.gender_sort = gender_sort;
	}
	public Integer getReligion_sort() {
		return religion_sort;
	}
	public void setReligion_sort(Integer religion_sort) {
		this.religion_sort = religion_sort;
	}
	public Integer getStaff_skill_sort() {
		return staff_skill_sort;
	}
	public void setStaff_skill_sort(Integer staff_skill_sort) {
		this.staff_skill_sort = staff_skill_sort;
	}
	public Integer getGraduate_day_sort() {
		return graduate_day_sort;
	}
	public void setGraduate_day_sort(Integer graduate_day_sort) {
		this.graduate_day_sort = graduate_day_sort;
	}
	
	
	
	

	
	

}
