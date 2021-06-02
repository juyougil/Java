package ch05;

public class ClassTest1 {

	class test{
		
	}
	
	class ArrayTest{
			
	}
	
	public void test() {
		System.out.println("test()");
	}
	
	
	public static void main(String[] args) {
		ClassTest1 ex = new ClassTest1();
		ex.test();

	}
	//메소드
	// Mpdofier 리턴타입 [static] method_name([매개변수]) {코드블럭}
	// 리턴타입:  자료형 -> 코드블럭 return 자료형
	// 매개변수: 자료형 이름 전달
	//가상메서드 의미 P254
	
	//메소드 매개변수 전달방식
	//1. Copy by value
	//2. Copy by reference
	
	public String[] stringArray(String s1, String s2, String s3) {
		String[] result;
		result = new String[3];
		
		result[0] = s1;
		result[1] = s2;
		result[2] = s3;
		
		return result;
		
		
		
	}
	
	public void copybycalue (int i) {};
}
