package ch03;

public class OperatorEx1 {
	//자바의 항
	//단항: ++,--자료형--,++
	//이항: 인수 [+,*-] 인수
	//삼항: 조건 ? 참값 : 거짓값
	
	public static void main(String[] args) {
		//대입연산자: 왼쪽 변수에 값(일반 값, 객체 값)을 대입
		int i =0;
		int j;
		j = 10;
		
		j = i * 1000;
		
		//부호: +,-
		j = 10; // + 기호는 묵음.
		j = +10;
		j = -10;
		
		
		//삼항연산자: 조건 ? 참값 : 거짓값
		//조건식: 대소 <,>, 동등 <=.=>..
		int score = 90;
		int grade = (score > 80) ? 1 : 2;
		grade = (score > 80) ? 1 : (score > 70) ? 4 : 3;
		System.out.println("Score: " + score + " -> grade: "+ grade);
		
		
		System.out.println("======= 산술연산자 ========");
		System.out.println("+" + (3+3));
		System.out.println("+" + 3 + 3);
		System.out.println("*" + (3*3));
		System.out.println("3/3=" + (3/3));
		//System.out.println("3/0" + (3/0));
		System.out.println("0/3=" + (0/3));
		System.out.println("%" + (92%3));
		
		//증감연산자
		score = 150;
		System.out.println("++score: " + (++score));
		score = 150;
		System.out.println("score++: " + (score++));
		
		
		score = 150;
		int r = ++score;
		System.out.println("score: " + (score) + " ->r: " + r);
		
		
		score = 150;
		r = score++;
		System.out.println("score: " + (score) + " ->r: " + r);
		
		
		//관계인산자:  값!!!
		// >,<,>=,<=,==,!=
		
		//기본자료형: 값.
		// 객체: 객체의 값 -> 객체의 해시코드 (가상의 메모리주소)
		
		// 비교 -> 결과가 참/거짓! boolean
		
		
		//조건식 작성
		System.out.println(" 1 > 0 " + (1 > 0));
		System.out.println(" 1 < 0 " + (1 < 0));
		
		// 대등연산자 == 
		System.out.println(" 1 == 0: " + (1 == 0));
		
		//객체의 대등연산자 처리.
		System.out.println("홍: "+ System.identityHashCode("홍"));
		System.out.println("훙 == 홍: " + ("홍" == "홍"));
		
		// 논리연산자
		// &&, ||, !
		
		System.out.println((5 > 3) && (5 > 2));
		System.out.println((5 < 3) && (5 < 2));
		
		System.out.println((5 < 3) || (5 > 2));
		
		System.out.println(!(5<3));
		System.out.println(!true);
		
		
		
		
		
		
	}

}
