package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_43162_SolveByBFS {
	public static void main(String[] args) {
		solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
	}

	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int count = 0;
	public static int solution(int n, int[][] computers) {
		visited = new boolean[n];
		
		for(int i = 0; i < computers.length; i++) {
			if(!visited[i]) {
				bfs(computers, i);
				count += 1;
			}
		}
		
		return count;
	}
	
	public static void bfs(int[][] computers, int node) {
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			visited[temp] = true;
			
			for(int i = 0; i < computers[0].length; i++) {
				if(computers[temp][i] == 1) {
					if(!visited[i]) {
						queue.offer(i);
					}
				}
			}
		}
	}
}
