package kr.java.chapter13;

public class ExInnerClassDb {
	public void retrieve(String table) {
		//Db talbe에서 data row fetch.
		//제목, 저자, 청구번호
		class Book {
			String author;
			String title;
			String no;
			
			public Book(String a,  String t, String n) {
				this.author =a;
				this.title =t;
				this.no = n;
			}
		}
		
	}

	public static void main(String[] args) {
		

	}

}
