## 과제2

package homework_5_18;

import java.util.Scanner;

public class Scannerhome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		while(true) {
		System.out.println("피연산자 :" );
		String num1 = scanner.nextLine();
		System.out.println("연산자 :");                   
		String num2 = scanner.nextLine();
		System.out.println("피연산자:");
		String num3 = scanner.nextLine();	
		int a = Integer.parseInt(num1);
		int c = Integer.parseInt(num3);
			
		switch(num2) {
		case "+" : System.out.println(a+c);
		break;
		case "-" : System.out.println(a-c);
		break;
		case "*" : System.out.println(a*c);
		break;
		case "/" : System.out.println(a/c);
		break;
		default : System.out.println("연산자가 아닙니다.");
		}
		}

	}

}
