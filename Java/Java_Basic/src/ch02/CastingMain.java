package ch02;

public class CastingMain {

	public static void main(String[] args) {
		//기본자료형  형변화
		//자료의 크기, 정밀도
		int inum2 = 20;
		float fnum = inum2;
		
		//묵시적 형변환 (Auto Boxing)
		System.out.println("int :" + inum2 + " -> float:" + fnum);
		
		double dnum;
		dnum = fnum + inum2;
		System.out.println("int :" + inum2 + " -> float:" + fnum + "-> double: " + dnum);
		
		// 명시적 형변환.
		// (자료형)자료: 캐스팅 연산자
		byte b2 = 127; //8bit -> 32bit
		int inum3 =  (int)b2;
		System.out.println("int :" + inum3 + "-> byte: " + b2);
		System.out.println("inum3: " + Integer.toBinaryString(inum3) + "\n" + "b: "+ Integer.toBinaryString(b2) );
		
		dnum = 3.14;
		inum3 = (int)dnum;
		System.out.println("dnum: "+ dnum + " -> inum3: " + inum3);
		// 큰 -> 작
		char ch = (char)inum3;
		System.out.println("inum3: "+ inum3 + " char: "+ ch);
		
		
		
		
		
		// P68 연산중 형변환
		
		double dnum1 = 1.2;
		float fnum1 = 0.9F;
		
		inum3 = (int)dnum1 + (int)fnum1; // 각 실수가 형변환 된 후 연산 1.2 ->, 0.9 -> 0.0 1 + 0 =1
		inum2 = (int)(dnum1 + fnum1);//(1.2+0.9) =2.1 ->2
		
		System.out.println("inum3: " + inum3+ "-> inum2: " + inum2);
		
		
		
	}

}
