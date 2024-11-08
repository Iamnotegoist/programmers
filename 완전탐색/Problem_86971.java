package 완전탐색;

import java.util.ArrayList;

public class Problem_86971 {
	
	/*
	 * 노드와 인접한 노드를 표현하는데 ArrayList<Integer>[]를 사용할 수 있다는 점을 배울 수 있었음
	 * 9개의 노드가 있다면
	 * length 10의 ArrayList 배열을 만들어
	 * 인덱스 0은 비워두고
	 * 인덱스 1~9까지 ArrayList에 인접한 노드를 담는다. 
	 */
	static ArrayList<Integer>[] graph;
	static int min;
	
	public static void main(String[] args) {
		solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
	}

	public static int solution(int n, int[][] wires) {
		/*
		 * Generic ArrayList 배열을 만들려면 먼저 ArrayList로 된 배열을 생성하고
		 * 그 다음 각 배열마다 Generic ArrayList를 생성해주어야 한다.
		 */
		graph = new ArrayList[n + 1];
		min = Integer.MAX_VALUE;
		
		for(int i = 1; i <=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		for(int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			
			boolean[] visited = new boolean[n + 1];
			
			graph[v1].remove(Integer.valueOf(v2));
			graph[v2].remove(Integer.valueOf(v1));
			
			int cnt = dfs(1, visited);
			
			/*
			 * count 개수를 세는 작업
			 * 여기서 count 개수는 1개/8개로 분리된 케이스의 경우
			 * count가 1이 나오거나 8이 나오게 되는데
			 * 여기서 그 차이를 구하는 것이 문제이므로
			 * 1에서도 7이 도출되어야 하고
			 * 8에서도 7이 도출되어야 함
			 * 1 - (9 - 1) = -7
			 * 8 - (9 - 8) = 7
			 * 
			 */
			int diff = Math.abs(cnt - (n - cnt));
			min = Math.min(min, diff);
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		return min;
	}
	
	public static int dfs(int v, boolean[] visited) {
		visited[v] = true;
		int cnt = 1;
		
		for(int next: graph[v]) {
			if(!visited[next]) {
				cnt += dfs(next, visited);
			}
		}
		return cnt;
	}
}
