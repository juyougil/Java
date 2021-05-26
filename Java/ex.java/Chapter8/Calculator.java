package ex.java.chapter8;

public class Calculator {
	protected int op1;   
	protected int op2;
	protected int sum;
	protected int avg;
	
	public void setOperand(int op1, int op2) {
		this.op1 = op1;
		this.op2 = op2;
	}
	public void sum() {
	this.sum = op1 + op2;
	System.out.println(this.sum);
	}
	
	public void avg() {
	this.avg = (op1 + op2) / 2 ;
	System.out.println(this.avg);
	
	
	
	
}
}
