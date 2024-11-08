package 해시;

import java.util.HashMap;
import java.util.Iterator;

public class Problem_42578 {
	public static void main(String[] args) {
		solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		Iterator<Integer> iterator = map.values().iterator();
		int answer = 1;
		while(iterator.hasNext()) {
			answer *= iterator.next() + 1;
		}
		return answer - 1;
	}
}
