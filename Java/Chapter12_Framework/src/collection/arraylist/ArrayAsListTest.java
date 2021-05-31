package collection.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import collection.Member;

public class ArrayAsListTest {

	public static void main(String[] args) {
		// 서초구, 구로구, 강성구
		List<String> list = java.util.Arrays.asList("서초구","구로구","강서구");
		
		
		List<Member> list1 = Arrays.asList(new Member(1,"A"));
		
		System.out.println(list);
		System.out.println(list1);
		
		for(Member m : list1) {
			m.getMemberName();
		}
		
		Iterator<Member> it = list1.iterator();
		while(it.hasNext()) {
			Member m = it.next();
			m.getMemberName();		
			}
		
		
		
	}

}
