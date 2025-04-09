import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] di = {-1, 1, 0, 0};
  static int[] dj = {0, 0, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int maxHeight = 0;
    int answer = 0;
    int[][] landArr = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        landArr[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, landArr[i][j]);
      }
    }

    while (maxHeight >= 0) {
      boolean[][] visited = drowning(landArr, maxHeight, N);
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            cnt++;
            dfs(i, j, visited, N);
          }
        }
      }
      answer = Math.max(answer, cnt);
      maxHeight--;
    }
      
    System.out.println(answer);
  }
  public static boolean[][] drowning(int[][] landArr, int maxHeight, int N) {
    boolean[][] isMoist = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (landArr[i][j] <= maxHeight) {
          isMoist[i][j] = true;
        }
      }
    }
    return isMoist;
  }
  public static void dfs(int i, int j, boolean[][] visited, int N) {
    visited[i][j] = true;
    for (int k = 0; k < 4; k++) {
      int ni = di[k] + i;
      int nj = dj[k] + j;
      if (ni < 0 || nj < 0 || ni >= N || nj >= N || visited[ni][nj]) {
        continue;
      }
      dfs(ni, nj, visited, N);
    }
  }
}