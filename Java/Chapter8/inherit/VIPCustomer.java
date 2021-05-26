package kr.java.chapter8.inherit;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	
	
	public VIPCustomer() {
		super();
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer() 생생자 호출");
		
	}
	
	public int getAgentID() {
		return agentID;
	}
}
