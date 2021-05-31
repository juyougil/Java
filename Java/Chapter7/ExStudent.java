package kr.java.chapter7;

import java.util.Scanner;

public class ExStudent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int index = 0;
		Student students[] = new Student[5];
		
		while(true) {
			System.out.println("학생 성적을 입력하세요. (이름/학년/주소/수학/과학/영어");
			String result = sc.nextLine();
			
			//index가 배열 크기를 넘으면 0변  인덱스부터 다시
			if(students.length == (index+1)) {
				index = 0;
			}
			// 종료
			if(result.contains("q")) {
				System.out.println("close...");
				print(students);
				break;
			}
			students[index] = new Student(result);
			index++;
		}
			}
		//모두 출력
		static void print(Student[] array) {
			for(int i = 0; i < array.length; i++) {
			System.out.println(array[i].name);
		}
	}

}
