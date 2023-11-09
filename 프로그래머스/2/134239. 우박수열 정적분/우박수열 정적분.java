import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        // 콜라츠
        List<Double> collatzList = new ArrayList<>();
        double num = k;
        collatzList.add(num);
        while (num > 1) {
            if (num % 2 == 0)
                num /= 2;
            else
                num = num * 3 + 1;
            collatzList.add(num);
        }
        
        int size = collatzList.size();
        
        // 넓이 구하기
        double[] area = new double[size];
        for (int i = 1; i < size; i++) {
            area[i] = (collatzList.get(i - 1) + collatzList.get(i)) / 2; // 윗변 + 아랫변 * 높이 / 2
        }

        // 누적합 구하기
        double[] sum = new double[size];
        sum[1] = area[1];
        for (int i = 2; i < size; i++) {
            sum[i] = sum[i-1] + area[i];
        }

        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = (size - 1) + ranges[i][1];
            
            if (b > a) {
                answer[i] = sum[b] - sum[a];
            } else if(a > b){
                answer[i] = -1.0;
            }
        }

        return answer;
    }
}
