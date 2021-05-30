package kr.java.chapter11;
import ex.java.chapter10.Drawable;
import ex.java.chapter10.DrawableMain;
import kr.java.chapter10.*;

	class Book {
		int bookNumber;
		String bookTitle;
		
		Book(int bookNumber, String bookTitle){
			this.bookNumber = bookNumber;
			this.bookTitle = bookTitle;
		}
		@Override
		public String toString() {
		Class c = getClass();
		c.getName();
		return getClass().getName()+":"+hashCode()+Integer.toBinaryString(hashCode()) + bookTitle +"," + bookNumber;
		}
	}
	

	public class toStringEx {
	public static void main(String[] args) {
		
		Book book1 = new Book(200, "개미");
		System.out.println(book1);
		System.out.println(book1.toString());
		
		String str = new String("알고리즘");
		Integer i1 = new Integer(1000);
		System.out.println(str);
		System.out.println(i1);		
		
		
	}

}
