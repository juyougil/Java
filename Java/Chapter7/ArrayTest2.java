package kr.java.chapter7;

import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
		String[] strArray = new String[] {
				"1","2","3","4","5",
				"6","7","8","9","10"
				};
		System.out.println(strArray.toString());
		System.out.println(strArray);
		
		for(int i=0; i < strArray.length; i++) {
			int t = i * Integer.parseInt(strArray[i]);
			strArray[i] = t + " ";
			System.out.println(strArray[i]);
		}
		strArray[5] = "Hello";
		
		//Java.util.Arrays
		System.out.println(Arrays.toString(strArray));

}
}