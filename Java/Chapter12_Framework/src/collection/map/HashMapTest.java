package collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("홍길동", 1);
		map.put("고길동", 2);
		map.put("이동형", 3);
		map.put("자라섬", 4);
		
		Iterator<String> i1 = map.keySet().iterator();
		while(i1.hasNext()) {
			String key = i1.next();
			Integer v = map.get(key);
			System.out.println(key + ":" + v);
		}

	}

}
