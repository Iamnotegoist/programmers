package 프로그래머스.레벨2;

public class Problem_72412 {
	public static void main(String[] args) {
		solution(
				new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
				new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
				);
	}

	public static int[] solution(String[] info, String[] query) {
		String[][] users = new String[info.length][5];
		for(int i = 0; i < info.length; i++) {
			users[i] = info[i].split(" ");
		}
		
		for(int i = 0; i < query.length; i++) {
			for(String s : query[i].split(" ")) {
				if(s.equals("and")) {
					continue;
				}
				
			}
		}
		
		int[] answer = {};
		return answer;
	}
}
