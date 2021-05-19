## 1번 문제

package homework_5_18;

public class page123 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		char operator = '+';
		int end = 0;
		
		switch(operator) {
		case'+' : end = num1 + num2;
		break;
		case'-' : end = num1 - num2;
		break;
		case'*' : end = num1 * num2;
		break;
		case'/' : end = num1 / num2;
		break;
		default : System.out.println("부호가 아닙니다.");
		}
		System.out.println(end);
	}
}
## 2번 문제

package homework_5_18;

public class page123_2 {

	public static void main(String[] args) {
		int dan;
		int num;
		
		 for(dan =1; dan < 10; dan++) {
			 if(dan % 2 != 0)
				 continue;
				 for(num =1; num < 10;num++) {
			 System.out.println(dan + "*" + num +"="+ num * dan);
		 }
		 

	}

}
}

## 3번 문제


