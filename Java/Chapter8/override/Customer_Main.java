package kr.java.chapter8.override;

public class Customer_Main {

	public static void main(String[] args) {
		Customer c1 = new Customer();
		//c1.customerName = "홍길동";
		c1.setCustomerName("홍길동");
		System.out.println(c1.showCustomerInfo());
		
		Customer c2 = new Customer(10, "강감찬");
		System.out.println(c2.showCustomerInfo());
		
		
		Customer customerLee = new Customer();
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.bounsPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());
		
		VIPCustomer customerkim =new VIPCustomer();
		customerkim.setCustomerID(10020);
		customerkim.setCustomerName("김유신");
		customerkim.bounsPoint = 10000;
		System.out.println(customerkim.showCustomerInfo());
		
		
		//Customer vc = new VIPCustomer(); //캐스팅
		int price = 10000;
		System.out.println(customerLee.getCustomerName()+ "님이 지불해야 하는 금액은 " + customerLee.calcPrince(price)+ "원 입니다.");
		System.out.println(customerkim.getCustomerName()+ "님이 지불해야 하는 금액은 " + customerkim.calcPrince(price)+ "원 입니다.");
		
		
		
		
		
		
		
	}

	}

