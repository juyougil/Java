package kr.java.chapter7;

public class ArrayTest {

	public static void main(String[] args) {
		String[] stud = new String[10];
		stud[0] = "홍길동,90,92";
		stud[1] = "홍삼동,88,90";
		stud[2] = "홍사동,86,78";
		stud[3] = "홍오동,58,76";
		stud[4] = "홍칠동,68,92";
		stud[5] = "홍팔동,90,90";
		stud[6] = "홍구동,70,80";
		stud[7] = "홍십동,60,70";
		stud[8] = "홍이동,90,40";
		stud[9] = "홍일동,80,92";
		int sum = 0;
		int avg = 0;
		 // int find_id = -1;
		
		for (int i = 0; i < stud.length; i++) {
			String math = stud[i];
			String[] data = math.split(",");
			/*
			if( data[0].contains("홍")) {
				// 학생찾기
			int	find_id = i;
				break;
			}
			
			System.out.println(stud[find_id]);*/
			sum += Integer.parseInt(data[1]);
			avg = (sum / stud.length);
		}
			System.out.println("수학 합계: " +sum);
			System.out.println("수학 평균: " + avg); // 
	}

}
