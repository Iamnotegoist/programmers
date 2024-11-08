package DFS_BFS;

public class Problem_43163 {
	public static void main(String[] args) {
		solution(
				"hit",
				"cog",
				new String[] {"hot", "dot", "dog", "lot", "log", "cog"}
				);
	}

	static int answer = Integer.MAX_VALUE;
	public static int solution(String begin, String target, String[] words) {
		char[] word = begin.toCharArray();
		boolean[] visited = new boolean[words.length];
		
		dfs(begin, target, words, visited, 0);
		
		if(answer == Integer.MAX_VALUE) {
			return 0;
		} else 
			return answer;
	}
	
	public static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
		if(begin.equals(target)) {
			answer = Math.min(answer, count);
		}
		for(int i = 0; i < words.length; i++) {
			if(!visited[i] && isOneCharDifference(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, visited, count + 1);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isOneCharDifference(String begin, String word) {
		int count = 0;
		for(int i = 0; i < begin.length(); i++) {
			if(begin.charAt(i) != word.charAt(i)) {
				count ++;
			}
		}
		
		if(count == 1) {
			return true;
		}
		
		return false;
	}
}
