package kr.java.chapter8.override;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super();
		this.customerName = customerName;
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
		//System.out.println("VIPCustomer() 생생자 호출");
		
	}
	
	public int getAgentID() {
		return agentID;
	}

	@Override
	public int calcPrince(int price) {
		bounsPoint += price * bonusRatio;
		return price - (int) (price * saleRatio);
	}
	@Override
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " +  customerGrade + "이며, 보너스 포인트는 "+ bounsPoint + "입니다."+ "담당 상당원 번호는 "+ agentID + "입니다."; 
	}
	
	
}


