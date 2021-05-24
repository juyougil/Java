package ex.java.chapter4;
import java.util.Scanner;
public class Test6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		for(int i =1; 1<13; i++) {
			if(i % 3 != 0)
				continue;
			sum += Math.pow(i*2,i);
		}
		//System.out.println(sum);
}
}