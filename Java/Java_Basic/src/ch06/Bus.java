package ch06;

public class Bus {
	int busNumber; // 번호
	int passengerCount; // 승객 수
	int money; // 수입
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	public void take(int money) { // 승객이 낸 돈을 받음
		this.money +=money; // 수입 증가
		passengerCount++; // 승객 수 증가
	}
	public void showInfo() { // 정보 출력
		System.out.println("버스: " + busNumber + "번의 승객은 "+ passengerCount+"명이고, 수입은"+ money+"입니다");
	}

}
