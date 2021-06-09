package ch10;

public class SoundMain {

	public static void main(String[] args) {
		Soudable cat = new Cat();
		Soudable dog = new Dog();
		
		System.out.println(cat.sound());
		System.out.println(dog.sound());
		
		doSound(new Dog());
		doSound(new Cat());

	}
	static void doSound(Soudable s) {
		s.sound();
	}

}
