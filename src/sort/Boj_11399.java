package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] time = new int[N];
		int sum = 0;
		int prev = 0;

		for(int i=0; i<N; i++){
			time[i]= sc.nextInt();
		}

		Arrays.sort(time);

		for(int i=0; i<N; i++){
			sum += prev + time[i]; //문제에서 요구하는 전체사람 대기시간
			prev += time[i]; //이전사람 대기시간
		}

		System.out.println(sum);

	}
}
