package 프로그래머스.Greedy;

public class Problem_42860 {
	public static void main(String[] args) {
		solution("BBABAAAAAAAABB");
	}

	public static int solution(String name) {
		int len = name.length();
		int answer = 0;

		// 1. 각 알파벳 변경 횟수 계산
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			answer += Math.min(c - 'A', 'Z' - c + 1); // 위쪽으로 가는 경우와 아래쪽으로 가는 경우 중 최소값
		}

		// 2. 좌우 이동 최소 횟수 계산
		
		//CASE 1. 우로 쭉 이동하는 경우
		int minMove = len - 1;

		for (int i = 0; i < len; i++) {
			int next = i + 1;
			// 연속된 'A'를 건너뛰기 위해 다음 문자를 찾음
			while (next < len && name.charAt(next) == 'A') {
				next++;
			}
			// CASE 2. 우로 이동하다 연속된 A를 만나 다시 좌로 이동하는 경우
			// (2 * i)      : 다시 idx = 0 으로 돌아가는 길
			// (len - next) : 연속된 A 이후에 있는 문자 개수
			minMove = Math.min(minMove, 2 * i + (len - next) );   
			
			// CASE 3. 우로 이동하다 연속된 A를 만난 후 문자가 마치는 경우
			// 연속된 A로 문자가 마치는 경우
			if(next == len) {
				minMove = Math.min(minMove, i );
			}
			
			// CASE 4. 좌로 이동하다 연속된 A를 만나 다시 우로 이동하는 경우
			minMove = Math.min(minMove, i + (len - next) * 2);
			
		}
		


		answer += minMove; // 최소 이동 횟수를 총 답에 더함
		
		System.out.println(answer);
		return answer;
	}
}
