package 프로그래머스.정렬;

import java.util.Arrays;

public class Problem_4274 {
	public static void main(String[] args) {
		solution(new int[] {3, 0, 6, 1, 5});
	}

	public static int solution(int[] citations) {
		int length = citations.length;
		int answer = 0;
		Arrays.sort(citations);
		for(int i = 0; i < length; i++) {
			if(citations[i] >= (length - i)) {
				answer = length - i;
				break;
			}
		}
		return answer;
	}
}
