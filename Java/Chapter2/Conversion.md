## 묵시적 형 변환

package kr.java.chapter2;

public class ImplicitConversion {

	public static void main(String[] args) {
		Byte bNum =10;
		int iNum = bNum;
		
		System.out.println(bNum);
		System.out.println(iNum);
		
		int iNum2 = 20;
		float fNum = iNum2;
		System.out.println(iNum);
		System.out.println(fNum);
		
		double dNum;
		dNum = fNum + iNum;
		System.out.println(dNum);
		
		double dNum1 = 1.2;
		float fNum2 = 0.9F;
		
		int iNum3 = (int)dNum1 + (int)fNum2;
		int iNum4 = (int)(dNum1 + fNum2);
		System.out.println(iNum3);
		System.out.println(iNum4);
		
		
		char ch = '\uAE00';
		
		System.out.println('\uAE00');
		System.out.println('\uAE00');
		System.out.println("\uAE00" + ch);
		System.out.println("\\uAE00" + ch);
		
		
	}

}

출력값  
10  
10  
10  
20.0  
30.0  
1  
2  
글  
글  
글글  
\uAE00글  


	// 파충류 파1 = 고릴라1;
		byte b = 25;
		short s = b;
		int i = s;
		long l = i;
		// 실수
		float f = i;
		double d = f;
