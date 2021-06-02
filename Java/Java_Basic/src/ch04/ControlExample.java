package ch04;

public class ControlExample {

	public static void main(String[] args) {
		// 
		int age = 10;
		System.out.println(age >= 6); // true. false
		System.out.println(age <= 6); // true. false
		System.out.println(age & 6); //값
		if(age >=6) {
			System.out.println("나이가 "+ age);
		}
		if(age < 6) {
			System.out.println("나이가 "+ age);
		}else {
			System.out.println("다시...");
		}
		
		//P95
		char gender = 'F';

		//F인지?
		if(gender == 'F') {
			System.out.println("여성입니다.");
		}else {
			System.out.println("남성입니다.");
		}
		
		if(gender == 70) {
			System.out.println("여성입니다.");
		}else {
			System.out.println("남성입니다.");
		}
		
		if(gender != 70) {
			System.out.println("여성입니다.");
		}else {
			System.out.println("남성입니다.");
		}
		
		if(gender == 70) 
			System.out.println("여성입니다.");
		else 
			System.out.println("남성입니다.");
		
		//조건식: 이항 관계연산자 <,>,<=,>=,!=
		//산술식과 함께는?
		if((1+1)>0) {
			
		}
		
		// 삼항연산자 적용.
		// 조건식 : 참 ? 거짓값. 반환!
		System.out.println(gender != 70 ? "남성" : "여성");
		
		//복합 if-else if-else
		age = 8;
		int charge = 0;
		
		if(age < 8) {
			charge = 1000;
		}else if(age <14) {
			charge = 2000;
		}else if(age <20) {
			charge = 2500;
		}else {
			charge = 3000;
		}
		
		System.out.println(charge);
		
		System.out.println(age< 8 ? 1000 : age<14 ? 2000 : 2500);
		
		//P100
		int score = 60;
		char grade = 'z';
		
		if(score >=90) { 
			grade = 'A';
		}else if(score >= 80) {
			grade = 'B';
		}else if(score >= 70) {
			grade = 'C';
		}else if(score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		System.out.println("Score: " + score + " grade: " + grade);
		
		// Nested if
		// 95>: A+ 90>:A
		String grd = "";
		if(score >=90) {
			if(score >= 95) {
				grd = "A+";
			}else {
				grd = "A";
			}
		}else {
			if(score >=85) {
				grd = "B+";
			}else
				grd = "B";
		}
		
		// switch- case
		int rank  =20; // 입력된 값
		
		switch(rank) { // key: 숫자형(정수,char), 1.8 버전 이상 문자 가능
		case 10: 
			System.out.println("10");
			break;
		case 20:
		case 30:
			System.out.println("20 30");
			break;
		default:
			System.out.println("END");
		}
		
		//switch char
		grade = 'A';
		
		switch(grade) {
		case'A':
		case'a':
			System.out.println("AAAAAAAA");
			break;
		case'B':
		case'b':
			System.out.println("BBBBBBBB");
			break;
		case'C':
		case'c':
			System.out.println("CCCCCCCC");
			break;
		}
		// jdk1.8 이상.
		String position ="이사";
		switch(position) {
		case "과장":
			break;
		case "차장":
			break;
		case "이사":
			System.out.println("이사님 나이스샷");
			break;
		default:
		}
		
		// 현재 월을 알고 있다. 월의 계절 값을 출력
		//1,2,12: 겨울
		//3,4,5: 봄
		//6,7,8: 여름
		//9,10,11:가을
		
		//switch
		int month = 9;
		String season;
		switch(month) {
		case 1:
		case 2:
		case 12:	
			season = "겨울";
			System.out.println(season);
			break;
		case 3:
		case 4:
		case 5:	
			season = "봄";
			System.out.println(season);
			break;
		case 6:
		case 7:
		case 8:	
			season = "여름";
			System.out.println(season);
			break;
		case 9:
		case 10:
		case 11:	
			season = "가을";
			System.out.println(season);
			break;	
		}
		
		// if-esle
		if(month == 1 || month == 2 || month == 12) {
			season = "겨울";
			System.out.println(season);
		}else if(month == 3 || month == 4 || month == 5) {
			season = "봄";
			System.out.println(season);
		}else if(month == 6 || month == 7 || month == 8) {
			season = "여름";
			System.out.println(season);
		}else if(month == 9 || month == 10 || month == 11){
			season = "가을";
			System.out.println(season);
		}else {
			System.out.println("다시 입력해주세요");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
