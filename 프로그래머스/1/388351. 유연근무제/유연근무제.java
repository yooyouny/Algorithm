class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        //boolean[] present = new boolean[schedules.length];
        int[] endTimeSchedules = getEndTime(schedules);
        for(int i=0; i<timelogs.length; i++){
            boolean isOnTime = false;
            int[] days = timelogs[i];
            for(int j=0; j<days.length; j++){
                int dayOfWeek = (startday + j) % 7;
                if(dayOfWeek == 6 || dayOfWeek == 0) continue;
                if(endTimeSchedules[i] >= days[j]){ 
                    isOnTime = true;
                }else{
                    isOnTime = false;
                    break;
                }
            }
            if(isOnTime) answer++;
        }
        
        return answer;
    }
    public int[] getEndTime(int[] schedules){
        int n = schedules.length;
        int[] endTimes = new int[n];
        for(int i=0; i<n; i++){
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100 + 10;
            if(minute > 59){
                hour++;
                minute -= 60;
            }
            //System.out.println(i+ " 번째 출근인정시각 : "+ hour + " " + minute);
            endTimes[i] = (hour * 100) + minute;
        }
        return endTimes;
    }
}