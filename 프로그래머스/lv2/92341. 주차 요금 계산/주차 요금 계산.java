import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
		Map<String, Integer> map = new TreeMap<>();
        
		for (String record : records) {
			String[] token = record.split(" ");
			int time =  (token[2].equals("IN") ? -1 : 1) * parseTime(token[0]);
		
			String carNum = token[1];
			map.put(carNum, map.getOrDefault(carNum, 0) + time);
		}

		int lastTime = parseTime("23:59");
		int[] answer = new int[map.size()];
        int idx = 0;
        
		for (String key : map.keySet()) {
			int time = map.get(key);
			time = time <= 0 ? time + lastTime : time;
			double baseTime = time - fees[0] < 0 ? 0 : time - fees[0];	
			int price = fees[1] + (int) Math.ceil(baseTime / fees[2]) * fees[3];
			answer[idx++] = price;
		}

		return answer;
	}
    private int parseTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));
        return hour * 60 + minute;
    }
}