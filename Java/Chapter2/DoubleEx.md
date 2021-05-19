## 실수 표현과 실수를 정수 자료형으로 표현했을 경우

package kr.java.chapter2;

public class DobleEx1 {

	public static void main(String[] args) {
		double dnum = 3.14;
		float fnum = 3.14F;
		
		System.out.println(dnum);
		System.out.println(fnum);
		
		//minus
		double dnum2 = -3.14;
		float fnum2 = -3.14F;
		
		System.out.println(dnum2);
		System.out.println(fnum2);
		
		//float to int
		System.out.println("double2long:" + (long)dnum2 );
		System.out.println("double2int:" + (int)dnum2 );
		System.out.println("double2short:" + (short)dnum2 );
		System.out.println("double2byte:" + (byte)dnum2 );
		
    //		int i1 = fnum;
    //		long li = dnum;
		
		// int to float/double
		int i1 = 32768;
		int i2 = 2147483647;	//max
		int i3 = -214748364;	//min
		double dnum3 = i2;
		System.out.println("dnum3: " + dnum3);
		System.out.println("dnum3: " + (double)i2);

출력값
3.14
3.14

-3.14
-3.14

double2long:-3 
double2int:-3
double2short:-3
double2byte:-3
//  실수를 정수자료헝으로 변환하면 소수점부분이 사라짐

dnum3: 2.147483647E9  
dnum3: 2.147483647E9  
Is true: true  
Is false: false  
b1:true  


## 부동소수점은 오차가 있지만 큰 범위의 수를 표현 가능하기때문에 씀
package kr.java.chapter2;

public class DoubleEx2 {

	public static void main(String[] args) {
		double dnum = 1;
		for(int i = 0; i < 10000; i++) {
			dnum = dnum + 0.1;					
		}
		System.out.println(dnum);
		
	}

}
// 결과는 1001일 것 같지만 1001.000000000159을 

