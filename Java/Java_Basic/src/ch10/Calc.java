package ch10;

public interface Calc {
	
	double PI = 3.14;
	int ERROR = -999999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	static int total(int[] arr) {
		int t = 0;
		for(int i : arr) {
			t  += i;
		}
		myStaticMethod();
		return t;
	}
	
	default void descrition() {
		System.out.println("계산시...");
		myMethod();
	}
	
	
	
	private void myMethod() {
		System.out.println("pivate method");
	}
	private static void myStaticMethod() {
		System.out.println("pivate static method");
	}

}
