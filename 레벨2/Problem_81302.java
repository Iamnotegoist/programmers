package 레벨2;

/*
 * 문제 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class Problem_81302 {
	public static void main(String[] args) {
		
		solution(
				new String[][] {
					{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
					{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
					{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
					{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
					{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
				}
				);
	}
	
	
	static char[][] place;
	static boolean visit = false;
	static int[] result = new int[5];
	static boolean isFail = false;
	public static int[] solution(String[][] places) {
		for(int i = 0; i < 5; i++) {
			place = new char[5][5];
			for(int j = 0; j < 5; j++) {
				place[j] = places[i][j].toCharArray();
			}
			
			isFail = false;
			dfs(0, 0, 0);
			if(isFail) {
				result[i] = 0;
			} else {
				result[i] = 1;
			}
		}
		return result;
	}
	
	public static void dfs(int depth, int x, int y) {
		if(depth == 3) {
			return;
		}
		
		for(int i = y; i < 5; i++) {
			for(int j = x; j < 5; j++) {
				if(place[i][j] == 'P' && !visit) {
					if(j + 1 <= 4) {
						j++;
						visit = true;
						dfs(depth + 1, i, j);
						j--;
						visit = false;
					}
					if(i + 1 <= 4) {
						i++;
						visit = true;
						dfs(depth + 1, i, j);
						i--;
						visit = false;
					}
				} else if(place[i][j] == 'P' && visit) {
					isFail = true;
					visit = false;
					return;
				} else if(place[i][j] == 'O' && visit) {
					if(j + 1 <= 4) {
						j++;
						visit = true;
						dfs(depth + 1, i, j);
						j--;
						visit = false;
					}
					if(i + 1 <= 4) {
						i++;
						visit = true;
						dfs(depth + 1, i, j);
						i--;
						visit = false;
					}
				} else if(place[i][j] == 'X' && visit) {
					visit = false;
					return;
				}
			}
		}
	}
}
