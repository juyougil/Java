package kr.java.chapter5.countructor;

public class Person {
	String name;
	float height;
	float weight;
	
	
	// 특별한 메소드
	// class 이름과 같다.
	// return  타입 X
	
	public  Person() {
		height = 0;
		weight =1;
		
		System.out.println("Person 생성자 " + "w: " + weight + "     h: " + height);
	}
	
	// 2 매개변수 생성자
	public Person(String n)  {
		name = n;
		System.out.println(name+" : "+"w: " + weight + "     h: " + height);
	}
	
	
	
	public Person(String n, float w, float h)  {
		name = n;
		weight = w;
		height = h;
		System.out.println(name+" : "+"w: " + weight + "     h: " + height);
	}
	
}
