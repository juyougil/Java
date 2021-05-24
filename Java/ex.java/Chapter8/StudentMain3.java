package ex.java.chapter8;

public class StudentMain3 {

	public static void main(String[] args) {
		// Score2 Student2 이용.
		// 홍길동/구로구/3, 수학 100, 국어 90
		// 고길동/ 영등포구/3 수학 70, 국어 80
		
		Student2[] students = new Student2[2];
		students[0] = new Student2();
		students[1] = new Student2();
		
		students[0].studentName = "홍길동";
		students[0].grade = 3;
		students[0].subj1 = new Score2[2];
		
		students[0].subj1[0] = new Score2();
		students[0].subj1[0].subject = "수학";
		students[0].subj1[0].score = 100;
		students[0].subj1[1] = new Score2();
		students[0].subj1[1] .subject = "국어";
		students[0].subj1[1].score = 90;
		
		
		students[1].studentName = "고길동";
		students[1].grade = 3;
		students[1].subj1 = new Score2[2];
		students[1].subj1[0] = new Score2();
		students[1].subj1[0].subject = "수학";
		students[1].subj1[0].score = 70;
		students[1].subj1[1] = new Score2();
		students[1].subj1[1].subject = "국어";
		students[1].subj1[1].score = 80;
		
		students[0].subj2.subject =students[0].subj1[0].subject;
		students[1].subj2.subject =students[1].subj1[0].subject;

		for(int i = 0; i < students.length; i++) {
			Student2 student = students[i];
			System.out.println(student.studentName);
		}
		
		
		for(Student2 student : students) {
			System.out.println(student.studentName);
		}
	
		
		
		
		
		
		
		
		
	}

}
