package 프로그래머스.DFS_BFS;

public class Problem_43165 {
	public static void main(String[] args) {
		solution(
				new int[] {4, 1, 2, 1},
				4
				);
		
	}
	
	static int sTarget;
	static int count;
	public static int solution(int[] numbers, int target) {
		sTarget = target;
		dfs(0, numbers, true, 0);
		dfs(0, numbers, false, 0);
		
		System.out.println(count);
		return count;
	}
	
	public static void dfs(int depth, int[] numbers, boolean isPlus, int sum) {
		if(isPlus) {
			sum += numbers[depth];
		} else
			sum -= numbers[depth];
		
		if(depth == numbers.length - 1) {
			if(sum == sTarget) {
				count ++;
			}
			return;
		}
		
		dfs(depth + 1, numbers, true, sum);
		dfs(depth + 1, numbers, false, sum);
	}
}
