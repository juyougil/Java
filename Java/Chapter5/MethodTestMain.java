package kr.java.chapter5;

public class MethodTestMain {

	public static void main(String[] args) {
			MethodClass m = new MethodClass();
			int r = m.add(10,100);
			System.out.println(r);
			m.add(10, 100);
			
			m.printTenTotal();
			
			m.getTenTotal();
			
			m.printGreeting("hahaha");
			
			m.divide(100, 1);
			
			m.divide(100, 0);
	}

}
