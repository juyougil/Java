package com.employee.prj;

import java.util.List;

public class EmployeeSearchDTO {
	
	// 검색 키워드 지정하는 속성변수 선언
	// 현재 선택된 페이지 번호를 저장하는 속성변수 선언.
	// 한 화면에 보여줄 [행의 개수]를 저장하는 속성변수 선언.
	
	private String keyword1;
	private int selectPageNo =1;
	private int rowCntPerPage=5;
	private String min_year;
	private String min_month;
	private String max_year;
	private String max_month;

	private List<String> checkjikup;

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
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

	public List<String> getCheckjikup() {
		return checkjikup;
	}

	public void setCheckjikup(List<String> checkjikup) {
		this.checkjikup = checkjikup;
	}

	

	

	

}
