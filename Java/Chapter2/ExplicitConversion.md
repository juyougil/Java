## 명시적 형 변환

package kr.java.chapter2;

public class ExplicitConversion {

	public static void main(String[] args) {
		double dNum1 = 1.2;
		float fNum2 = 0.9F;
		
		int iNum3 = (int)dNum1 + (int)fNum2;
		int iNum4 = (int)(dNum1 + fNum2);
		System.out.println(iNum3);
		System.out.println(iNum4);

	}

}

출력값

1  
2  



	// 2. 명시적 타입 타입캐스팅
		// 파충류 파 = (파충류)고릴라;
		byte b1 = (byte)25;
		System.out.println("b = " + b);
		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("l = " + l);
		
		
		System.out.println("f = " + f);
		System.out.println("d = " + d);
		System.out.println("b1 = " + b1);
		

	}

}

출력값
b = 25  
s = 25  
i = 25  
l = 25  
f = 25.0   
d = 25.0  
b1 = 25  
