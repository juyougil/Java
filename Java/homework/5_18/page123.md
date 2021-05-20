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

package homework_5_18;

public class page123_3 {

	public static void main(String[] args) {
		int dan;
		int num;
		
		for(dan =1; dan < 10; dan++) {
			for(num =1; num <10; num ++ ) {
				if(dan < num) 
					break;
					System.out.println(dan+"*"+num+"="+(dan*num));
			}
		}

	}
}

## 4번 문제 (모르겠어서 4번과 5번은 자바책에 있는 깃허브 자료실 답을 가져왔습니다.)

package homework_5_18;

public class page123_4 {

	public static void main(String[] args) {
		int lineCount = 4;  
		int spaceCount = lineCount/2 +1;
		int starCount = 1;
		
		for(int i = 0; i<lineCount; i++) {
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			for(int j=0; j<starCount; j++) {
				System.out.print('*');
			}
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			spaceCount-=1;
			starCount+=2;
			System.out.println();
		}
	}
}

## 5번 문제

package homework_5_18;

public class page123_5 {

	public static void main(String[] args) {
		int lineCount = 9;  //다른 홀수 값을 넣어보세요
		int spaceCount = lineCount/2 +1;
		int starCount = 1;
		
		for(int i = 0; i<lineCount; i++) {
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			for(int j=0; j<starCount; j++) {
				System.out.print('*');
			}
			for(int j = 0; j<spaceCount; j++) {
				System.out.print(' ');
			}
			
			if(i < lineCount/2) {
				spaceCount-=1;
				starCount+=2;
			}
			else {
				spaceCount+=1;
				starCount-=2;
			}
			System.out.println();
		}
	}

}


