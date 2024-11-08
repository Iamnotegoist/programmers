package DFS_BFS;

public class Problem_43162_SolveByDfs {
	public static void main(String[] args) {
		solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
	}

	static boolean[] visited;
	static int count = 0;
	public static int solution(int n, int[][] computers) {
		visited = new boolean[n];
		
		for(int i = 0; i < computers.length; i++) {
			if(!visited[i]) {
				dfs(computers, i);
				count += 1;
			}
		}
		
		return count;
	}
	
	public static void dfs(int[][] computers, int node) {
		
		
		if(!visited[node]) {
			visited[node] = true;
			for(int i = 0; i < computers[0].length; i++) {
				if(computers[node][i] == 1) {
					dfs(computers, i);
				}
			}
		}
		
	}
}
