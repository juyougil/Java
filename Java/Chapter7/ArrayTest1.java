package kr.java.chapter7;

public class ArrayTest1 {

	public static void main(String[] args) {
		// 10개 짜리 문자열 배열
		//1번
		String[] testArray;
		testArray = new String[10];
		
		String[] testArray2 = new String[10];
		String testArray3[] = new String[10];
		
		//2번
		String[] testArray4 = new String[] {
				"1","2","3","4","5",
				"6","7","8","9","10"
		};
		//3번
		String[] testArray5 = {
				"1","2","3","4","5",
				"6","7","8","9","10"
		};
		
		String[] testArray6 = {};
		
		System.out.println("testArray = "+ testArray.length);
		System.out.println("testArray2 = "+ testArray2.length);
		System.out.println("testArray3 = "+ testArray3.length);
		System.out.println("testArray4 = "+ testArray4.length);
		System.out.println("testArray5 = "+ testArray5.length);
		System.out.println("testArray6 = "+ testArray6.length);
		
		
		//double 5, 8, 30개 크기의 배열 3개 만들고, 크기 출력!
		
		double[] testArray7 = {1,2,3,4,5};
		double[] testArray8 = new double[8];
		double[] testArray9;
		testArray9 = new double[30];
		
		System.out.println("testArray7 = "+ testArray7.length);
		System.out.println("testArray8 = "+ testArray8.length);
		System.out.println("testArray9 = "+ testArray9.length);
		
		
		
		
	}

}
