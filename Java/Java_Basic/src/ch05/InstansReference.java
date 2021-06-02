package ch05;

public class InstansReference {
	class Student{
		int id;
		String name;
		int grade;
	}

	public static void main(String[] args) {
		InstansReference main =  new InstansReference();
		Student st1 = main.new Student();
		Student st2 = main.new Student();
		Student st3 = main.new Student();
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		
		st3 = st1;
		System.out.println(st1);
		System.out.println(st3);
	}
	

}
