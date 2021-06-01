package kr.java.chapter13;

public class StaticInnerClassTest {
	static class MyInnerClass{
		
	}

	public static void main(String[] args) {
		MyInnerClass innerObj = new StaticInnerClassTest.MyInnerClass();
	}

}
