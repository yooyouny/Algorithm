//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1654 {
	static int[] lines;
	static int target;
	static int N;

	public Boj_1654() {
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		target = sc.nextInt();
		lines = new int[N];

		for(int i = 0; i < N; ++i) {
			lines[i] = sc.nextInt();
		}

		Arrays.sort(lines);
		System.out.println(binarySearch(0, lines[N - 1]));
	}

	private static int binarySearch(int start, int end) {
		int half = (start + end) / 2;
		if (start <= end) {
			int sum = 0;

			for(int i = 0; i < N; ++i) {
				if (lines[i] > half) {
					sum += lines[i] - half;
				}
			}
		}

		return 0;
	}
}
