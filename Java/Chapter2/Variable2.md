##자료형의 최소 최대값

package kr.java.chapter2;

public class Variable2 {

	public static void main(String[] args) {
		// Byte형 : 1 Byte
		byte bs1 = -128;
		byte bs2 = 127; //양수의 범위는 0을 제외해 2에 n승 - 1까지
		
		// Short : 2 Byte
		short sh1 = -32768;
		short sh2 = 32767;
		
		// Int
		int int1 = -2147483648;
		int int2 = 2147483647;
		
		//Long
		long long1 = -9223372036854775808L;
		long long2 = 92233720368547758087;     //자바는 int가 기본사용되기 때문에 롱을 쓰려면 L을 써야한다.
    
		//Char
		char ch1 = 'A';
		char ch2 = 'z';
		
		

	}
