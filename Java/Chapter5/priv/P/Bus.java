package kr.java.chapter5.priv.P;

public class Bus {
	private String name;
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	private int number;
	
	protected int getNumber() {
		return number;
	}

	protected void setNumber(int number) {
		this.number = number;
	}
	
	
	
	
	public Bus(String name, int number) {
		this.setName(name);
		this.setNumber(number);
		System.out.println("버스 이름: "+ this.getName() + "  버스 번호:  " + this.getNumber());
	}

}
