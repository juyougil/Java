package kr.java.chapter13;

public class InnerClassExample2 {
	
	static class InnerClass {
		static String keyword = "STATIC INNER CLASS";
		public void printInfor() {
			System.out.println("You called printInfo method");
		}
		public static void printName() {
			System.out.println("You called printName method");
		}
	}

	
	public static void main(String[] args) {
		InnerClassExample2.InnerClass inner = new InnerClassExample2.InnerClass();
		
		System.out.println("Keyword: "+ InnerClass.keyword);
		inner.printInfor();
		InnerClass.printName();
		
		

	}

}
