## 산술 연산자 (+와 /사용)
package kr.java.chapter3;

public class averge {

	public static void main(String[] args) {
	int mathScore = 90;
		int engScore = 70;
		
		int totalScore = mathScore + engScore;
		
		System.out.println(totalScore);
		
		double avgScore = totalScore / 2.0;
		System.out.println(avgScore);


## 증가 감소 연산자

int gameScore = 150;
		
		int lastScore1 = ++gameScore;
		System.out.println(lastScore1);
		
		int lastScore2 = --gameScore;
		System.out.println(lastScore2);

		lastScore1 = gameScore++;
		System.out.println(lastScore1);
		
		lastScore2 = gameScore--;
		System.out.println(lastScore2);





## 관계 연산자

		int a = 10;
		int b = 20;
		
		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(a >=b);
		System.out.println(a <= b);
		
		System.out.println(a == b);
		System.out.println(-1 == a);
		
		boolean f1 = (a > b);
		System.out.println(f1);


## 논리 연산자

		System.out.println( (5 > 3) && (5 > 2) );
		System.out.println( (5 > 3) || (5 > 2) );
    
		int num1 = 10;
		int i = 2;
		boolean value = ((num1 = num1 + 10) < 10) && ((i=i+2) < 10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
		
		
		value = ((num1 = num1 + 10) > 10) || ((i=i+2)<10);
		System.out.println(value);
		System.out.println(num1);
		System.out.println(i);
    
    
## 복합대입 연산자

		int num2 = 100;
		System.out.println(num2 += 2);
		System.out.println(num2 -= 2);
		System.out.println(num2 *= 2);
		System.out.println(num2 /= 2);
		System.out.println(num2 %= 2);
		System.out.println(num2 <<= 2);
		System.out.println(num2 >>= 2);
		System.out.println(num2 >>>= 2);
		System.out.println(num2 &= 2);
		System.out.println(num2 |= 2);
		System.out.println(num2 ^= 2);


## 조건 연산자

		int fatherAge = 45;
		int motherAge = 47;
		
		char ch;
		ch = (fatherAge > motherAge) ? 'T' : 'F';
		
		System.out.println(ch); 
		
		
		
		
		

	}

}
