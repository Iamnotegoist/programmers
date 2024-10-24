package 프로그래머스.레벨2;

/*
 * 문제 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */
public class Problem_92342 {
	public static void main(String[] args) {
		solution(
				1,
				new int[] {1,0,0,0,0,0,0,0,0,0,0}
				);
	}

	static int N, M, max;
	static int[] points;
	static int[] answer;
	public static int[] solution(int n, int[] info) {
		N = n;
		M = info.length;
		points = new int[M];
		max = Integer.MIN_VALUE;
		
		dfs(info, 0);
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < answer.length; i++) {
//			sb.append(answer[i]).append(" ");
//		}
//		System.out.println(sb);
		return answer;
	}
	
	public static void dfs(int[] info, int depth) {
		if(depth == N) {
			int scoreGap = calScore(info);
			
			if(max <= scoreGap) {
				max = scoreGap;
				if(max == -1) {
					answer = new int[] {-1};
				} else {
					answer = points.clone();
				}
			}
			
			return;
		}
		
		for(int i = 0; i < M && points[i] <= info[i]; i++) {
			points[i]++;
			dfs(info, depth + 1);
			points[i]--;
		}
	}
	
	public static int calScore(int[] info) {
		int lionScore = 0;
		int apeachScore = 0;
		
		for(int i = 0; i < M; i++) {
			if(info[i] == 0 && points[i] == 0)
				continue;
			if(info[i] >= points[i]) {
				apeachScore += (10 - i);
			} else {
				lionScore += (10 - i);
			}
		}
		
		if(lionScore - apeachScore <= 0) return -1;
		
		return (lionScore - apeachScore);
	}
}
