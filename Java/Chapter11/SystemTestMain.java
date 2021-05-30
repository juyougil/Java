package kr.java.chapter11;

public class SystemTestMain {

	public static void main(String[] args) {
		// ... 끝나고자 하실때!
		//System.exit(0)
		//System.out.println();
		//시작 시점 시간!
		
		long start = System.nanoTime();
		
		//동작
		int sum = 0;
		for(int i = 0; i <= 100000000; i++) {
			sum += 1;
		}
		//끝 시점 시간.
		long end =System.nanoTime();
		
		System.out.println("합: " + sum);
		System.out.println("시간: "+ (end - start));
		
		
		
		//getProperty
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		
		System.out.println("OS: "+ osName);
		System.out.println("User: "+ userName);
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.class.path"));
		//모든 Property
		System.getProperties().list(System.out);		
		
		
		// getEnv()
		
		System.out.println(System.getenv("PATH"));
		
		
		
		
		
		
		

	}

}
