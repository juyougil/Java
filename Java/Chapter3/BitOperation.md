## 비트 논리 연산자

package kr.java.chapter3;

public class BitOperation {

	public static void main(String[] args) {
		int num1 = 5; // 0101
		int num2 = 10; // 1010
		int result = num1 & num2;
		
		
		result=num1 | num2;
		System.out.println("num1 & num2" + result); //0000
		
		result=num1 | num2;
		System.out.println("num1 | num2" +result);
		
		result =num1 ^ num2;
		System.out.println("num1 ^ num2" + result);
		
		result = ~num1;
		System.out.println("~num1 "  + result);
		
		//논리연산자와 비트 논리 연산자 차이
		boolean t = (num1 >= num2) && (num1 <= num2);
		System.out.println(t);
		//t = (num1 & num2) && (num1 ^ num2);
		
		t = (5 > 10) & (10 < 20); // false & true : 비트 연산
		System.out.println(t);
		
		t = (5 < 10) & (10 < 20); // true & false : 비트 연산
		System.out.println(t);
    
    
## 비트 이동 연산자 (이건 강사님아 나중에 보충설명 하신다고함)

	/** shift operator
		 * bit wise operation
		 *  - left, right, 채움 
		 */
		
		int n1 = 5; //0101
		int n2 = -5;
		
		System.out.println("5 << 2" + (n1 << 2)); 
		System.out.println("5 << 3" + (n1 << 3)); 
		
		System.out.println("5 >> 1" + (n1 >> 1)); 
		System.out.println("5 >> 2" + (n1 >> 2)); 
		System.out.println("5 >> 3" + (n1 >> 3)); 
		
		System.out.println("-5 << 2" + (n2 << 2)); //
		System.out.println("-5 << 3" + (n2 << 3)); 
		
		System.out.println("-5 >> 1" + (n2 >> 1));
		System.out.println("-5 >> 2" + (n2 >> 2));
		System.out.println("-5 >> 3" + (n2 >> 3)); //
		
		System.out.println("5 >>> 1" + (n1 >>> 1));
		System.out.println("5 >>> 2" + (n1 >>> 2));
		System.out.println("5 >>> 3" + (n1 >>> 3));
		
		
		System.out.println("-5 >>> 1" + (n2 >>> 1));
		System.out.println("-5 >>> 2" + (n2 >>> 2));
		System.out.println("-5 >>> 3" + (n2 >>> 3));
		
		System.out.println("5 >>> 1 -" + Integer.toBinaryString(n1 >>> 1));
		System.out.println("-5 >>> 1 -" + Integer.toBinaryString(n2 >>> 1));
		
		
		
	}

}

		

		
