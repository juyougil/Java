package ch05;

public class Student {
	// 변수(필드)
	int age;
	String name;
	// 메서드
	
	
	// 생성자: 툭수한 매서드
	// -return이 없다
	
	// 클래스 이름()
	
	// 기본 생성자 default constructor
	// 만약 기본생성자 구현안하고 -> 다른 생성자 구현하면
	// new 기본생성자 호출 불가능
	public Student() {
		
	}
	
	// 메서드 오버로딩
	public Student(String n, int a) {
		this.age = a;
		this.name = n;
		
	}
	public Student(String n,int a, String t) {
		this.age = a;
		this.name = n;
		
	}
}
