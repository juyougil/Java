package ex.java.chapter5;

public class Circle_Class {
	String name;
	double radius;
	
	
public Circle_Class(String n ,double r) {
	radius =r;
	name = n;
}

public double getArea() {
	double result = radius * radius * 3.14;
	return result;
}
}
