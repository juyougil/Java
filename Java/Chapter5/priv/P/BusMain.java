package kr.java.chapter5.priv.P;

public class BusMain {

	public static void main(String[] args) {
		// Bus 필드 name, number 써보기
		// 1. 직접 사용
		//Bus b = new Bus("",0);
		//b.name = "";
		//b.number = 0; // default, protected, public 으로 변경하면 사용가능 
		
		// 2. 메서드를 사용
		Bus bus = new Bus("개인 버스", 8282);
		
		
		
		
	}

}
