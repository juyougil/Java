package ch09;

public class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
		
	}

	@Override
	public void jump() {
		System.out.println("");
		
	}

	@Override
	public void turn() {
		System.out.println("");
		
	}

	@Override
	public void showLevelMessage() {
		System.out.println("*****초보자 레벨입니다.*****");
		
	}

}
