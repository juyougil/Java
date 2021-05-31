package kr.java.chapter12;

public class CenericBox {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("Hello");
		box.set(new Integer(100));
		String str = (String) box.get();
		
		Box2<String> box2 = new Box2<String>();
		box2.set("Hello");
		str = box2.get();

		
	}
	
	
	
	
	
}

	class Box{
	private Object obj;
	public void set(Object o) {
		this.obj = o;
	}
	public Object get() {
		return this.obj;
	}
}
	
	
	class Box2<String>{
		private String str;
		public void set(String s) {
			this.str = s;
		}
		public String get() {
			return this.str;
		}

	}