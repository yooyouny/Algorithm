import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int answer = -1;
    if (N == 1) {
      System.out.println(0);
      return;
    }
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    Queue<int[]> queue = new LinkedList<>();
    boolean[] visited = new boolean[N];
    visited[0] = true;
    queue.add(new int[]{0, arr[0], 0});// 지금 인덱스 번호, 값, 현재 점프수

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[1] == 0) {
        continue;
      }
      if (cur[0] == N - 1) {
        answer = cur[2];
        break;
      }

      for (int i = 1; i <= cur[1]; i++) {
        int newIdx = cur[0] + i;
        if (newIdx >= N) {
          break;
        }
        if (!visited[newIdx]) {
          visited[newIdx] = true;
          queue.add(new int[]{newIdx, arr[newIdx], cur[2] + 1});
        }
      }
    }

    System.out.println(answer);
  }
}