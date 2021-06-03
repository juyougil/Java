package ch05;
// 6/2 클래스 리뷰
public class ClassNewRefernce {
	//copyByValue
	public void copyByValue(int i, boolean b) {
		i = 100;
		b = false;
		System.out.println("method -> num " + i + " , b: " + b);
	}
	//copyByReference
	public void copyByReference(Student st) {
		st.name = "고길동";
		System.out.println("method -> name " + st.name);
		
	}

	public static void main(String[] args) {
		//자료형: 기본자료형, 객체 (클래스, 배열, Enun)
		// 객체 자료형
		
		int[] a = new int[10];
		Student st = new Student();
		st.name = "홍길동";
		String str = new String("안녕");
		
		// 기본자료형: int, float, bloolean..
		int num = 10; // 리터럴 // new int()
		boolean b = true;
		
		
		ClassNewRefernce test = new ClassNewRefernce();
		test.copyByValue(num, b);
		test.copyByReference(st);
		System.out.println("main -> num " + num + " , b: " + b);
		System.out.println("main -> name " + st.name);
		
		
		
		
		
		Student st2 = new Student();
		System.out.println("st2 : " + st2);
		st2 = st;
		System.out.println("st : " + st);
		System.out.println("st2 : " + st2);
		
	}
	
	// 객체 Object : 코드 상의 객체, 설계/분석 성의 객체.
	// 클래스: 현실 세계 객체의 특성/기능 코드 묘사한 것.
	// 인스턴스: new 연산한 클래스 변수(코드 상의 객체)를 메모리 상의 대상으로 표현.
	// 멤버: 클래스의 구성 요소(속성/필드, 메서드(기능))
	// 메서드
	// 잠조변수: 객체가 인스턴스를 가르키는 식별자(변수)
	// 참조값: 객체 값 hashcode
	
	
		
	
	

}
