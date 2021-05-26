package ex.java.chapter5;

public class Prime_Class {
	int num;
	int t;
	int PrimeNumbers[];

	
	
public Prime_Class(int num){
	this.num =num;
	this.t = 0;
	PrimeNumbers = new int[num/3+2];
	PrimeNumber();
	
	
	
	
}
	
public void PrimeNumber() {
	for(int i =2; i <= this.num; i++) {
		boolean isPrime = true;
		
		for(int j=2; j*j<=i; j++) {
			
			if(i % j == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			this.PrimeNumbers[t] = i;
			this.t++;
			
		}
	}
	
}
public void print() {
	for(int i = 0; i < t; i++)
		System.out.print(this.PrimeNumbers[i]+" ");

}

}
