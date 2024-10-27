package 프로그래머스.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_43162 {
	public static void main(String[] args) {
		solution(
				3,
				new int[][] 
						{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
				);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
//				dfs(n, computers, visited, i);
				bfs(n, computers, visited, i);
				answer++;
			}
		}
		return answer;
	}
	
	public static void dfs(int n, int[][] computers, boolean[] visited, int index) {
		visited[index] = true;
		for(int i = 0; i < n; i++) {
			if(!visited[i] && computers[index][i] == 1) {
				dfs(n, computers, visited, i);
			}
		}
	}
	
	public static void bfs(int n, int[][] computers, boolean[] visited, int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(index);
		visited[index] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i = 0; i < n; i++) {
				if(computers[temp][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
