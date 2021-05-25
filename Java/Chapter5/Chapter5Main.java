package kr.java.chapter5;
import kr.java.chapter8.Person;

public class Chapter5Main {

	public static void main(String[] args) {
		Student st = new Student(); //kr.java.chapter5
		// kr.java.chapter5.Student st2; 위에랑 같은거
		
		Person p = new Person();
		
		//.operator
		st.studentID = 1000;
		st.studentName = "홍길동";
		
		// 사용
		System.out.println(st.studentName);
		

		// 2. 반환형식 있다
		String info = st.showStudentInfo();
		System.out.println(info);

		// 3. 반환형식 없다.
		st.println();
		
		// 4. 매개변수
		info = st.setScore(1000);
		System.out.println(info);
		
		st.setScore2(1000);
		System.out.println(st.showStudentInfo());
		
		// 다른패캐지
		kr.java.chapter8.Student st3 = new kr.java.chapter8.Student(); // 풀패캐지 네임

	}

}
