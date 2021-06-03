package ch06;

public class TakeTransMain {

	public static void main(String[] args) {
		//두 명의 학생을 생성
		Student studentJames = new Student("James" , 5000);
		Student studentTomas = new Student("Tomas" , 5000);
		
		Bus bus100 = new Bus(100);
		Subway subwayGreen = new Subway(2);
		
		
		studentJames.takeBus(bus100);
		studentTomas.takeSubway(subwayGreen);
		
		studentJames.showInfo();
		
		
		
		
		
		
	}

}
