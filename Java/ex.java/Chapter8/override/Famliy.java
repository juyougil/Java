package ex.java.chapter8.override;

public class Famliy {

	public static void main(String[] args) {
		Parent parent = new Parent("부모");
		parent.info();
		
		Child child = new Child("부모","학생",50) ;
		child.info();

	}

}
