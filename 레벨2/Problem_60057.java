package 레벨2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_60057 {
	public static void main(String[] args) {
		solution("a");
	}

	public static int solution(String s) {
		
		Queue<String> queue = new LinkedList<String>();
		int max = Integer.MIN_VALUE;
		int minLength = Integer.MAX_VALUE;
		
		if(s.length() == 1) {
			return 1;
		}
		for(int i = 1; i <= s.length() / 2; i++) {
			String[] strArray = s.split("(?<=\\G.{" + i + "})");
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j = 0; j < strArray.length; j++) {
				queue.add(strArray[j]);
			}
			
			String prev = queue.poll();
			for(int j = 1; j < strArray.length; j++) {
				if(prev.equals(queue.peek())) {
					count++;
					prev = queue.poll();
				} else if(count > 1){
					sb.append(count).append(prev);
					prev = queue.poll();
					count = 1;
				} else if(count == 1) {
					sb.append(prev);
					prev = queue.poll();
				} 
			}
			if(count > 1) {
				sb.append(count).append(prev);
			} else {
				sb.append(prev);
			}
			if(minLength >= sb.length()) {
				minLength = sb.length();
			}
			
			queue.clear();
			
		}
		return minLength;
	}
}
