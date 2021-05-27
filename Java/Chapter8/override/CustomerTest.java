package kr.java.chapter8.override;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customerLee = new Customer();
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.bounsPoint = 1000;
		
		System.out.println(customerLee.showCustomerInfo());
		
		
		Customer customerkim = new VIPCustomer(10020, "김유신",12345 );
		customerkim.bounsPoint =1000;
		
		
		System.out.println(customerkim.showCustomerInfo());
		System.out.println("=================== 할인율과 보너스 포인트 계산 ==========");
		
		int price = 10000;
		int leePrice = customerLee.calcPrince(price);
		int kimPrice = customerkim.calcPrince(price);		
		
		System.out.println(customerLee.getCustomerName()+"님이 "+ leePrice + "원 지볼하셨습니다.");
		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerkim.getCustomerName()+"님이 "+ kimPrice + "원 지볼하셨습니다.");
		System.out.println(customerkim.showCustomerInfo());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
