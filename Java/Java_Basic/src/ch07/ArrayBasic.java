package ch07;

public class ArrayBasic {

	public static void main(String[] args) {
		// 배열
		// 자료를 순차적 배치
		// -> index
		// 2차원: 세로 축: column(열), 가로 축: row(행)
		// -> 1행 짜리 자료.
		
		// 연산자[]
		int[] studentIds = new int[] {101,102,103};
		int[] studentIds2 = {101,102,103};
		int[] studentIds3 = new int[100];
		int[] studentIds4;
		studentIds4 = new int[] {101,102,103};
		
		
		System.out.println(studentIds.length);
		System.out.println(studentIds);
		System.out.println(studentIds3.length);
		System.out.println(studentIds3);
		
		//배열 인덱스 사용: 0~length
		System.out.println(studentIds[0]);
		System.out.println(studentIds3[99]);
		
		// Out of Index
		// System.out.println(studentIds[studentIds.length - 1]);
		
		// 예외처리 
		// 1. 인데스 범위 수정
		// 2.ArrayOutOfBoundException 처리
		//System.out.println(studentIds[studentIds.length]);
		try {
			System.out.println(studentIds[studentIds.length]);			
		} catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
			//후속조치
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		//
		
		studentIds[1] = -100;
		studentIds3[80] = 10;
		System.out.println("studentIds[1]: " + studentIds[1]+ " studentIds3[80]: " + studentIds3[80]);
		
		for(int i = 0; i <  studentIds3.length; i++) {
			System.out.printf("studentIds3[%d]: %d \n",i,studentIds3[i]);
		}
		
		for(int a : studentIds3) {
			System.out.println(a);
		}
		
		int count = 0;
		for (int a : studentIds3) {
			System.out.println(a);
			count++;
		}
		
		// 문자열 배열
		String[] messages = new String[5]; // null
		for(String s : messages) {
			System.out.println(s);
		}
		
		for(int i =0; i < messages.length; i++) {
			messages[i] = ""; //new String();
		}
		
		ArrayBasic[] basics =  new ArrayBasic[5];
		for(ArrayBasic a : basics) {
			System.out.println(a);
		}
		
		
		System.out.println(messages);
		System.out.println(basics);
		
		
		//arraycopy() 배열 복사
		//10개 배열을 20개 배열로 복사.
		int[] numbers1 = new int[] {0,1,2,3,4,5,6,7,8,9};
		int[] numbers2 = new int[20];
		
		//numbers1 -> numbers2 복사
		//numbers2 : 0~10
		System.arraycopy(numbers1, 0, numbers2, 0, numbers1.length);
		for(int i : numbers2) {
			System.out.print(i + " ");
		}
		System.out.println();
		//numbers2 : 11~19
		System.arraycopy(numbers1, 0, numbers2, 10, numbers1.length);
		for(int i : numbers2) {
			System.out.print(i + " ");
		}
		System.out.println();
		// for 반복문으로 numbers1 -> numbers2 복사
		// 작은 배열을 기준.
		for(int i = 0; i < numbers1.length; i++) {
			numbers2[i] = numbers1[i];
			System.out.print(numbers2[i]+ " ");
		}
		
		//array는 길이를 알 수 없는 int형 배열
		// 변수 sum에 array의 모든 값을 대해보세요
		// 다음 메서드를 완성하세요.
		
		
		
		
		
		
	}
	int sum(int[] array) {
		int sum = 0;
		for(int i : array) {
			sum += i;
		}
		return sum;
	}	

}
