package java.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] meeting = new int[N][2];

		for(int i=0; i<N; i++){
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}

		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0]; //종료시간이 같을 경우를 생각 못함
				return o1[1] - o2[1];
			}
		});

		int cnt = 0;
		int prev_time = 0;

		for(int i=0; i<N; i++){
			if(prev_time <= meeting[i][0]){ //이전 종료시간이 시작시간보다 작으면
				prev_time = meeting[i][1]; // 회의실 선택
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}
