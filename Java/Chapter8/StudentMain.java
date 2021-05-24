package kr.java.chapter8;

public class StudentMain {

	public static void main(String[] args) {
		// 다수의 학생정보를 관리. - 5명
		Student[] students = new Student[5];
		students[0]= new Student();
		students[1]= new Student();
		students[2]= new Student();
		students[3]= new Student();
		students[4]= new Student();
		
		students[0].studentName = "홍길동";
		students[0].grade = 3;
		
		students[1].studentName = "이순신";
		students[1].grade = 2;
		
		for(int i = 0; i < 5; i++) {
			System.out.println(students[i]);
			System.out.println(students[i].studentName);
		}

	}

}
