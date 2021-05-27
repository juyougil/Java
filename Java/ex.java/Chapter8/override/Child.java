package ex.java.chapter8.override;

public class Child extends Parent {
	String name;
	int studentNum;
	public Child(String name,String name1 ,int studentNum) {
		super(name);
		this.name = name1;
		this.studentNum = studentNum;
		
	}
	@Override
	public void info() {
		System.out.println(super.name+ this.name+ this.studentNum);
	}
	
	
}
