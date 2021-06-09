package ch10;

public class PriorityAlocation implements Scheduler {

	@Override
	public void getNexCall() {
		System.out.println("상담 전화를 손서대로 대기열에서 가져옵니다.");
		
	}

	@Override
	public void sendCallToAegent() {
		System.out.println("업무 skill 값이 높은 상담원에게 우선적으로 배분합니다.");
		
	}

}
