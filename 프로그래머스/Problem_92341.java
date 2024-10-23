package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Problem_92341 {
	public static void main(String[] args) {
		solution(new int[] {120, 0, 60, 591}, new String[] {
				"16:00 3961 IN", "17:00 2541 IN"
		});
	}

	public static int[] solution(int[] fees, String[] records) {
		Map<String, Integer> map = new HashMap();
		Map<String, Integer> result = new HashMap();
		
		String[] arr;
		String[] temp;
		int time;
		String key;
		for(int i = 0; i < records.length; i++) {
			arr = records[i].split(" ");
			temp = arr[0].split(":");
			time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
			
			key = arr[1].toString();
			if(arr[2].equals("IN"))
				map.put(key, time);
			else {
				if(result.containsKey(key)) {
					result.put(key, result.get(key) + (time - map.get(key)));
					map.remove(key);
				}
				else {
					result.put(key, time - map.get(key));
					map.remove(key);
				}
			}
		}
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			key = keys.next();
			time = (23 * 60 + 59) - map.get(key);
			if(result.containsKey(key)) {
				result.put(key, result.get(key) + time);
			}
			else {
				result.put(key, time);
			}
		}
		
		int	referenceTime = fees[0];
		int	baseFee = fees[1];
		double	unitTime = fees[2];
		int	unitFee = fees[3];
		
		keys = result.keySet().iterator();
		int calculator;
		while(keys.hasNext()) {
			key = keys.next();
			if(result.get(key) - referenceTime > 0) {
				calculator = (int) (baseFee + Math.ceil(((result.get(key) - referenceTime) / unitTime)) * unitFee);
			} else {
				calculator = baseFee;
			}
			result.put(key, calculator);
		}
		
		List<String> keySet = new ArrayList<String>(result.keySet());
		Collections.sort(keySet);
		
		int[] answer = new int[keySet.size()];
		for(int i = 0; i < keySet.size(); i++) {
			answer[i] = result.get(keySet.get(i));
		}
		return answer;
	}
}
