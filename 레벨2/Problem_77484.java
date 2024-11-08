package 레벨2;

import java.util.ArrayList;
import java.util.List;

public class Problem_77484 {
	public static void main(String[] args) {
		solution(
				new int[] {44, 1, 0, 0, 31, 25},
				new int[] {31, 10, 45, 1, 6, 19}
				);
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		List<Integer> checkNum = new ArrayList<Integer>();
		for(int i = 0; i < win_nums.length; i++) {
			checkNum.add(win_nums[i]);
		}
		
		int count = 0;
		int zeroCount = 0;
		for(int i= 0; i < 6; i++) {
			if(checkNum.contains(lottos[i])) {
				count++;
			}
			if(lottos[i] == 0) {
				zeroCount++;
			}
		}
		
		int min = count;
		int max = count + zeroCount;
		
		int[] result = new int[2];
		result[0] = rank(max);
		result[1] = rank(min);
		return result;
	}
	
	public static int rank(int n) {
		if(n >= 2) {
			return 7 - n;
		}
		else return 6;
	}
}
