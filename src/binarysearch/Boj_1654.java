package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int target = sc.nextInt();
		int[] lines = new int[N];

		for(int i = 0; i < N; ++i) {
			lines[i] = sc.nextInt();
		}

		Arrays.sort(lines);

		long start = 1;
		long end = lines[N-1];
		long result = 0;

		while(start<=end){
			long half = (start + end ) / 2;
			long sum = 0;
			for(int i = 0; i < N; ++i) {
				sum += lines[i] / half;
			}

			if(sum >= target){
				start = half + 1;
				result = half;
			}else{
				end = half - 1;
			}
		}
		System.out.println(result);
	}

}
