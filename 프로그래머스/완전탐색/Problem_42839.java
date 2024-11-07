package 프로그래머스.완전탐색;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 완전탐색 / 프로그래머스 42839
 * 소수 찾기
 * 문제 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class Problem_42839 {
	public static void main(String[] args) {
		solution("17");
	}

	static boolean[] visited;
	static Set<Integer> set = new HashSet();
	public static int solution(String numbers) {
		visited = new boolean[numbers.length()];
		for(int i = 0; i < numbers.length(); i++) {
			dfs(numbers, "", 0, i + 1);
		}
		
		Iterator<Integer> iterator = set.iterator();
		int answer = 0;
		while(iterator.hasNext()) {
			if(isPrime(iterator.next())) {
				answer += 1;
			}
		}
		return answer;
	}
	public static void dfs(String numbers, String temp, int length, int m) {
		if(length == m) {
			int num = Integer.parseInt(temp);
			set.add(num);
			return;
		}
		
		for(int i = 0; i < numbers.length(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp += numbers.charAt(i);
				dfs(numbers, temp, length + 1, m);
				visited[i] = false;
				temp = temp.substring(0, length);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		if(n < 2) return false;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}
