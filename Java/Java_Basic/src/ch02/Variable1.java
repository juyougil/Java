package ch02;

public class Variable1 {

	// 1.멤버 필드(속성, 변수)
	// 자료형 이름;
	// 자료형 이름 = 리터럴;
	// 자료형: 기본자료형, 클래스, 배열, Enum
	char ch; // 문자자료형 ch 선언
	char ch1 = 'A'; // 선언과 동시에 초기화  아스키코드로 저장 65
	
	float f_name;
	float f_name1 = 1.0F; //float은 F를 넣어야함 4바이트
	
	double d_name = 1.0;// 8바이트
	
	double d_name3 = Double.MAX_VALUE;
	// double d_name4 = Double.MAX.VALUE + 1.0;
	
	//바이트 -128~127
	byte b1 = -128;
	byte b2 = 127;
	
	int i = 10;
	long l = Long.MAX_VALUE;
	long l2 = 10L;
	
	//true, false 논리연산자
	boolean isboolean;
	boolean isnumber;
	boolean ischar;
	
	
	// 2. 멤버 메소드
	//Modifier [static] 리턴형식 이름(매개변수) {}
	//Modifier: public, prirected, package, private
	//리턴형식: void, 자료형
	public void printinfo(int i) {
		//코드블럭
	}
	public void printinfo(int i, long l, byte b) {
		//코드블럭
	}
	public int getNumber() {
		return 0;    //return 리턴자료형
	}
	
	
	static int k = 100;
	static long LL;
	// Starting porint. 시작점
	public static void main(String[] args) {
		int j = 100;
		char c = 'a';
		System.out.println(k);
		
		
		
		char ch2;
		char ch3 = 'A';
		
		//System.out.println(ch2); 
		System.out.println(ch3);
		
		System.out.println(LL);

	}

}
