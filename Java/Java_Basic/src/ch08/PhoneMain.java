package ch08;

public class PhoneMain {

	public static void main(String[] args) {
		Phone phone = new Phone("전화", "붏은색", "111111");
		phone.powerOn();
		phone.ring();
		phone.send();
		phone.powerOff();
		
		System.out.println();
		
		VideoPhone phone1 = new VideoPhone("영상전화", "노랑", "111112");
		phone1.powerOn();
		phone1.ring();
		phone1.send();
		phone1.videoCall();
		phone1.powerOff();
		
		Phone phone3 =new VideoPhone(); // UP-Casting ( Auto-Boxing)
		//phone3.videoCall();
		((VideoPhone)phone3).videoCall(); // Down = Casting
		
		Phone phone4 = new Phone("전화","붏은색","111111");
		//Runtime Error 발생
		((VideoPhone)phone4).videoCall();
		
	}

}