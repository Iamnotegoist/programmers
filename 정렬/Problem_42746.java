package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem_42746 {
	public static void main(String[] args) {
		solution(new int[] {3, 30, 34, 5, 9});
	}

	public static String solution(int[] numbers) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < numbers.length; i++) {
			list.add(Integer.toString(numbers[i]));
		}
		
		Collections.sort(list, new Comparator<String>() {
			
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		String answer = "";
		for(String s: list) {
			answer += s;
		}
		
		if(answer.charAt(0) == '0') {
			return "0";
		}
		return answer;
	}
}
