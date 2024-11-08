package 해시;

import java.util.HashMap;

public class Problem_42577 {
	public static void main(String[] args) {

	}

	public static boolean solution(String[] phone_book) {
		HashMap<String, Integer> map = new HashMap();
		for(int i = 0; i < phone_book.length; i++) {
			map.put(phone_book[i], 1);
		}
		
		for(int i = 0; i < phone_book.length; i++) {
			int length = phone_book[i].length();
			for(int j = 0; j < length; j++) {
				if(map.containsKey(phone_book[i].substring(0, j))) return false;
			}
			
		}
		
		boolean answer = true;
		return answer;
	}
}
