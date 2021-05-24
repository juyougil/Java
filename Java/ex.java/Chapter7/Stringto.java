package ex.java.chapter7;

public class Stringto {

	public static void main(String[] args) {
		String str1 = new String("abc"); //new
		String str2 = "abc"; // 리터럴
		String str3 = "abc";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		str2 = "efg";
		System.out.println(str2); // 바뀜
		System.out.println(str3);
		
		 String str4;
		 str4 = "하나둘셋";// 식별자에 객체 대입
		 System.out.print(str4 + ":");
		 
		 // fina char charat(int)
		 //final int PI = 3.14 ; //상수라 변경불가
		 
		 
		 // dot operator : .
		 System.out.print(str4.charAt(0));
		 System.out.print(str4.charAt(1));
		 System.out.print(str4.charAt(2));
		 System.out.print(str4.charAt(3));
		 
		 System.out.println("");
		 
		 int len = str4.length(); // 4
		 for(int i = 0; i < len; i++) {
			 System.out.println(str4.charAt(i));
		 }
		 
		 /** equals(string) **/
		 
		 System.out.println(str4.equals(str2));
		 System.out.println(str1.equals(str3));
		 System.out.println(str3.equals("abc"));
		 
		 if(str3.equals("abc")) {
			// 
		 }
		 /*
		 String str5;
		 if(str5.equals("abc")) {
			 //
		 }
		 if("abc".equals(str5)) {
			 //
		 }
		 		 */
		 //
		 
		 
		 String[] strs = "하 나 둘 셋 넷".split(" ");
		 System.out.println(strs.length);
		 
		 System.out.println(strs[0]);
		 System.out.println(strs[4]);
		 
		 
		 for(int i = 0; i < len; i++) {
			 System.out.println(strs[i]);
		 }
		 System.out.println("---------------------------");
		 System.out.println("하 나 둘 셋 넷".substring(2, 4));
	}

}
