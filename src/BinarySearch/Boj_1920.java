//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1920 {
	public Boj_1920() {
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] alpa = new int[N];

		int M;
		for(M = 0; M < N; ++M) {
			alpa[M] = sc.nextInt();
		}

		Arrays.sort(alpa);
		M = sc.nextInt();

		for(int i = 0; i < M; ++i) {
			int target = sc.nextInt();
			if (binarySearch(alpa, 0, N - 1, target)) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

	}

	private static boolean binarySearch(int[] alpa, int start, int end, int target) {
		int pivot = (start + end) / 2;
		if (start <= end) {
			if (alpa[pivot] == target) {
				return true;
			} else {
				return alpa[pivot] > target ? binarySearch(alpa, 0, pivot - 1, target) : binarySearch(alpa, pivot + 1, end, target);
			}
		} else {
			return false;
		}
	}
}
