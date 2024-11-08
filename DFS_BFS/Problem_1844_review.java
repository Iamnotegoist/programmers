package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 BFS 문제 복습하기
public class Problem_1844_review {
	public static void main(String[] args) {
		solution(
				new int[][]
						{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}
				);
		
	}

	public static int solution(int[][] maps) {
		int answer = 0;
		return answer;
	}
	
	public static void bfs(int[][] maps) {
		Queue<int[]> queue = new LinkedList();
		int n = maps.length;
		int m = maps[0].length;
		
		boolean[][] visited = new boolean[n][m];
		queue.add(new int[] {0, 0, 1});
		visited[0][0] = true;
		
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int count = temp[2];
		}
				
	}
}
