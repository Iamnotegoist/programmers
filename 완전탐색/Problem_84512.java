package 완전탐색;

public class Problem_84512 {

	public static void main(String[] args) {
		solution("I");
	}
	
	static String aeiou = "AEIOU";
	static String find;
	static int order = 0;
	static int answer;
	public static int solution(String word) {
		find = word;
		dfs("", 0);
		return answer;
	}
	
	public static void dfs(String str, int len) {
		if(find.equals(str)) {
			answer = order;
		}
		if(len == 5) {
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			order += 1;
			dfs(str + aeiou.charAt(i), len + 1);
		}
	}
}
