package ch13;

import ch10.Buy;

public class InnerClassTest {
	private int num = 10;
	private static int snum = 10;
	
	
	
	//인스턴스 내부 클래스
	class InnerClass{
		String name;
		
		static final int a = 0;
		
		void info() {
			
		}
	}
	
	//정적 내부 클래스
	static class StaticInnerClass{
		int a = 0;
		static int i = 0;
		void info() {
			a +=2;
			snum += 10;
		}
	}
	//지역 내부 클래스 -> method
	
	public void local() {
		class Test{
			int a;
			String n;
		}
		Test t = new Test();
		
	}
	public Runnable getRunnable() {
		class MyRunnable implements Runnable{
			@Override
			public void run() {
				
			}
		}
		return new MyRunnable();
	}
	//익명 내부 클래스
	
	Object o = new Object() {
		@Override
		public String toString() {
			return " ======";
		}
	};
	
	public Object getobj() {
		return new Object() {
			@Override
			public String toString() {
				return " ======";
			}
		};
		}
	
	Buy b = new Buy() {
		
		@Override
		public void buy() {	
		}
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
