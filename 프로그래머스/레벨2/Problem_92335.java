package 프로그래머스.레벨2;

public class Problem_92335 {
	public static void main(String[] args) {
		System.out.println(solution(797161, 3));
	}
	public static int solution(int n, int k) {
		String str = "";
		while (n > 0) {
			str = Integer.toString(n % k) + str;
			n = n / k;
		}
		
		String[] arr = str.split("0+");
		
		long i;
		int answer = 0;
		for(String s: arr) {
			i = Long.parseLong(s);
			if(i == 1) continue;
			
			if(isPrimeNumber(i)) {
				answer++;
			}
		}
		return answer;
	}
	
	public static boolean isPrimeNumber(long n) {
		if(n <= 1) return false;
		for(long i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
}
