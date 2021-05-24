package ex.java.chapter4;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		 int i =2;// i : 나눌 대상
		 boolean isPrime = true;
		 while (i <= num) {
			 isPrime = true;
			 
			 for(int n =2; n < i; n++) {
				 
				 if(i % n == 0) {
					 isPrime = false;
				 }
				 continue;
			 
			}
			if (isPrime == true) {
				System.out.print(i+" ");
			}
			i++;
		}
		System.out.println(" ");

	}
}
