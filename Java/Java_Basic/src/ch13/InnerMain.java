package ch13;

import ch13.InnerClassTest.InnerClass;

public class InnerMain {

	public static void main(String[] args) {
		//인스턴스 내부 클래스 객체화
		InnerClassTest outer = new InnerClassTest();
		InnerClass inner = outer.new InnerClass();
		
		
		InnerClassTest.StaticInnerClass sclass = new InnerClassTest.StaticInnerClass();
		int j = InnerClassTest.StaticInnerClass.i;
		

	}

}
