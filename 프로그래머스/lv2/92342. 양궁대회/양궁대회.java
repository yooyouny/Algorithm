import java.util.Arrays;

public class Solution {
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
        return diff;// 라이언과 어피치의 점수차 리턴
    }

    private boolean isPrior(int[] base, int[] comp) {
        for (int i = 10; i >= 0; i--) {
            if (comp[i] == base[i]) continue;
            return comp[i] > base[i];
        }
        return false;
    }

    private int[] dfs(int index, int[] score, int n, int[] apeach) {
        if (index == score.length) {
            if (n > 0) return null;
            if (getScoreDiff(apeach, score) <= 0) return null; // 어피치가 이긴경우 
            return Arrays.copyOf(score, score.length);
        }

        int maxDiff = 0;
        int[] result = null;

        for (int hit = 0; hit <= n; hit++) {
            score[index] = hit;
            int[] ryan = dfs(index + 1, score, n - hit, apeach);
            if (ryan == null) continue;

            int diff = getScoreDiff(apeach, ryan);
            if (diff > maxDiff ||
                    (diff == maxDiff && isPrior(result, ryan))) {
                maxDiff = diff;
                result = ryan;
            }
        }

        return result;
    }

    public int[] solution(int n, int[] info) {
        int[] ryan = dfs(0, new int[11], n, info);
        if (ryan == null) {
            return new int[] { -1 };
        }
        return ryan;
    }
}