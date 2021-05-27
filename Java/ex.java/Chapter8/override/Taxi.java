package ex.java.chapter8.override;

public class Taxi extends Vehicle {
	public void run() {
		System.out.println("택시가 달린다.");
	}
	public void info() {
		System.out.println("택시에 승객이 탑승.");
	}
}
