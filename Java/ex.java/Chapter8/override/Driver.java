package ex.java.chapter8.override;

import java.util.ArrayList;

public class Driver {
	public static void main (String[] args) {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		list.add(new Bus());
		list.add(new Taxi());
		
		
		for(Vehicle veicle : list) {
			veicle.info();
		}
		
	}
	
}
