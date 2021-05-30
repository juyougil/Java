package kr.java.chapter11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonEx {

	public static void main(String[] args) throws ClassNotFoundException {
		Class pClass = Class.forName("kr.java.chapter11.Person");
		
		
		
		Constructor[] cons = pClass.getConstructors();
		for(Constructor c : cons) {
			System.out.println(c);
		}
		
		
		System.out.println();
		
		Field[] fields = pClass.getFields();
		for(Field f : fields) {
			System.out.println(f);
		}
		
		System.out.println();
		Method[] methods = pClass.getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
		
		
		
		
		
	}

}
