package ch08;

public class Supersonic extends Airplane {
	public final static int NORMAL = 0;
	public final static int SUPERSONIC = 1;
	
	private int mode = NORMAL;
	@Override
	public void fly() {
		if(mode == SUPERSONIC ) {
			System.out.print("초음속 모드");
		}else {
			System.out.print("일반 모드");
			
		}
		
		super.fly();
	}public void setMode(int m) {
		this.mode = m;
	}

}
