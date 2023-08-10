import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int[] info) {
        int[] ryan = dfs(0, new int[11], n, info);
        if (ryan == null) {
            return new int[] { -1 };
        }
        return ryan;
    }
    private int[] dfs(int index, int[] score, int n, int[] apeach) {
        if (index == score.length) {
            //if (n > 0) return null;
            if (getScoreDiff(apeach, score) <= 0) return null; // 어피치가 이긴경우 
            return Arrays.stream(score).toArray();
        }

        int maxDiff = 0;
        int[] result = null;

        for (int hit = 0; hit <= n; hit++) {
            score[index] = hit;
            int[] ryan = dfs(index + 1, score, n - hit, apeach);
            if (ryan == null) continue;

            int diff = getScoreDiff(apeach, ryan);
            if (diff > maxDiff || (diff == maxDiff && isValid(result, ryan))) {
                maxDiff = diff;
                result = ryan;
            }
        }

        return result;
    }
    private int getScoreDiff(int[] apeach, int[] ryan) {
        int diff = 0;
        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i]) {
                diff -= 10 - i;
            } else {
                diff += 10 - i;
            }
        }
        return diff;
    }
    private boolean isValid(int[] result, int[] ryan) {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] == result[i]) continue;
            return ryan[i] > result[i];
        }
        return false;
    }
}