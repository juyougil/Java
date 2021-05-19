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
출력물
A
65
B
67
C
318
ľ

## '한'을 유니코드로 표현해보기

package kr.java.chapter2;

public class CharacterEx2 {

	public static void main(String[] args) {
		char ch1 = '한';
		char ch2 = '\uD55C'; // 유니코드의 Escape sequence 형식
		
		System.out.println(ch1);
		System.out.println(ch2);
				

	}

}
출력물
한
한

## 문자형 변수에 숫자를 저장했을 경우 

package kr.java.chapter2;

public class CharacterEx3 {

	public static void main(String[] args) {
		int a = 65;
		int b = -66;
		
		
		char a2 =65;
		//char b2 = -66; // 문자형 변수에 음수를 넣으면 오류 발생
		
		System.out.println((char)a); 
		System.out.println((char)b); 
		System.out.println(a2);	     
	}

}



출력물
A
ﾾ
A

