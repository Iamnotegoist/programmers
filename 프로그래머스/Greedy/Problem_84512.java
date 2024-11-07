package 프로그래머스.Greedy;

import java.util.ArrayList;
import java.util.List;

public class Problem_84512 {

	public static void main(String[] args) {
		solution("I");
	}
	
	static List<String> list = new ArrayList();
	static String[] words = {"A", "E", "I", "O", "U"};
	public static int solution(String word) {
		int answer = 0;
		dfs("", 0);
		int size = list.size();
		
		return answer;
	}
	
	public static void dfs(String str, int len) {
		list.add(str);
		if(len == 5) return;
		for(int i = 0; i < 5; i++) {
			dfs(str + words[i], len + 1);
		}
	}
}
