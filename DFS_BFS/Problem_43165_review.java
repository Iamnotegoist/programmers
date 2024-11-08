package DFS_BFS;

public class Problem_43165_review {
	public static void main(String[] args) {
		solution(new int[] {1, 1, 1, 1, 1}, 3);
	}

	static int m;
	static int count = 0;
	public static int solution(int[] numbers, int target) {
		m = numbers.length;
		
		dfs(numbers, target, 0, 0);
		return count;
	}
	
	public static void dfs(int[] numbers, int target, int depth, int result) {
		if(depth == m) {
			if(result == target) count++;
			return;
		}
		
		dfs(numbers, target, depth + 1, result + numbers[depth]);
		dfs(numbers, target, depth + 1, result - numbers[depth]);
	}
}
