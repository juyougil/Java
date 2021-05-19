## Scanner 사용법

package kr.java.chapter3;
import  java.util.Scanner;
public class Test_scanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
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
