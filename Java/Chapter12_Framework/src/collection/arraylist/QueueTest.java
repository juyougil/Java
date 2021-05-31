package collection.arraylist;

import java.util.ArrayList;

import collection.Member;

class MyQueue{
	private ArrayList<Member> arrayQueue = new ArrayList<Member>();
	 public void enQueue(Member data) {
		 arrayQueue.add(data);
		 
	 }
public Member deQueue() {
	int len = arrayQueue.size();
	if(len == 0) {
		System.out.println("큐가 있습니다.");
		return null;
	}
	return (arrayQueue.remove(0));
}

}

public class QueueTest {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enQueue(new Member(1001, "A"));
		queue.enQueue(new Member(1002, "B"));
		queue.enQueue(new Member(1003, "C"));
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());

	}

}
