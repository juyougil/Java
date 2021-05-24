package ex.java.chapter7;

import java.util.Arrays;

public class Test7 {

	public static void main(String[] args) {
		int[] num = {-12,3,-9,5,6,-2,0,-8,3,10};
		
		int big = num[0];
		
		for(int i = 0; i < num.length; i++ ) {
			if ((i+1) == num.length)
				break;
			if(big <= num[i+1])
				big = num[i+1];
		}
		System.out.println("Big: " + big);
	}

}
