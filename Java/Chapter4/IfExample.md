## if와 if-else
package kr.java.chapter4;

import java.util.Scanner;

public class IfExample {

	public static void main(String[] args) {
		int age = 9;
		int charge;
		if(age < 8) {
			charge = 1000;
			System.out.println("취학 전 아동입니다.");
		}
		else if(age < 14) {
			charge = 2000;
			System.out.println("초등핵생입니다.");
		}
		else if(age < 20) {
			charge = 2500;
			System.out.println("중, 고등학생입니다.");
		}
		else {
			charge = 3000;
			System.out.println("일반인입니다.");
		}
		System.out.println("입장료는" + charge + "원입니다.");
		
		
		//실습 if-else if-else
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 입력");
		String str = scanner.nextLine();
		
		int num = Integer.parseInt(str);
		if (num > 0) {
			System.out.println("양수");
		}
		else if (num < 0) {
			System.out.println("음수");
		}
		else {
			System.out.println("0입니다.");
		}

	}

}

package kr.java.chapter4;

import java.util.Scanner;

public class IfStatementExam {

	public static void main(String[] args) {
	
		int age = 10;	
			//조건	
		if(age >= 8) { //조건이 true 인경우.
			System.out.println("8살 이상이네요.");
		}
		else {//조건이 false 인경우.
			System.out.println("8살 이하!!!.");
			
			
		//복합 조건
		int age2 = 10;
			// 8살 이상이고 age2 10 보다 큰거.
		if((age >= 8) && (age2 > 10)) { //조건이 true 인경우.
			System.out.println("8살 이상이네요.");
			}
		else {//조건이 false 인경우.
			System.out.println("8살 이하!!!.");	
				
		// 실습
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. " );
		int num = scanner.nextInt();
		
		if (num > 0) {
			System.out.println(num);
		}
		else {
			System.out.println("양수를 입력하세요!");
		}
		
		
		
	}
	}
	}
}

## 실습
package kr.java.chapter4;

import java.util.Scanner;

public class InputIfExam {

	public static void main(String[] args) {
		// 실습
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수 입력");
		String str = scanner.nextLine();
		
		int num = Integer.parseInt(str);
		
		if ((num == 0) || (num < 0) ) {
			System.out.println("양수를 입력하세요!");
		}
		else {
			System.out.println(num);
		}

	}

}

