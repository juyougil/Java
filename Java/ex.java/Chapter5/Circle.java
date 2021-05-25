package ex.java.chapter5;

public class Circle {

	public static void main(String[] args) {
		Circle_Class circle = new Circle_Class("피자", 10);
		System.out.println("이름: " + circle.name + "  면적: " + circle.getArea());
		
		Circle_Class circle2 = new Circle_Class("도넛", 2);
		System.out.println("이름: " + circle2.name + "  면적: " + circle2.getArea());
	}

}
