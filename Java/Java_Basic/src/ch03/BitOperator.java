package ch03;

public class BitOperator {

	public static void main(String[] args) {
		// 비트 논리 연산자.
		// 값의 각각의 비트에 대해서 &, |, ^, ~
		
		int num1 = 5;
		int num2 = 10;
		System.out.println("5: "+Integer.toBinaryString(num1));
		System.out.println("10: "+Integer.toBinaryString(num2));
		System.out.println("5 & 10: "+Integer.toBinaryString(num1 & num2));
		System.out.println("5 | 10: "+Integer.toBinaryString(num1 | num2));
		System.out.println("5 ^ 10: "+Integer.toBinaryString(num1 ^ num2));
		System.out.println();
		
		int num3 = 6;
		int num4 = 10;
		System.out.println("6 & 10: "+Integer.toBinaryString(num3 & num4));
		System.out.println("6 | 10: "+Integer.toBinaryString(num3 | num4));
		System.out.println("6 ^ 10: "+Integer.toBinaryString(num3 ^ num4));
		
		System.out.println("~10: "+Integer.toBinaryString(~num2));
		
		int num5 = 0;
		num5 &= num1;
		System.out.println("num5 &= num1: " + Integer.toBinaryString(num5 &= num1));
		
		
		//비트 이동
		// 객체 << 이동회수, 객체 >> 이동회수
		System.out.println("6 << 2: "+Integer.toBinaryString(num3 << 2));
		System.out.println("6 >> 2: "+Integer.toBinaryString(num3 >> 2));
		
		num2 = 0B000001010; //5
		System.out.println("5 << 2: "+ Integer.toBinaryString(num2 << 2));
		System.out.println("5 >> 2: "+ Integer.toBinaryString(num2 >> 2));
		System.out.println("5 >>> 2: "+ Integer.toBinaryString(num2 >>> 2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
