package ch05;

public class Student2 {
	// package modifier
	int age;
	
	String name;
	
	protected String address;

	public Student2() {
		
	}
	
	// 메서드 오버로딩
	public Student2(String n, int a) {
		this.age = a;
		this.name = n;
	}
}
