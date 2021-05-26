package ex.java.chapter6;

public class Person_Class {
	String name;
	String jop;
	int age;
	String gender;
	String blood;
	
	public Person_Class(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("이름: " + this.name + "나이: " + this.age);
	}
	
	public Person_Class(String name, int age,String gender,String blood, String jop) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.blood = blood;
		this.jop = jop;
		System.out.println("");
		System.out.println("이름: " + this.name + "  나이: "+ this.age + "  성별: " + this.gender + "  직업: " + this.jop + "  혈액형: "+ this.blood);
		play();
	}

	public void play() {
		String play = " ";
		if(this.jop.equals("의사")) {
			play = "진료한다";
		}else if(this.jop.equals("골프선수")){
			play = "라운딩 갔다";
		}else if (this.jop.equals("교수")){
			play = "강의 중";
		}
		System.out.println(this.jop + "는 " + play);
		
	}
	

}
