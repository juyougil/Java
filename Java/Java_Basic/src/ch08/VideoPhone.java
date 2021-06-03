package ch08;

public class VideoPhone extends Phone {
	//상속 클래스가 매개변수 생성자가 있으면 super(매개변수) 호출
	
	public VideoPhone() {
		
	}
	
	public VideoPhone(String m, String c, String n) {
		super(m, c, n);
		// TODO Auto-generated constructor stub
	}
	public void videoCall() {
		System.out.println("영상통화");
	}
	public void info() {
		String a = super.model;
	}

}