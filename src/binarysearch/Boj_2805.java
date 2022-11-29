//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2805 {
	static int[] trees;
	static int target;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		trees = new int[N];

		for(int i = 0; i < N; ++i) {
			trees[i] = sc.nextInt();
		}

		Arrays.sort(trees);
		StringBuffer sb = new StringBuffer();
		sb.append(binarySearch(0L, (long)trees[N - 1]));
		System.out.println(sb);
	}

	private static long binarySearch(long left, long right) {
		long mid = 0L;
		long result = 0L;

		while(left <= right) {
			System.out.println(left + " " + right + " " + mid);
			mid = (left + right) / 2L;
			long sum = 0L;

			for(int i = 0; i < N; ++i) {
				if ((long)trees[i] > mid) {
					sum += (long)trees[i] - mid;
				}
			}

			if (sum >= (long)target) {
				left = mid + 1L;
				result = mid;
			} else {
				right = mid - 1L;
			}
		}

		return result;
	}
}
