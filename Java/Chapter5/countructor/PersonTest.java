package kr.java.chapter5.countructor;

public class PersonTest {

	public static void main(String[] args) {
		//1. 기본 생성자
		Person p = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		
		//2. 생성자 매개변수
		//p : 홍길동, p2: 자바, p3: 도넛
		Person p4 = new Person("홍길동");
		Person p5 = new Person("자바");
		Person p6 = new Person("도넛");
		
		Person p7 = new Person("홍길동", 100, 80);
		Person p8 = new Person("자바", 80, 90);
		Person p9 = new Person("도넛", 10, 10);
		
	}

}
