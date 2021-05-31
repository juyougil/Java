package collection.arraylist;

import java.util.ArrayList;

import collection.Member;

class MyStack{
	private ArrayList<Member> arrayStack =new ArrayList<Member>();
	
	public void push (Member data) {
		arrayStack.add(data);
	}
	
	public Member pop() {
		int len = arrayStack.size();
		if(len == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		return (arrayStack.remove(len-1));
	}
		
	
}
public class StackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(new Member(1001,"A"));
		stack.push(new Member(1002,"B"));
		stack.push(new Member(1003,"C"));
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		

	}

}
