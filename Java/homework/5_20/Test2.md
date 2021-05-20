## 모르겠어요..... 네이버 서치해서 최대한 이해해보려고 똑같이 따라해봤어요.

package homework_5_20;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("왼쪽 모래시계 높이 입력 : ");
		int n = sc.nextInt();
		
		for (int i =0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print( " ");
			}
			for(int j = 0; j<(2*n)-(2*(i+1)-1); j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		for (int i = 0; i < n; i++) {
			for(int j =0; j < (n-1)-i; j++) {
			System.out.print(" ");
			}
		for (int j =0; j <= 2 * i; j++) {
			System.out.print("*");
		}
		System.out.println(" ");
	}
}
}
