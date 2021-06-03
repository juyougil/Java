package ch06;

public class StudentStatic {
	public static int count;
	private String name;
	private int grade;
	private int money;
	public StudentStatic() {
		this("", 0);
	}
	
	public StudentStatic(String name, int money) {
		this.money = money;
		this.name = name;
		
	}
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	public void showInfo() { // 정보 출력
		System.out.println(this.name +"님의 남은 돈은 "+ money+"입니다");
	}
	
	public static int getCount() {
		//return this.count;
		//return count;
		return StudentStatic.count;
	}
	public static void setCount(int i) {
		StudentStatic.count += i;
	}
}
