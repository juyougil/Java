package ch09;

public class AbstractEx {
	//추상클래스
	//abstract class  선언
	// - abstract method  선언. -> 코드블럭 X

	public static void main(String[] args) {
		
		Desktop d = new Desktop();
		d.turnOff();
		
		Computer c = new Desktop();
		c.turnOn();
		
		// 추상클래스는 new 연산자 X
		//Computer c = new Computer();
		
		Computer cc = new Computer() {

			@Override
			public void display() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void typing() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		
		
		Object sss = new Object() {
			
			@Override
			public String toString() {
				return "..............";
			}
			
			
			
		};
		
		
		
		System.out.println(sss.toString());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
