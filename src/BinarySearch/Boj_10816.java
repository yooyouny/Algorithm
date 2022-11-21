
package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10816 {
	static int[] A;
	static int[] B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		int M;
		for(M = 0; M < N; ++M) {
			arr[M] = sc.nextInt();
		}

		Arrays.sort(arr);
		M = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < M; ++i) {
			int key = sc.nextInt();
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}

		System.out.println(sb);
	}

	private static int lowerBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;

		while(left < right) {
			int mid = (left + right) / 2;
			if (key <= arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static int upperBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;

		while(left < right) {
			int mid = (left + right) / 2;
			if (key < arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}
