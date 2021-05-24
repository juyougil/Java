package ex.java.chapter7;

import java.util.Scanner;

public class mos {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
		String[] morse =
		{".- ","-... ","-.-. ","-.. ",". ","..-. ",
		"--. ",".... ",".. ",".--- ","-.- ",".-.. ",
		"-- ","-. ","--- ",".--. ","--.- ",".-. ",
		"... ","- ","..- ","...- ",".-- ","-..- ",
		"-.-- ","--.. "};
		String str;
	
		int j;
				
		System.out.println("영어를 입력해주세요");
		str=sc.nextLine();
		
		for(int i=0; i<str.length();i++) {
			
			if(str.charAt(i)>=65 && str.charAt(i)<=90) {
				j=65-str.charAt(i);
				System.out.print(morse[j]);
			}else if(str.charAt(i)>=97 && str.charAt(i)<=122) {
				j=122-str.charAt(i);
				System.out.print(morse[j]);
			}else {
				System.out.print(" ");
			}
		}
		
	}
}