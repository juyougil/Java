package kr.java.chapter13;

	
	class Outer2{
		int outNum = 100;
		static int sNum = 200;
		
		
		
		Runnable getRunnaber(int i) {
			int num = 100;
			
			return new Runnable() {
			
				int localNum = 10;
				@Override
				public void run() {
					System.out.println("I = "+ i);
					System.out.println("num ="+ num);
					System.out.println("localNum= "+ localNum);
					System.out.println("outNum = "+ outNum + "(외부 클래서 인스턴스 변수)");
					System.out.println("Outer.sNum= "+ Outer.sNum+"(외부 클래서 정적 변수)");
				}
			
			//return new MyRunnable();
		};
	}
	}
public class AnonymousInnerTest {

	public static void main(String[] args) {
		Outer2 out = new Outer2();
		Runnable runner = out.getRunnaber(10);
		runner.run();


	}

}