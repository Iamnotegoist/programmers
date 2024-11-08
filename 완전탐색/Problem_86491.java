package 완전탐색;

public class Problem_86491 {
	public static void main(String[] args) {
		solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}});
	}

	
	public static int solution(int[][] sizes) {
		int w = Integer.MIN_VALUE;
		int h = Integer.MIN_VALUE;
		for(int i = 0; i < sizes.length; i++) {
			if(sizes[i][0] < sizes[i][1]) {
				int temp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = temp;
			}
			
			if(w < sizes[i][0]) w = sizes[i][0];
			if(h < sizes[i][1]) h = sizes[i][1];
		}
		return w * h;
	}
}
