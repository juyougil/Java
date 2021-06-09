package ch10;

public class CalculatorTest {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		CompleteCalc calc = new CompleteCalc();
		System.out.println(calc.add(num1, num2));
		System.out.println(calc.substract(num1, num2));
		System.out.println(calc.times(num1, num2));
		System.out.println(calc.divide(num1, num2));
		calc.showInfo();
		
		
		System.out.println(calc instanceof Calc);
		System.out.println(calc instanceof Calculator);
		System.out.println(calc instanceof CompleteCalc);
		System.out.println(calc instanceof Object);
		
		Calc calc1 = new CompleteCalc();
		System.out.println(calc.divide(num1, num2));
		
		
		
		
		// default 메소드
		 CompleteCalc cc1 = new CompleteCalc();
		 cc1.add(0, 0);
		 cc1.descrition();
		 
		 
		 
		 Calc.total( new int[] {1,2,3,4,5});
		
		
		
		
		
		
		
		
	}

}
