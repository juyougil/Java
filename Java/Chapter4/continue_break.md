## coutinue 사용
coutinue는 반복문 안에서 coutinue 아후에 문장은 수행하지 않고 처음으로 돌아가 수행

package kr.java.chapter4;

public class ContinueExample {

	public static void main(String[] args) {
		int total = 0;
		int num;
		
		 for(num =1; num <=100; num++) {
			 if(num % 2 == 0)
				 continue;
			 total += num;
		 }
		 System.out.println("1부터 100까지의 홀수의 합은: " + total + " 입니다.");
		 
	}

## break

package kr.java.chapter4;

import java.util.Scanner;

public class Test_While {

	public static void main(String[] args) {
			Scanner sc =new Scanner(System.in);
			
			int dan;
			//int i = 1;

			while(true) {
				System.out.println("단을 입력해주세요");
			dan = sc.nextInt();
			if( dan == -1) {
				System.out.println("~ 끝");
				break; // dan이 -1이면 더 이상 실행하지 않고 빠져나옴
	}
			for(int i = 0; i < 10; i++) {
				System.out.println( dan + "*"+i + "="+i*dan );
			}
			dan = 0;
}
}
}
