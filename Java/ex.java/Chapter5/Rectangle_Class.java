package ex.java.chapter5;

public class Rectangle_Class {
	String name;
	float width;//너비
	float height;//높이
	
	
	public Rectangle_Class() {
		name = "사각형";
		width = 50;
		height = 50;
		System.out.println("이름: "+ name + "    너비: "+ width + "   높이: " + height );
	}
	
	
	public Rectangle_Class(String n) {
		name = n;
		width = 50;
		height = 50;
		System.out.println("이름: "+ name + "    너비: "+ width + "   높이: " + height);
	}
	
	
	public Rectangle_Class(float w, float h) {
		name = "사각형";
		width = w;
		height = h;
		
		System.out.println("이름: "+ name + "    너비: "+ width + "   높이: " + height);
	}
	
	
	public Rectangle_Class(String n, float w, float h) {
		name = n;
		width = w;
		height = h;
		//System.out.println("이름: "+ name +" 면적: " + height*width);
	}
	
	// method
	public float getArea() {
		float result = width* height;
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
