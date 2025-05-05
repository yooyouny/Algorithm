import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {// 맨 왼쪽
          dp[i][j] += dp[i - 1][j];
        } else if (j == i) {//맨 오른쪽
          dp[i][j] += dp[i - 1][j - 1];
        } else {// 중간
          dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        }
      }
    }

    int answer = 0;
    for (int j = 0; j < N; j++) {
      answer = Math.max(answer, dp[N - 1][j]);
    }
    System.out.println(answer);
  }
}