package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1844 {
	public static void main(String[] args) {
		solution(new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } }
//						{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}
		);
	}

//	static boolean isSuccess = false;
//	static int min = Integer.MAX_VALUE;
//	public static void dfs(int[][] maps, boolean[][] visit, int x, int y, int count) {
//		if(y >= maps.length || y <= -1 || x >= maps[0].length || x <= -1 || visit[y][x] || maps[y][x] == 0) {
//			return;
//		}
//		if(x == maps[0].length - 1 && y == maps.length - 1) {
//			isSuccess = true;
//			if(min > count) {
//				min = count;
//			}
//			return;
//		}
//		count ++;
//		visit[y][x] = true;
//		dfs(maps, visit, x + 1, y, count);
//		dfs(maps, visit, x - 1, y, count);
//		dfs(maps, visit, x, y + 1, count);
//		dfs(maps, visit, x, y - 1, count);
//		visit[y][x] = false;
//	}
	
	

	public static int solution(int[][] maps) {
		bfs(maps);

		return answer;
	}


	static int answer = -1;
	public static void bfs(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { 0, 0, 1 });

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int count = temp[2];

			if (x == n - 1 && y == m - 1) {
				answer = count;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if ( (0 <= nx && nx <= n - 1 ) && (0 <= ny && ny <= m - 1) && !visited[nx][ny] && maps[nx][ny] == 1) {
					queue.offer(new int[] { nx, ny, count + 1 });
					visited[nx][ny] = true;
				}
			}
		}
		return;
	}
}
