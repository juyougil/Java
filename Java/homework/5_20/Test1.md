package homework_5_20;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자연수를 입력해주세요");
		int num = sc.nextInt();
		int count = 0;
		int num1 = 0;
		for(int i =1; i <= num; i++) {
			if(i%2 == 1) {
				num1 += i; 
				count++;
			}
		}
		System.out.println("카운트: " + count);
		System.out.println("합계: " + num1);

	}

}
