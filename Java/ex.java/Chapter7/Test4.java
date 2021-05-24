package ex.java.chapter7;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(">계산식을 입력하세요: ");
		String op = scanner.nextLine();
		
		String[] sik = op.split("");
		
		for(int i = 0; i < sik.length; i++) {
			System.out.print(sik[i]+ "");
		}
		int num1 = Integer.parseInt(sik[0]);
		int num2 = Integer.parseInt(sik[2]);
		System.out.println();
		switch(sik[1]) {
		case "+" : System.out.println(num1 + num2);
		break;
		case "-" : System.out.println(num1 - num2);
		break;
		case "*" : System.out.println(num1 * num2);
		break;
		case "/" : System.out.println(num1 / num2);
		break;
		}
	}

}
