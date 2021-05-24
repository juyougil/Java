package kr.java.chapter8;

import java.util.Arrays;

public class StudenPersinMain {

	public static void main(String[] args) {
		// 클래스는 객체화 해서 사용 : instantiation
		String student2;
		student2 = new String("홍길동/구로구/2");
		
		String[] data =  student2.split("/");
		
		System.out.println(student2);
		System.out.println(data[0]);
		Student student;
		student = new Student();
		student.address = "구로구";
		student.studentName = "홍길동";
		student.grade = 2;
		
		
		System.out.println(student.studentName);
		System.out.println(student.address);
		System.out.println(student.grade);
		
		student.studentName ="이순신";
		
		
		Person person;
		person = new Person();
		
		
		
		

	}

}
