## 대입 연산자

// = 는 대입연산자 오른쪽변수를 왼쪽에 대입!!

package kr.java.chapter3;

public class AssignTest {

	public static void main(String[] args) {
		int t =1000;
		int i;
		
		String str = "Test";
		String str2 = new String("Test2");
		String str3;
		
		System.out.println(t);
		System.out.println(str);
		System.out.println(str2);
		
		i = t;
		str3 = str;
		
		System.out.println(i);
		System.out.println(str3);
    
## 부호 연산자
	int num = 10;
		
		System.out.println(+num);
		System.out.println(-num);
		System.out.println(num);
		
		num = -num;
		System.out.println(num);
		
		
		byte b = 1;
		System.out.println(b);
		System.out.println(-b);
    
## 산술 연산자 (+와 /사용)

	int mathScore = 90;
		int engScore = 70;
		
		int totalScore = mathScore + engScore;
		
		System.out.println(totalScore);
		
		double avgScore = totalScore / 2.0;
		System.out.println(avgScore);
		
		
	

	}

}


    
		
