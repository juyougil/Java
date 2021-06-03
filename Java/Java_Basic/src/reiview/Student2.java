package review;

public class Student2 {
	// 필드: 가능하면 private 선언!
	
	// package modifier
	private int age;
	private String name;
	private String address;
	// 필드에 접근하는 메서드를 get, set 접두어로 메서드를 선언해 사용.
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Student2() {
		
	}
	
	// 메서드 오버로딩
	public Student2(String n, int a) {
		this.age = a;
		this.name = n;
	}
}
