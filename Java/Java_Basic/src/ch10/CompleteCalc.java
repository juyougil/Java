package ch10;

public class CompleteCalc extends Calculator {
	
	@Override
	public void descrition() {
		// TODO Auto-generated method stub
		super.descrition();
	}
	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0) {
			return num1/num2;
		}else
			return Calc.ERROR;
	}
	public void showInfo() {
		System.out.println("Calc  인테페이스를 구현하였습니다.");
	}
}
