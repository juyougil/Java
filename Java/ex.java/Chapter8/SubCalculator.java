package ex.java.chapter8;

public class SubCalculator extends Calculator {
	protected int sub;
	
	public void sub() {
		this.sub = op1 - op2;
		System.out.println(this.sub);	
}


}
