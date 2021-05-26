package ex.java.chapter8;

public class Car {
	protected String name;
	protected int bagi;
	
	public Car() {
		this(" ", 0);
	}
	
	public Car(String name, int bagi) {
		this.name = name;
		this.bagi = bagi;
	}
	
	public void run() {
		System.out.println(this.name +"배기량: " + this.bagi);
	}

}
