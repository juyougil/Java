package ex.java.chapter8.override;

public class Main {

	public static void main(String[] args) {
		double r =10;
		Calculator calculator = new Calculator();
		System.out.println("원면적: " + calculator.areaCircle(r));
		
		Comeputer com = new Comeputer();
		System.out.println("원면적: " + com.areaCircle(r));

	}

}
