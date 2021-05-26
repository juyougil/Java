package kr.java.chapter5.priv;

public class Student { // class 지시자 : 클래스의 코드를 정의 하는 곳!
	
	// 멤버 필드(변수, 식별자) : 속성
	private String studentName;
	private int grade;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int score;
	
	protected String address;
	
	int studentID;
	

	
	
	// 멤버 메서드 (함수)
	
	// 1. 클래스 안에서만 존재
	
	// 2. 반환형식이 있다.
	public String showStudentInfo() {
		// 이름 아이디 주소
		String info =studentName + "/" + studentID + "/" + address;
		return info;
	}
	// 3. 반환이 없을수 있다: void
	// 클래스 내부에서 연산/계산/처리
	// 클래스 내부에 저장... 출력
	
	public void println() {
		String info =studentName + "/" + studentID + "/" + address;
		System.out.println(info);
	}
	
	// 4. 매개변수를 사용.
	// 점수 전달하고 처리 info 반환
	public String setScore(int s) {
		score = s;
		String info = showStudentInfo();
		return info + " / score = " + score;
	}
	
	public void setScore2 (int s) {
		score = s;
	}

	
	
}	