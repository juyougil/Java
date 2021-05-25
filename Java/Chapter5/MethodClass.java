package kr.java.chapter5;

public class MethodClass {
	public int add(int i1, int i2) {
		int result;
		result = i1 + i2;
		return result;
		// return i1 + i2
	}
public int getTenTotal() {
	int i; 
	int total = 0;
	for(i =1; i <=10; i++) {
		total +=i;
	}
	return total;
}

public void printTenTotal( ) {
	int total = getTenTotal();
	System.out.println(total);
}//1. 값을 반환

public void printGreeting(String name)  {
	System.out.println(name + " Hello..." );
	return;//2. void 반환
}
public void divide(int num1, int num2) {
	if(num2 == 0) {
		System.out.println("0일수 없음...");
		return; // 3. code break를 의미
	}else {
		int result = num1 /num2;
		System.out.println(num1 + "/" + num2 + "=" + result + "입니다.");
	}
}

}