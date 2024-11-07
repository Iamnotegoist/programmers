package 프로그래머스.Greedy;

public class Problem_42883 {
	public static void main(String[] args) {
		solution("1231234", 3);
	}

	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();

		int size = number.length();

		int start = 0;
		int cnt = size - k;
		int end = size - cnt; /* 여기를 생각 못함 */

		while (true) {
			if (answer.length() == size - k)
				break;
			int idx = start;
			char bigger = '0';
			for (int i = start; i <= end; i++) {
				// 가장 큰 수 찾기
				if (i >= number.length())
					break;
				if (bigger < number.charAt(i)) {
					bigger = number.charAt(i);
					idx = i;
				}
			}
			answer.append(bigger);
			start = idx + 1;
			end = size - --cnt;
		}

		return answer.toString();
	}
}
