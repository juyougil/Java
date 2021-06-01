package kr.java.chapter13;

public class InnerClassExample1 {
	private int outerHashCode;
	public String outerClassName;
	static boolean isOuter;
	
	class InnerClass{
		private int innerHashCode;
		public String innerClassName;
		static final boolean isInner = true;
		
		public InnerClass() {
			innerHashCode = System.identityHashCode(this);
			innerClassName =   this.getClass().getName();
		}
		public void printOuterInfo() {
			System.out.println("Outer hash "+ outerHashCode);
			System.out.println("Outer Name "+ outerClassName);
			System.out.println("It is Outer class : " + isOuter);
		}
		public void printInnerInfo() {
			System.out.println("Inner hash "+ innerHashCode);
			System.out.println("OInner Name "+ innerClassName);
			System.out.println("It is Inner class : " + isInner);
		}
	}
	
	
	public InnerClassExample1() {
		outerHashCode = System.identityHashCode(this);
		outerClassName = this.getClass().getName();
		isOuter = true;
	}

	public static void main(String [] args) {
		
}
	
}
