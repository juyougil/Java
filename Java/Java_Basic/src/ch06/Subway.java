package ch06;

public class Subway {
	int lineNumber; // 번호
	int passengerCount; // 승객 수
	int money; // 수입
	
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public void take(int money) { // 승객이 낸 돈을 받음
		this.money +=money; // 수입 증가
		passengerCount++; // 승객 수 증가
	}
	public void showInfo() { // 정보 출력
		System.out.println("버스: " + lineNumber + "번의 승객은 "+ passengerCount+"명이고, 수입은"+ money+"입니다");
	}

}
