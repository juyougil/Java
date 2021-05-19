## 문자를 문자나 정수로 표현 해보기

package kr.java.chapter2;

public class CharacterEx1 {

	public static void main(String[] args) {
		// 문자형임 문자열아님
		char ch1 = 'A'; // 2B == int
		System.out.println(ch1); 
		System.out.println((int)ch1); // Casting
		
		char ch2 = 66; // 아스키 코드 B
		System.out.println(ch2);
		
		int ch3 = 67;
		System.out.println(ch3);
		System.out.println((char)ch3);
		
		//범위
		int ch4= 318;
		System.out.println(ch4);
		System.out.println((char)ch4);
	
	
	}

}
