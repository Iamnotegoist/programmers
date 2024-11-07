package 프로그래머스.Greedy;

import java.util.Arrays;

public class Problem_42885 {
	public static void main(String[] args) {
		solution(new int[] { 90, 50, 70, 60, 80 }, 130);
	}

	public static int solution(int[] people, int limit) {
		// 사람들의 몸무게 배열을 오름차순으로 정렬
		Arrays.sort(people);

		int left = 0; // 가장 가벼운 사람을 가리키는 포인터
		int right = people.length - 1; // 가장 무거운 사람을 가리키는 포인터
		int boatCount = 0; // 필요한 구명보트의 수

		// 두 포인터가 만나기 전까지 반복
		while (left <= right) {
			// 가장 가벼운 사람과 가장 무거운 사람을 같이 태울 수 있는지 확인
			if (people[left] + people[right] <= limit) {
				// 둘을 같이 태울 수 있다면, 왼쪽 포인터를 한 칸 오른쪽으로 이동
				left++;
			}
			// 무거운 사람은 항상 보트에 태움 (둘을 같이 태웠든, 혼자 태웠든)
			right--;
			// 보트를 하나 사용했으므로 보트 수 증가
			boatCount++;
		}

		return boatCount;
	}
}
