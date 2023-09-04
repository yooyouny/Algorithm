import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dcap = 0;
        int pcap = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (dcap < deliveries[i] || pcap < pickups[i]) {
                    cnt += 1;
                    dcap += cap;
                    pcap += cap;
                }
                dcap -= deliveries[i];
                pcap -= pickups[i];
                answer += ((i + 1) * cnt * 2);
            }
        }

        return answer;
    }


}