## Scanner 사용법

package kr.java.chapter3;  
import  java.util.Scanner;  //중요  
public class Test_scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 중요
		
		
		System.out.println("1. " );
		int num = scanner.nextInt();
		System.out.println("2.  ");                   
		int num1 = scanner.nextInt();
		System.out.println("3. ");
		int num2 = scanner.nextInt();
		
		int sum = (num+num1+num2);
		int avg = (sum/3);
		
		System.out.println("sum :" + sum);
		System.out.println("avg :" + avg);
		
		// 강사님 방법
		System.out.println("1 :" );
		String numbers = scanner.nextLine();
		System.out.println("2 :");                   
		String numbers1 = scanner.nextLine();
		System.out.println("3:");
		String numbers2 = scanner.nextLine();
		
		int a = Integer.parseInt(numbers);
		int b = Integer.parseInt(numbers1);
		int c = Integer.parseInt(numbers2);
		System.out.println("sum : "+(a+b+c));
		System.out.println("avg :"+ ((a+b+c)/3));
		

		
	    
	}

}

## 문자
package kr.java.chapter3;

import  java.util.Scanner;// Scanner는 java.lang(기본패캐지)에없기때문에 임포트

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름 :" );
		String name = scanner.nextLine();
		System.out.println("직업 :");                   
		String jop = scanner.nextLine();
		System.out.println("사번:");
		int num = scanner.nextInt();
		
		System.out.println(name);
		System.out.println(jop);
		System.out.println(num);
		

	}

}

