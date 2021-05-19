## 과제3

package homework_5_18;

import java.util.Scanner;

public class Scannerhome1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			System.out.println("몸무게 :" );
			String num1 = scanner.nextLine();
			System.out.println("키 :");                   
			String num2 = scanner.nextLine();
			int height=Integer.parseInt(num2);
			int weight=Integer.parseInt(num1);
			int fat = (weight + 100) - (height);
			
			if (height == -1 || weight == -1) {
				System.out.println("아 머리아파 죽겠네");
				break;
			}
			if(fat > 0) {
				System.out.println("비만수치 비만");
			}
			else System.out.println("비만이 아닙니다.");
			
		}
	}

}

## 삼항연산자

package homework_5_18;

import java.util.Scanner;

public class Scannerhome2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			System.out.println("몸무게 :" );
			String num1 = scanner.nextLine();
			System.out.println("키 :");                   
			String num2 = scanner.nextLine();
			int height=Integer.parseInt(num2);
			int weight=Integer.parseInt(num1);
			int fat = (weight + 100) - (height);
			
			int fat2;
			int fat3;
			
			fat2 = (height == -1 || weight == -1) ? 0 : 1;
			if(fat2 == 0) {
			System.out.println("끝");
			break;
			}
			fat3 = (fat > 0) ? 0 : 1;
			if(fat3 == 0) {
			System.out.println("비만수치 비만");
			}
			else System.out.println("비만이 이닙니다.");
			
		}
	}
}
