package ch10;

public class RoundRobin implements Scheduler {

	@Override
	public void getNexCall() {
		System.out.println("상담 전화를 손서대로 대기열에서 가져옵니다.");
		
	}

	@Override
	public void sendCallToAegent() {
		System.out.println("다음 순서 상담원에게 배분합니다.");
		
	}
	

}
