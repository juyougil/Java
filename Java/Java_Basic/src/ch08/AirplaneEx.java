package ch08;

public class AirplaneEx {
	//Has-A
	Airplane plane = new Airplane();
	/*
	 * 배행기는 날아 갈 수 있다.(일반 비행기)
	 * 초음속 비행기는 모드가 초음속이면 초음속으로 날고
	 * 모드가 일반이면 일반 비행기 속도로 난다.
	 * 
	 * 비행기 -> Airplane
	 * 			+ fly
	 * 초음속-> Supersonic exteds Airplane
	 * 			+ modeL NORMAL, SUPERSONIC (상수)
	 */

	public static void main(String[] args) {
	
		Supersonic splane = new Supersonic();
		splane.takeoff();
		splane.fly();
		splane.setMode(Supersonic.SUPERSONIC);
		splane.fly();
		splane.setMode(Supersonic.NORMAL);
		splane.land();
		
	}
//Is -A 관계
	class Busplane extends Airplane{
		
	}
	class Boatplane extends Airplane{
		
	}
}


