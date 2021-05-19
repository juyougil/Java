## 상수 선언
package kr.java.chapter2;

public class Contant {

	public static void main(String[] args) {
		final int MAX_NUM = 100;
		final int MIN_NUM;
		
		
		MIN_NUM =0;
		
		System.out.println(MAX_NUM);
		System.out.println(MIN_NUM);
		
		//MAX_NUM = 1000; 오류발생 상수는 변경불가!!!


		// 값 변경이 안되는 식별자 (변수) => 상수 Constant.
		// 값이 미리/기/사전에 선언을하고 사용하는 목적!
		final double PI = 3.14;
		final double PI2 =3.14;
    	}

}
