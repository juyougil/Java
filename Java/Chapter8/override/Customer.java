package kr.java.chapter8.override;

public class Customer {
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	
	int bounsPoint;
	double bonusRatio;
	
	public Customer() {
		initCustomer();
		//System.out.println("Cusomer() 생성자 호출");
	}
	
	public Customer(int customerID, String customerName) {
		//this();
		initCustomer();
		
		this.customerID = customerID;
		this.customerName = customerName;
		// System.out.println("Cusomer(int, String) 생성자 호출");
	}
	
	private void initCustomer() { // 고객 등급과 보너스 포인트 적립률 지정 함수
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	public int calcPrince(int price) {
		bounsPoint += price * bonusRatio;
				return price;
	}
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " +  customerGrade + "이며, 보너스 포인트는 "
 + bounsPoint + "입니다.";
 }
	
	
	
	
	
	
	
}
