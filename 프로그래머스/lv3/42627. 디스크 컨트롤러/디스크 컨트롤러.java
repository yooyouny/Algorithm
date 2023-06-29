import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt((int[] job) -> job[0]));

        Queue<int[]> queue = new LinkedList<>(Arrays.asList(jobs));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] job) -> job[1]));

        int usage = 0;
        int now = 0;
        while (!queue.isEmpty() || !pq.isEmpty()) {
            while (!queue.isEmpty() && queue.peek()[0] <= now) {
                pq.add(queue.poll());
            }

            if (pq.isEmpty()) {
                now = queue.peek()[0];
                continue;
            }

            int[] job = pq.poll();
            usage += now + job[1] - job[0];
            now += job[1];
        }

        return usage / jobs.length;
    }
}