package kr.java.chapter11;

public class WrapperClassTest {

	public static void main(String[] args) {
		Integer ivalue = new Integer(100);
		//박싱
		ivalue = Integer.valueOf(100);
		ivalue = Integer.valueOf("1000");
		//언박싱
		int i = ivalue.intValue();
		i = Integer.parseInt("100");
		
		Byte bt = Byte.valueOf("10");
		byte b = Byte.parseByte("10");
		
		
		Float ft = Float.valueOf("2.4F");
		
		//비교연산
		Integer i1 = Integer.valueOf("1000");
		Integer i2 = Integer.valueOf("1000");
		
		if(i1.equals(i2))
			System.out.println("equal: 1000");
		
		if(i1 == i2)
			System.out.println("==: 1000");
		
		

	}

}
