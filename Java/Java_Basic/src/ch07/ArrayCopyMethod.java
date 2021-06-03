package ch07;

public class ArrayCopyMethod {
	public static  void arrayCopy(String[] src, int srcPos, String[] dst, int dstPos, int length) {
		for(int i = 0; i < length; i++) {
			dst[dstPos + i] = src[i + srcPos];
		}
	}
	

	public static void main(String[] args) {
		String[] string = new String[] {"메롱","롱메","메로나"};
		String[] str = new String[3];
		
		arrayCopy(string , 0,str, 0 , 3);
		
		for(String a : str) {
			System.out.println(a);
		}
		
		

	}

}
