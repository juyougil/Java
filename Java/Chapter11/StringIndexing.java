package kr.java.chapter11;

public class StringIndexing {

	public static void main(String[] args) {
		String str = "Java Programming";
		System.out.println(str.indexOf("j"));
		System.out.println(str.indexOf("J"));
		System.out.println(str.indexOf("gram"));
		//자르기
		System.out.println(str.substring(0, str.indexOf("gram")));
		
		System.out.println(str.lastIndexOf("gram"));
		
		System.out.println(str.startsWith("java"));
		System.out.println(str.startsWith("Java"));
		
		
		//trim
		//Scanner -> 
		String str1 = "              하하하";
		String str2 = "호호호              ";
		String str3 = "       히히히       ";
		
		System.out.println(str1);
		System.out.println(str1.trim());
		System.out.println(str2.trim());
		System.out.println(str3.trim());
		
}
}
