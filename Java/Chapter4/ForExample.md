## for문 사용

package kr.java.chapter4;

public class ForExample1 {

	public static void main(String[] args) {
		int i;
		int sum;
		for(i = 1, sum = 0; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지의 합은 " + sum + "입니다.");
	}

}

## for문을 사용한 구구단

package kr.java.chapter4;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int dan;
		
		System.out.println("단을 입력해 주세요");
		dan = sc.nextInt();
		for(int i = 1; i < 10; i++) {
			System.out.println(dan + "*" + i +"="+i*dan);
		}
				

	}

}
