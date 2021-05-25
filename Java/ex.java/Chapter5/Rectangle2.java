package ex.java.chapter5;

public class Rectangle2 {

	public static void main(String[] args) {
		Rectangle_Class rec = new Rectangle_Class("사각형1", 15,20);
		Rectangle_Class rec2 =new  Rectangle_Class("사각형2", 19,80);
		
		
		Rectangle_Class rec3 = new Rectangle_Class("사각형1", 15,20);
		System.out.println(rec3.name + ": " + rec3.getArea());
		
		
		Rectangle_Class rec4 =new  Rectangle_Class("사각형2", 19,80);
		System.out.println(rec4.name + ": " + rec4.getArea());
		
	}

}
