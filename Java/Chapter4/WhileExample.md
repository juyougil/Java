## While 반복문 사용

package kr.java.chapter4;

public class WhileExample1 {

	public static void main(String[] args) {
		int num = 1;
		int sum = 0;
		
		while(num <= 10) {
			sum += num;
			num++;			
		}
		System.out.println("1부터의 10까지의 합은 " + sum + "입니다.");
	}

}
## While 무한 반복

while(true) {
  ...
		}
    
## do while문 
중가로 안의 문장을 반드시 한 번 이상 수행해야 할 때  

do{  
  수행문1;  
  ...  
  }while(조건식);  
  수행문2;  
  ..  
