package 레벨2;

/*
 * 문제링크 - https://school.programmers.co.kr/learn/courses/30/lessons/150368?language=java
 */
public class Problem_150368 {
	static int discount[] = {10, 20, 30, 40};
	static int maxOfSubscribe = 0;
	static int maxOfCost = 0;
	public static void main(String[] args) {
		System.out.println(
				solution(
						new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
						new int[] {1300, 1500, 1600, 4900}
						)
				);
	}
	
	public static int[] solution(int[][] users, int[] emoticons) {
		dfs(new int[emoticons.length], users, emoticons, 0);
		int[] answer = {maxOfSubscribe, maxOfCost};
		return answer;
	}
	
	public static void dfs(int[] discounts, int[][] users, int[] emoticons, int depth) {
		if(depth == emoticons.length) {
			int subscribe = 0;
			int cost = 0;
			
			for(int[] user: users) {
				int userDiscount = user[0];
				int userMaxCost = user[1];
				
				int sum = 0;
				
				for(int i = 0; i < emoticons.length; i++) {
					if(discounts[i] >= userDiscount) {
						sum += emoticons[i] / 100 * (100 - discounts[i]);
					}
				}
				
				if(sum >= userMaxCost)
					subscribe++;
				else
					cost += sum;
			}
			
			if(subscribe > maxOfSubscribe) {
				maxOfSubscribe = subscribe;
				maxOfCost = cost;
			} else if(subscribe == maxOfSubscribe) {
				maxOfCost = Math.max(maxOfCost, cost);
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			discounts[depth] = discount[i];
			dfs(discounts, users, emoticons, depth + 1);
		}
	}
}
