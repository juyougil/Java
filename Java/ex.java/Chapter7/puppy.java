package ex.java.chapter7;

import java.util.Scanner;

public class puppy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name1 =new String[] {"곰돌이","복돌이","흰둥이","깨소금","까만콩"};
		String[] name2 = new String[] {"Bear","Gift","White","sesami","Black"};
		
		System.out.println("이름을 입력하시오");
		String name = sc.nextLine();
		
		for(int i = 0; i < name1.length; i++) {
			if(name.equals(name1[i])) {
				System.out.println("영어 이름은 :"+name2[i]);
				break;
			}
	}
		

	}
}