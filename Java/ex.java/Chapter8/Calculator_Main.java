package ex.java.chapter8;

public class Calculator_Main {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setOperand(10, 5);
		cal.sum();
		cal.avg();
		
		SubCalculator cal1 = new SubCalculator();
		cal1.setOperand(10, 5);
		cal1.sub();

	}

}
